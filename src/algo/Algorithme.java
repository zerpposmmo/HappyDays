package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import lecture.Result;
import metier.Commande;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import metier.Colis;
import metier.Instance;
import metier.Ligne;
import metier.Produit;
import metier.QteProduitsColis;
import metier.Solution;
import metier.Tournee;

/**
 * Les méthodes se découpent en 3 parties, Alpha de l'algorithme V1 de
 * l'algorithme utilisé pour la partie 1 du projet V2 de l'algorithme utilisé
 * pour la partie 3 du projet
 *
 * @author Samuel
 */
public class Algorithme {

    /**
     * Instance sur lequel l'algo va travailler
     */
    private Instance instance;
    private Set<Commande> commandes;
    private Integer qteTotalCommandes;
    private Result results;
    private int poids;
    private int volume;

    /**
     * Constructeur par données
     *
     * @param i L'instance
     * @param cs Un ensemble de commande
     * @param r Le résultat
     */
    public Algorithme(Instance i, Set<Commande> cs, Result r) {
        this.instance = i;
        this.commandes = cs;
        this.qteTotalCommandes = 0;
        this.results = r;
        this.poids = 0;
        this.volume = 0;
    }

    /**
     * Crée le tableau de Produit -> QuantiteProduit que nous utilisons par la
     * suite pour la création des colis
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Map<Long, List<Ligne>> creerTableauProduits() throws CloneNotSupportedException {
        Map<Long, List<Ligne>> listLignesMapByIdProd = new HashMap();
        for (Commande c : commandes) {
            for (Ligne l : c.getLigneSet()) {
                if (listLignesMapByIdProd.containsKey(l.getProduit().getId())) {
                    listLignesMapByIdProd.get(l.getProduit().getId()).add((Ligne) l.clone());
                } else {
                    List<Ligne> lignes = new ArrayList<Ligne>();
                    lignes.add((Ligne) l.clone());
                    listLignesMapByIdProd.put(l.getProduit().getId(), lignes);
                }
                this.qteTotalCommandes += l.getQuantite();
            }
        }
        return listLignesMapByIdProd;
    }
    
    /**
     * V2 de l'algorithme Permet d'affecter un produit à un colis dejà existant,
     * il faut que les colis appartienne bien à la commande passée en paramètre
     *
     * @param colisCmd
     * @param cmd
     * @param produit
     * @param qteEsperee
     * @return
     */
    private Integer ajouterProdAColisAffectes(List<Colis> colisCmd, Commande cmd, Produit produit, Integer qteEsperee) {
        int quantiteProduitMaxDansColis;
        int qteAffectee = 0;
        for (Colis c : colisCmd) {
            if (c.getCommande().getId() == cmd.getId()) {
                quantiteProduitMaxDansColis = c.getQteMax(produit);
                if (quantiteProduitMaxDansColis > 0 && qteEsperee > 0) {
                    if (quantiteProduitMaxDansColis <= qteEsperee) {
                        c.addColisProduits(new QteProduitsColis(quantiteProduitMaxDansColis, produit));
                        qteAffectee += quantiteProduitMaxDansColis;
                        qteEsperee -= quantiteProduitMaxDansColis;
                    } else {
                        c.addColisProduits(new QteProduitsColis(qteEsperee, produit));
                        qteAffectee += qteEsperee;
                        qteEsperee = 0;
                    }
                }
            }
            if (c.getCommande().getId() != cmd.getId()) {
                System.out.println("Wrong");
            }
        }
        return qteAffectee;
    }

    /**
     * V2 de l'algorithme Ajoute un produit à une tournée
     *
     * @param cmd Commande dans laquelle se trouve le colis dans lequel on
     * ajoute le produit
     * @param produit Produit à rajouter
     * @param quantite Quantité de produit à rajouter
     * @param tournee La tournee dans laquel on veut ajouter le produit
     * @return
     */
    private Integer ajouterProdATournee(Commande cmd, Produit produit, int quantite, Tournee tournee) {
        Integer qteAffectee = 0;
        Integer quantiteProduitMaxDansColis = 0;
        Integer qteEsperee = quantite;
        Integer nbColis = tournee.getColisSet().size();
        Set<Colis> acolisCmd = tournee.getColisSet(cmd.getId());
        ArrayList<Colis> colisCmd = new ArrayList<Colis>(acolisCmd);

        //Aléatoire appliquée sur les colis
        Collections.shuffle(colisCmd, this.instance.getSeed());

        qteAffectee = ajouterProdAColisAffectes(colisCmd, cmd, produit, qteEsperee);
        qteEsperee = qteEsperee - qteAffectee;

        // S'il faut créer de nouveaux colis, en crée
        while (qteEsperee > 0 && nbColis < this.results.getNbBoxesTrolley()) {
            Colis newColis = new Colis(this.results.getCapaBox().getPoids(), this.results.getCapaBox().getVolume(), cmd);
            newColis.setTournee(tournee);
            // Renvoye le nombre max de produit possiblement à ajouter au colis peut etre > à qte ou < à qte
            quantiteProduitMaxDansColis = newColis.getQteMax(produit);
            if (qteEsperee > 0) {
                if (quantiteProduitMaxDansColis <= qteEsperee) {
                    newColis.addColisProduits(new QteProduitsColis(quantiteProduitMaxDansColis, produit));
                    qteAffectee += quantiteProduitMaxDansColis;
                    qteEsperee -= quantiteProduitMaxDansColis;
                } else {
                    newColis.addColisProduits(new QteProduitsColis(qteEsperee, produit));
                    qteAffectee += qteEsperee;
                    qteEsperee = 0;
                }
            }
        }
        return qteAffectee;
    }

    /**
     * Crée une tournée et ajoute des produits à cette dernière
     *
     * @param tabCouple tableau contenant tous les produits et leur localisation
     * @param listLignesMapByIdProd Notre tableau Produit -> QuantiteProduit
     */
    public void creerTournee(CoupleProdLoc[] tabCouple, Map<Long, List<Ligne>> listLignesMapByIdProd) {
        Tournee newTournee;
        Integer qteAffecteeATournee = 0;

        Solution sol = new Solution();
        sol.setNom("Solution_" + LocalDateTime.now());
        sol.setInstance(instance);

        while (this.qteTotalCommandes > 0) {
            newTournee = new Tournee(sol);
            for (CoupleProdLoc cpl : tabCouple) {
                List<Ligne> lignesCmds = listLignesMapByIdProd.get(cpl.getP().getId());
                //Ici on pourrait rajouter de l'aléatoire sur la liste;
                Collections.shuffle(lignesCmds, this.instance.getSeed());
                for (Ligne ligneDeCmd : lignesCmds) {
                    if (ligneDeCmd.getQuantite() > 0) {
                        qteAffecteeATournee = this.ajouterProdATournee(ligneDeCmd.getCommande(), ligneDeCmd.getProduit(), ligneDeCmd.getQuantite(), newTournee);
                        this.qteTotalCommandes = this.qteTotalCommandes - qteAffecteeATournee;
                        ligneDeCmd.setQuantite(ligneDeCmd.getQuantite() - qteAffecteeATournee);
                        if (qteAffecteeATournee > 0) {
                            if (!newTournee.getChemin().getRoute().contains(ligneDeCmd.getProduit())) {
                                newTournee.getChemin().addProduit(ligneDeCmd.getProduit());
                            }
                        }
                    }
                }
            }
            sol.setDistance(newTournee.getChemin().getDistance() + sol.getDistance());
        }
    }
    
    /**
     * Version 2 de l'algorithme Permet de renvoyer un tableau contenant des
     * objets de type Couple en ordre croissant par rapport à leurs variables
     * idLocalisation Si nbChemin sont égaux alors c'est l'id de la ligne du
     * Couple qui va déterminer la comparaison.
     *
     * @param c Commande que être traitée
     * @return Couple[] tableau de Couple par ordre décroissant
     */
    public Couple[] nbPath(Commande c) {
        CoupleComparator cp = new CoupleComparator();
        Set<Couple> tabNbPath2 = new TreeSet<>(cp);
        for (Ligne line1 : c.getLigneSet()) {
            tabNbPath2.add(new Couple(line1, (int) line1.getProduit().getLocalisation().getId()));
        }
        Couple[] myCouples = tabNbPath2.toArray(new Couple[tabNbPath2.size()]);
        return myCouples;
    }

    /**
     * V1 de l'algorithme Permet de créer une solution à partir des algorithmes
     * présents ici.
     */
    public void creerSolution() {

        Solution s = new Solution();
        s.setNom("Solution_" + LocalDateTime.now());
        s.setInstance(instance);
        //On fait une commande à la fois 
        HashSet myStacks = new HashSet<Stack>();
        for (Commande c : commandes) {
            Stack myStack;
            Couple[] tabCouple = this.nbPath(c);
            myStack = this.resoudreV4(tabCouple);
            myStacks.add(myStack);
        }

        for (Iterator it = myStacks.iterator(); it.hasNext();) {
            Stack<Couple> oneStack = (Stack<Couple>) it.next();
            //Création des tournées
            this.creerTournees(oneStack, s);
        }
    }

    /**
     * VERSION 2 de l'algorithme (partie 3) Permet de créer une solution basé
     * sur l'algorithme amélioré
     */
    public void creerSolutionUpdated() throws CloneNotSupportedException {

        Map<Long, List<Ligne>> listLignesMapByIdProd = new HashMap();

        // On doit créer notre tableau Produit -> QuantiteProduit
        listLignesMapByIdProd = this.creerTableauProduits();

        //Tableau ordonné de produit en fonction de l'id localisation
        CoupleProdLoc[] tabCouple = this.getTabProduit(commandes);

        this.creerTournee(tabCouple, listLignesMapByIdProd);
    }

    /**
     * Alpha de l'algorithme Résolution d'un chemin par récurrence
     *
     * @param myStack
     * @param tabProd
     * @param ligne
     * @param i
     * @param tabProdDansPile
     * @return
     */
    private Stack resoudre(Stack myStack, Ligne[] tabProd, Ligne ligne, int index, HashSet<Ligne> tabProdDansPile) {
        //Critère d'arret
        if (myStack.size() == tabProd.length) {
            return myStack;
        }
        //Si pile vide
        if (myStack.empty()) {
            myStack.push(ligne);
            tabProdDansPile.add(ligne);
            return resoudre(myStack, tabProd, tabProd[0], 0, tabProdDansPile);
        }
        Ligne lastLigne = (Ligne) myStack.peek();
        //Si le produit est déjà dans la pile
        if (myStack.contains(ligne)) {
            //Si non dernier element de tabProd
            if (index < tabProd.length - 1) {
                return resoudre(myStack, tabProd, tabProd[index + 1], index + 1, tabProdDansPile);
            }
            //Si dernier
            if (myStack.peek().equals(ligne)) {
                return null;// pas de solution car dernier du tableau et de la pile
            }
        }
        //Si pas de chemin
        if (!lastLigne.getProduit().existPath(ligne.getProduit())) {
            //On regarde le suivant, si il n'est pas dernier
            if (index < tabProd.length - 1) {
                return resoudre(myStack, tabProd, tabProd[index + 1], index + 1, tabProdDansPile);
            }
            //C'est le dernier du tableau 
            //Pas de solution il faut dépiler
            lastLigne = (Ligne) myStack.pop();
            int key = getKey(tabProd, lastLigne);
            tabProdDansPile.remove(lastLigne);
            return resoudre(myStack, tabProd, tabProd[key + 1], key + 1, tabProdDansPile);
        }
        //Il existe un chemin
        myStack.push(ligne);
        tabProdDansPile.add(ligne);
        return resoudre(myStack, tabProd, tabProd[0], 0, tabProdDansPile);
    }

    /**
     * Récupère la ligne de commande dans un tableau de lignes
     *
     * @param tab Le tableau de lignes à parcourir
     * @param l La ligne que l'on souhaite récupérer
     * @return Renvoie i, l'élément correspondant à la recherche, -1 sinon
     */
    private int getKey(Ligne[] tab, Ligne l) {
        int i;
        for (i = 0; i < tab.length; i++) {
            if (tab[i].equals(l)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Récupère le couple dans un tableau de couple
     *
     * @param tab Le tableau de couples à parcourir
     * @param l Le couple que l'on souhaite récupérer
     * @return Renvoie i, l'élément correspondant à la recherche, -1 sinon
     */
    private int getKey(Couple[] tab, Couple l) {
        int i;
        for (i = 0; i < tab.length; i++) {
            if (tab[i].equals(l)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Version 1 de l'algorithme Permet de rechercher le prochain produit à
     * aller récupérer
     *
     * @param lines Ensemble de lignes de commande
     * @param myStack Pile de lignes
     * @param index Index du produit à aller rechercher
     * @return Le prochain produit que l'on va récupérer
     */
    private Ligne chercheNext(Ligne[] lines, Stack<Ligne> myStack, int index) {
        int i = index;
        if (!myStack.empty()) {
            Ligne depart = myStack.peek();
            for (; i < lines.length; i++) {
                if (!myStack.contains(lines[i])) {
                    if (depart.getProduit().existPath(lines[i].getProduit())) {
                        return lines[i];
                    }
                }
            }
            return null;
        }
        for (; i < lines.length; i++) {
            return lines[i];
        }
        return null;
    }

    /**
     * V1 de l'algorithme
     *
     * @param lignes Ensemble des lignes de commande
     * @param myStack représentation d'une pile permettant de tracer le chemin à
     * réaliser
     * @param l
     * @return
     */
    private Stack resoudrev2(Ligne[] lignes, Stack<Ligne> myStack, Ligne l) {
        Ligne next;
        // si pile pleine ou chariot plein
        if (myStack.size() == lignes.length || this.poids > 12000 * 6 || this.volume > 92160 * 6) {
            return myStack;
        }
        // si pile vide ou chariot vide
        if (myStack.size() == 0 && l == null) {
            next = chercheNext(lignes, myStack, 0);
            return resoudrev2(lignes, myStack, next);
        }
        //Si la ligne n'est pas défini -> pas de solution
        if (l == null) {
            Ligne lastLine;
            int key;
            //Il faut dépiler une fois
            if (!myStack.peek().equals(lignes[lignes.length - 1])) {
                lastLine = myStack.pop();
                this.poids -= lastLine.getProduit().getPoids() * lastLine.getQuantite();
                this.volume -= lastLine.getProduit().getVolume() * lastLine.getQuantite();
                //Il faut dépiler 2 fois car le dernier est le dernier de la liste donc la ligne précédente est une ligne morte
            } else {
                lastLine = myStack.pop();
                this.poids -= lastLine.getProduit().getPoids() * lastLine.getQuantite();
                this.volume -= lastLine.getProduit().getVolume() * lastLine.getQuantite();
                lastLine = myStack.pop();
                this.poids -= lastLine.getProduit().getPoids() * lastLine.getQuantite();
                this.volume -= lastLine.getProduit().getVolume() * lastLine.getQuantite();
            }
            key = getKey(lignes, lastLine);
            next = chercheNext(lignes, myStack, key + 1);
            return resoudrev2(lignes, myStack, next);
        }
        //On empile la ligne de produit
        myStack.push(l);
        this.poids += l.getProduit().getPoids() * l.getQuantite();
        this.volume += l.getProduit().getVolume() * l.getQuantite();
        next = chercheNext(lignes, myStack, 0);
        return resoudrev2(lignes, myStack, next);
    }

    /**
     * VERSION 2 de l'algorithme Permet de créer un tableau contenant les
     * produits ordonnées par ID de Localisation croissant
     *
     * @param c Commande voulant être traitée
     * @return Couple[] tableau de Couple par ordre décroissant
     */
    public CoupleProdLoc[] getTabProduit(Set<Commande> commandes) {
        CoupleProdLocComparator cp = new CoupleProdLocComparator();
        Set<CoupleProdLoc> tabNbPath2 = new TreeSet<>(cp);
        for (Commande c : commandes) {
            for (Ligne line1 : c.getLigneSet()) {
                CoupleProdLoc possibleCouple = new CoupleProdLoc(line1.getProduit(), (long) line1.getProduit().getLocalisation().getId());
                if (!tabNbPath2.contains(possibleCouple)) {
                    tabNbPath2.add(possibleCouple);
                }
            }
        }
        CoupleProdLoc[] tabProduitLocalisation = tabNbPath2.toArray(new CoupleProdLoc[tabNbPath2.size()]);
        return tabProduitLocalisation;
    }

    /**
     * VERSION 1 de l'algorithme Permet à partir un tableau de couples rangés
     * par ordre décroissant de renvoyer la pile de chemins correspondants.
     *
     * @param myCouples
     * @return
     */
    private Stack<Couple> resoudreV4(Couple[] myCouples) {
        Stack<Couple> s = new Stack<Couple>();
        int index = 0;
        int dernierAjoute;
        while (s.size() != myCouples.length && s != null) {
            if (s.empty()) {
                int i = 0;
                s.push(myCouples[i]);
                dernierAjoute = i;
            }
            for (; index < myCouples.length; index++) {
                if (!s.contains(myCouples[index]) && s.peek().getL().getProduit().existPath(myCouples[index].getL().getProduit())) {
                    s.push(myCouples[index]);
                    break;
                }
            }
            //Pas eu d'ajout a la pile, on dépile
            if (!s.peek().equals(myCouples[index])) {
                index = getKey(myCouples, s.pop());
                index++;
                if (index >= myCouples.length) {
                    index = getKey(myCouples, s.pop());
                    index++;
                }
            } //Si le dernier element de la pile == element à l'index is ok on continue sinon on pops
            else {
                index = 0;
            }
        }
        return s;
    }

    /**
     * V1 de l'algorithme Méthode permettant de créer les tournées
     *
     * @param myStack
     * @param solution
     */
    public void creerTournees(Stack<Couple> myStack, Solution solution) {
        Tournee myTournee;
        int qteProduit = myStack.firstElement().getL().getCommande().getNbProduit();
        Stack<Couple> copyStack = (Stack<Couple>) myStack.clone();
        int index, qteMax;
        //Tant que la quantité de produit n'est pas  = 0
        while (qteProduit > 0) {
            myTournee = new Tournee();
            //Création des colis de la tournée
            for (index = 0; index < this.results.getNbBoxesTrolley(); index++) {
                myTournee.addColis(new Colis(this.results.getCapaBox().getPoids(), this.results.getCapaBox().getVolume(), myStack.firstElement().getL().getCommande()));
            }

            for (Couple p : copyStack) {
                if (p.getL().getQuantite() > 0) {
                    for (Colis c : myTournee.getColisSet()) {
                        qteMax = c.getQteMax(p.getL().getProduit());
                        //Si le colis ne peut pas contenir tout le lot
                        if (qteMax <= p.getL().getQuantite() && qteMax > 0) {
                            c.addColisProduits(new QteProduitsColis(qteMax, myStack.get(copyStack.indexOf(p)).getL().getProduit()));
                            qteProduit -= qteMax;
                            copyStack.get(copyStack.indexOf(p)).getL().setQuantite(p.getL().getQuantite() - qteMax);
                        } // Si le colis peut contenir tout le lot
                        else if (p.getL().getQuantite() > 0 && qteMax > 0) {
                            c.addColisProduits(new QteProduitsColis(p.getL().getQuantite(), myStack.get(copyStack.indexOf(p)).getL().getProduit()));
                            qteProduit -= p.getL().getQuantite();
                            copyStack.get(copyStack.indexOf(p)).getL().setQuantite(0);
                        }
                    }
                }
            }
            solution.addTournee(myTournee);
        }
    }

    /**
     * Getter instance
     *
     * @return
     */
    public Instance getInstance() {
        return instance;
    }

}
