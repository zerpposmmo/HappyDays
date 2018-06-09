
package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import lecture.Result;
import metier.Commande;

import algo.Couple;
import java.time.LocalDateTime;
import java.util.Collection;
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
 * Classe permettant de créer les tournées
 *
 * @author Samuel
 */
public class Algorithme {

    /**
     * Instance sur lequel l'algo va travailler
     */
    private Instance instance;
    private Set<Commande> commandes;
    private Result results;
    private int poids;
    private int volume;
    
    
    /**
     * Constructeur par données
     * @param i L'instance
     * @param cs Un ensemble de commande
     * @param r  Le résultat
     */
    public Algorithme(Instance i, Set<Commande> cs, Result r) {
        this.instance = i;
        this.commandes = cs;
        this.results = r;
        this.poids = 0;
        this.volume = 0;
    }

    /**
     * Permet de créer une solution à partir des algorithmes présent ici.
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
            //Création des tournées
        }

        for (Iterator it = myStacks.iterator(); it.hasNext();) {
            Stack<Couple> oneStack = (Stack<Couple>) it.next();
            this.creerTournees(oneStack, s);
        }
    }

    /**
     * permet de créer une solution basé sur l'algorithme amélioré
     */
    public void creerSolutionUpdated() throws CloneNotSupportedException {
        Solution sol = new Solution();
        sol.setNom("Solution_" + LocalDateTime.now());
        sol.setInstance(instance);
        Map<Long, List<Ligne>> listLignesMapByIdProd = new HashMap();
        Integer qteTotalCommandes = 0;
        Tournee newTournee;
        Integer qteAffecteeATournee = 0;
        // On doit créer notre tableau Produit -> QuantiteProduit
        for (Commande c : commandes) {
            for (Ligne l : c.getLigneSet()) {
                if (listLignesMapByIdProd.containsKey(l.getProduit().getId())) {
                    listLignesMapByIdProd.get(l.getProduit().getId()).add((Ligne) l.clone());
                } else {
                    List<Ligne> lignes = new ArrayList<Ligne>();
                    lignes.add((Ligne) l.clone());
                    listLignesMapByIdProd.put(l.getProduit().getId(), lignes);
                }
                qteTotalCommandes += l.getQuantite();
            }
        }

        //Tableau ordonné de produit en fonction de l'id localisation
        CoupleProdLoc[] tabCouple = this.getTabProduit(commandes);

        while (qteTotalCommandes > 0) {
            newTournee = new Tournee(sol);

            for (CoupleProdLoc cpl : tabCouple) {
                List<Ligne> lignesCmds = listLignesMapByIdProd.get(cpl.getP().getId());
                //Ici on pourrait rajouter un .random sur la list;
                Collections.shuffle(lignesCmds);
                for (Ligne ligneDeCmd : lignesCmds) {
                    if (ligneDeCmd.getQuantite() > 0) {
                        qteAffecteeATournee = this.ajouterProdATournee(ligneDeCmd.getCommande(), ligneDeCmd.getProduit(), ligneDeCmd.getQuantite(), newTournee);
                        qteTotalCommandes = qteTotalCommandes - qteAffecteeATournee;
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

        /*for (Commande c : commandes) {
            Stack myStack;
            Couple[] tabCouple = this.nbPath(c);
            myStack = this.resoudreV4(tabCouple);
            myStacks.add(myStack);
            //Création des tournées
        }*/
    }

    /**
     *
     * @param cmd
     * @param produit
     * @param quantite
     * @param newTournee
     * @return
     */
    private Integer ajouterProdATournee(Commande cmd, Produit produit, int quantite, Tournee newTournee) {

        Random generator = new Random();

        boolean split = generator.nextBoolean();

        Integer qteAffectee = 0;
        Integer quantiteProduitMaxDansColis = 0;
        Integer qteEsperee = quantite;
        Integer nbColis = newTournee.getColisSet().size();
        Set<Colis> acolisCmd = newTournee.getColisSet(cmd.getId());

        ArrayList<Colis> colisCmd = new ArrayList<Colis>(acolisCmd);

        //Randomisation des colis
        Collections.shuffle(colisCmd);

        //On regarde si on peut ajouter le produit aux colis déjà créer
        //Ici on peut ajouter du random
        /*if (!split) {
            
        }*/
         //ajouterProdAColisAffectesNonSplitte(colisCmd, cmd, produit, qteEsperee);
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

        while (qteEsperee > 0 && nbColis < this.results.getNbBoxesTrolley()) {
            Colis newColis = new Colis(this.results.getCapaBox().getPoids(), this.results.getCapaBox().getVolume(), cmd);
            newColis.setTournee(newTournee);
            quantiteProduitMaxDansColis = newColis.getQteMax(produit); // Renvoye le nombre max de produit possiblement à ajouter au colis peut etre > à qte ou < à qte

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
     * Permet d'affecter un produit à un colis dejà existants, il faut que les
     * colis appartiennent bien à la commande passée en paramètre
     *
     * @param colisCmd
     * @param cmd
     * @param produit
     * @param qteEsperee
     * @return
     */
    private Integer ajouterProdAColisAffectesNonSplitte(List<Colis> colisCmd, Commande cmd, Produit produit, Integer qteEsperee) {
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
     * Permet d'affecter un produit à des colis dejà existants,splitté, il faut
     * que les colis appartiennent bien à la commande passée en paramètre
     *
     * @param colisCmd
     * @param cmd
     * @param produit
     * @param qteEsperee
     * @return
     */
    private Integer ajouterProdAColisAffectesSplitte(List<Colis> colisCmd, Commande cmd, Produit produit, Integer qteEsperee, Integer qteAffectee) {
        int quantiteProduitMaxDansColis;

        if (qteEsperee <= 1) {
           // return this.ajouterProdAColisAffectesNonSplitte(colisCmd, cmd, produit, qteEsperee, qteAffectee);
        }

        /*for (Colis c : colisCmd) {
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

        }*/
        return qteAffectee;
    }

    /**
     * Résolution d'un chemin par récurrence
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
     * Version 2 de resolution
     *
     * @param lignes Ensemble des lignes de commande
     * @param myStack Equivalent de la pile/chariot
     * @param l
     * @return
     */
    private Stack resoudrev2(Ligne[] lignes, Stack<Ligne> myStack, Ligne l) {
        Ligne next;
        if (myStack.size() == lignes.length || this.poids > 12000 * 6 || this.volume > 92160 * 6) { // si pile pleine ou chariot plein
            return myStack;
        }
        if (myStack.size() == 0 && l == null) { // si pile vide
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
     * Permet de rechercher le prochain produit à aller récupérer
     * @param lines
     * @param myStack
     * @param index
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
     * Permet de renvoyer un tableau contenant des objets de type Couple en
     * ordre décroissant par rapport à leurs variables nbChemin Si nbChemin sont
     * égaux alors c'est l'id de la ligne du Couple qui va déterminer la
     * comparaison.
     *
     * @param c Commande voulant être traitée
     * @return Couple[] tableau de Couple par ordre décroissant
     */
    public Couple[] nbPath(Commande c) {
        //HashMap<Ligne, Integer> tabNbPath = new HashMap<Ligne,Integer>();
        CoupleComparator cp = new CoupleComparator();
        Set<Couple> tabNbPath2 = new TreeSet<>(cp);

        for (Ligne line1 : c.getLigneSet()) {
            /*int i = 0;
            for (Ligne line2 : c.getLigneSet()) {
                if (line1.getProduit().existPath(line2.getProduit())) {
                    i++;
                }
            }*/
            //tabNbPath.put(line1, i);
            tabNbPath2.add(new Couple(line1, (int) line1.getProduit().getLocalisation().getId()));
        }

        //   System.out.println(tabNbPath.toString());
        // System.out.println(tabNbPath2.toString());
        Couple[] myCouples = tabNbPath2.toArray(new Couple[tabNbPath2.size()]);

        return myCouples;
    }

    /**
     * Permet de créer un tableau contenant les produits ordonnées
     *
     * @param c Commande voulant être traitée
     * @return Couple[] tableau de Couple par ordre décroissant
     */
    public CoupleProdLoc[] getTabProduit(Set<Commande> commandes) {
        //HashMap<Ligne, Integer> tabNbPath = new HashMap<Ligne,Integer>();
        CoupleProdLocComparator cp = new CoupleProdLocComparator();
        Set<CoupleProdLoc> tabNbPath2 = new TreeSet<>(cp);
        for (Commande c : commandes) {
            for (Ligne line1 : c.getLigneSet()) {
                /*int i = 0;
                for (Ligne line2 : c.getLigneSet()) {
                    if (line1.getProduit().existPath(line2.getProduit())) {
                        i++;
                    }
                }*/
                //tabNbPath.put(line1, i);
                CoupleProdLoc possibleCouple = new CoupleProdLoc(line1.getProduit(), (long) line1.getProduit().getLocalisation().getId());
                if (!tabNbPath2.contains(possibleCouple)) {
                    tabNbPath2.add(possibleCouple);
                }
            }
        }
        //   System.out.println(tabNbPath.toString());
        // System.out.println(tabNbPath2.toString());
        CoupleProdLoc[] tabProduitLocalisation = tabNbPath2.toArray(new CoupleProdLoc[tabNbPath2.size()]);

        return tabProduitLocalisation;
    }

    /**
     * Permet à partir un tableau de couples rangés par ordre décroissant de
     * renvoyer la pile de chemin correspondante.
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
        //System.out.println(sol.toString());
        return s;
    }

    /**
     * Méthode permettant de créer les tournées
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

                        } else if (p.getL().getQuantite() > 0 && qteMax > 0) { // Si le colis peut contenir tout le lot
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
