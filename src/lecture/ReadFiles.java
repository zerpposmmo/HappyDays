package lecture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import metier.Arc;
import metier.Commande;
import metier.Entrepot;
import metier.Ligne;
import metier.Localisation;
import metier.Produit;
import metier.Instance;

/**
 * Lecture de fichier texte en se basant sur le format des fichiers d'instance.
 * Création d'objets à partir du fichier lu.
 *
 * @author Julien
 */
public class ReadFiles {

    private Set<ProduitBrut> produitsBruts;
    private Set<ArcBrut> arcsBruts;
    private Set<LocalisationBrute> localisationsBrutes;
    private Set<CommandeBrute> commandesBrutes;
    private Result result;

    public ReadFiles() {
        this.produitsBruts = new HashSet();
        this.arcsBruts = new HashSet();
        this.localisationsBrutes = new HashSet();
        this.commandesBrutes = new HashSet();
        this.result = new Result();
    }

    /**
     * Crée les localisations à partir des LocalisationBrutes créees lors du
     * parsing du fichier instance.
     */
    private void creerLocalisations() {
        for (LocalisationBrute localisationB : this.localisationsBrutes) {
            Localisation newLocalisation = new Localisation(localisationB.getLocalisationId(), localisationB.getX(), localisationB.getY());
            this.result.getLocalisations().put(localisationB.getLocalisationId(), newLocalisation);
            if (localisationB.getLocalisationId() == this.result.getDepartingDepot()) {
                this.result.getInstance().setDepartingDepot(newLocalisation);
            }
            if (localisationB.getLocalisationId() == this.result.getArrivalDepot()) {
                this.result.getInstance().setArrivalDepot(newLocalisation);
            }
            this.result.getEntrepot().addLocalisation(newLocalisation);
        }
    }

    /**
     * Crée les localisations à partir des ArcsBruts crées lors du parsing du
     * fichier instance.
     */
    private void creerArcs() {
        for (ArcBrut arcB : this.arcsBruts) {
            Arc newArc = new Arc(this.result.getLocalisations().get(arcB.getArriveeId()), arcB.getDistance(), this.result.getLocalisations().get(arcB.getDepartId()));
            this.result.getArcs().add(newArc);
            this.result.getLocalisations().get(arcB.getDepartId()).addArc(newArc);
        }
    }

    /**
     * Crée les produits à partir des ProduitsBruts crées lors du parsing du
     * fichier instance.
     */
    private void creerProduits() {
        for (ProduitBrut prodB : this.produitsBruts) {
            Produit newProduit = new Produit(prodB.getId(), this.result.getLocalisations().get(prodB.getLocalisationId()), prodB.getPoids(), prodB.getVolume());
            newProduit.setInstance(this.result.getInstance());
            this.result.getProduits().put(prodB.getId(), newProduit);
            this.result.getLocalisations().get(prodB.getLocalisationId()).addProduit(newProduit);

        }
    }

    /**
     * Crée les commandes à partir des CommandesBrutes créees lors du parsing du
     * fichier instance.
     */
    private void creerCommandes() {
        int i = 0;
        for (CommandeBrute commB : this.commandesBrutes) {

            Set<Ligne> lignes = new HashSet();
            Commande newCommande = new Commande(commB.getCommandeId(), commB.getColisMax(), lignes);
            for (QuantiteProduit qP : commB.getqP()) {
                Ligne l = new Ligne(i, qP.getQuantite(), this.result.getProduits().get(qP.getProduitId()));
                l.setCommande(newCommande);
                this.result.getProduits().get(qP.getProduitId()).addLigne(l);
                lignes.add(l);
                i++;
            }
            this.result.getCommandes().put(commB.getCommandeId(), newCommande);
        }
    }

    public Result getCreatedObjects(String filePath) throws IOException {

        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            /* On parcourt tout le fichier txt pour créer nos objets */
            while ((line = br.readLine()) != null) {
                i++;
                switch (line.toString()) {
                    case "//Products ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                String[] w = line.split(" ");
                                ProduitBrut pB = new ProduitBrut(Long.parseLong(w[0]), Long.parseLong(w[1]), Integer.parseInt(w[2]), Integer.parseInt(w[3]));
                                this.produitsBruts.add(pB);
                            }
                        }
                        break;
                    case "//Arcs ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                String[] w = line.split(" ");
                                ArcBrut aB = new ArcBrut(Long.parseLong(w[0]), Long.parseLong(w[1]), Integer.parseInt(w[2]));
                                this.arcsBruts.add(aB);
                            }
                        }
                        break;
                    case "//Location coordinates LocationName ":
                        while ((line = br.readLine()) != null) {
                            if (!line.startsWith("//")) {
                                String[] w = line.split(" ");
                                LocalisationBrute lB = new LocalisationBrute(Long.parseLong(w[0]), Integer.parseInt(w[1]), Integer.parseInt(w[2]));
                                this.localisationsBrutes.add(lB);
                            }
                        }
                        break;
                    case "//LocStart LocEnd ShortestPath ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                String[] w = line.split(" ");
                                ArcBrut aB = new ArcBrut(Long.parseLong(w[0]), Long.parseLong(w[1]), Integer.parseInt(w[2]));
                                this.arcsBruts.add(aB);
                            }
                        }
                        break;
                    case "//Orders ":
                        List<QuantiteProduit> quantiteProduits = new ArrayList();
                        i = 0;
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                if (i == 0) {
                                    result.setNbCommandes(Integer.parseInt(line.replace(" ", "")));
                                    i++;
                                } else {
                                    quantiteProduits.clear();
                                    String[] w = line.split(" ");
                                    i = 0;
                                    long id = Long.parseLong(w[i]);
                                    i++;
                                    int colisMax = Integer.parseInt(w[i]);
                                    i++;
                                    int nbLignes = Integer.parseInt(w[i]);
                                    i++;
                                    while (i < w.length - 1) {
                                        QuantiteProduit q = new QuantiteProduit(Long.parseLong(w[i]), Integer.parseInt(w[i + 1]));
                                        quantiteProduits.add(q);
                                        i = i + 2;
                                    }
                                    CommandeBrute cB = new CommandeBrute(id, colisMax, nbLignes, new ArrayList<>(quantiteProduits));
                                    this.commandesBrutes.add(cB);
                                }
                            }
                        }
                        break;
                    case "//NbLocations ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                System.out.println(line);
                                result.setNbLocalisations(Integer.parseInt(line.replaceAll(" ", "")));
                            }
                        }
                        break;
                    case "//NbProducts ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                result.setNbProduits(Integer.parseInt(line.replaceAll(" ", "")));
                            }
                        }
                        break;
                    case "//K: NbBoxesTrolley ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                result.setNbBoxesTrolley(Integer.parseInt(line.replaceAll(" ", "")));
                            }
                        }
                        break;
                    case "//B: CapaBox ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                String[] w = line.split(" ");
                                i = 0;
                                int poids = Integer.parseInt(w[i]);
                                i++;
                                int volume = Integer.parseInt(w[i]);
                                result.setCapaBox(new Capacite(poids, volume));
                            }
                        }
                        break;
                    case "//DepartingDepot ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                result.setDepartingDepot(Long.parseLong(line.replaceAll(" ", "")));
                            }
                        }
                        break;
                    case "//ArrivalDepot ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                result.setArrivalDepot(Long.parseLong(line.replaceAll(" ", "")));
                            }
                        }
                        break;
                    case "//NbVerticesIntersections ":
                        while (!(line = br.readLine()).equals(" ")) {
                            if (!line.startsWith("//")) {
                                result.setNbIntersections(Integer.parseInt(line.replaceAll(" ", "")));
                            }
                        }
                        break;
                }

            }
            /* CREATION DES LOCALISATIONS */
            creerLocalisations();

            /* CREATION DES ARCS */
            creerArcs();

            /* CREATION DES PRODUITS */
            creerProduits();

            /* CREATION DES COMMANDES */
            creerCommandes();
        }
        return this.result;
    }
}
