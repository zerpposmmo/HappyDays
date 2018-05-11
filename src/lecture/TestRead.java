/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import metier.Arc;
import metier.Commande;
import metier.Entrepot;
import metier.Ligne;
import metier.Localisation;
import metier.Produit;
import metier.Instance;

/**
 *
 * @author Xtree
 */
public class TestRead {
    
    public static Result getCreatedObjects(String filePath) throws IOException{
        Result result = new Result();
        
        /* LISTES BRUTES SERVANT A CREER LES OBJETS */
        Set<ProduitBrut> produitsBruts = new HashSet();
        Set<ArcBrut> arcsBruts = new HashSet();
        Set<LocalisationBrute> localisationsBrutes = new HashSet();
        Set<CommandeBrute> commandesBrutes = new HashSet();
        
        /* LISTES D'OBJETS */
        
        Map<Long, Produit> produits = new HashMap();
        Set<Arc> arcs = new HashSet();
        Map<Long, Localisation> localisations = new HashMap<>();
        Map<Long, Commande> commandes = new HashMap();
        Entrepot newEntrepot = new Entrepot();
        Instance newInstance = new Instance();
        /* VARIABLES */
        int nbLocalisations = 0;
        int nbProduits = 0;
        int nbBoxesTrolley = 0;
        int nbDimensionsCapacity = 0;
        int capaBox = 0;
        int nbCommandes = 0;
        int nbIntersections = 0;
        long departingDepot = 0;
        long arrivalDepot = 0;
        
        File file = new File(filePath);
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
                int i=0;
                while ((line = br.readLine()) != null) {
                    i++;
                    //System.out.println(i);
                    switch(line.toString()){
                        case "//Products ":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    String[] w = line.split(" ");
                                    ProduitBrut pB = new ProduitBrut(Long.parseLong(w[0]), Long.parseLong(w[1]), Integer.parseInt(w[2]), Integer.parseInt(w[3]));
                                    produitsBruts.add(pB);
                                }      
                            }
                            break;
                        case "//Arcs ":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    String[] w = line.split(" ");
                                    ArcBrut aB = new ArcBrut(Long.parseLong(w[0]), Long.parseLong(w[1]), Integer.parseInt(w[2]));
                                    arcsBruts.add(aB);
                                }  
                            }
                            break;
                        case "//Location coordinates LocationName ":
                            while((line = br.readLine()) != null){
                                if(!line.startsWith("//")){
                                    String[] w = line.split(" ");
                                    LocalisationBrute lB = new LocalisationBrute(Long.parseLong(w[0]), Integer.parseInt(w[1]), Integer.parseInt(w[2]));
                                    localisationsBrutes.add(lB); 
                                }
                            }
                            break;
                        case "//LocStart LocEnd ShortestPath ":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    String[] w = line.split(" ");
                                    ArcBrut aB = new ArcBrut(Long.parseLong(w[0]), Long.parseLong(w[1]), Integer.parseInt(w[2]));
                                    arcsBruts.add(aB);
                                }
                            }
                            break;
                        case "//Orders ":
                            List<QuantiteProduit> quantiteProduits = new ArrayList();
                            i=0;
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    if(i==0){
                                        //nbCommandes = Integer.parseInt(line.replace(" ", ""));
                                        i++;
                                    }
                                    else{
                                        String[] w = line.split(" ");
                                        i = 0;
                                        long id = Long.parseLong(w[i]);
                                        i++;
                                        int colisMax = Integer.parseInt(w[i]);
                                        i++;
                                        int nbLignes = Integer.parseInt(w[i]);
                                        i++;
                                        while(i<w.length - 1){
                                            QuantiteProduit q = new QuantiteProduit(Long.parseLong(w[i]), Integer.parseInt(w[i+1]));
                                            quantiteProduits.add(q);
                                            i++;
                                        }
                                        CommandeBrute cB = new CommandeBrute(id,colisMax,nbLignes,quantiteProduits);
                                        commandesBrutes.add(cB);
                                    }
                                }
                            }
                            break;
                        case "//NbLocations ":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    System.out.println(line);
                                    nbLocalisations = Integer.parseInt(line.replaceAll(" ",""));
                                }
                            }
                            break;
                        case "//NbProducts ":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    nbProduits = Integer.parseInt(line.replaceAll(" ",""));
                                }
                            }
                                break;
                        case "//K: NbBoxesTrolley ":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    nbBoxesTrolley = Integer.parseInt(line.replaceAll(" ",""));
                                }
                            }
                            break;
                        case "//B: CapaBox ":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    capaBox = Integer.parseInt(line.replaceAll(" ",""));
                                }
                            }
                            break;
                        case "//DepartingDepot ":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    departingDepot = Long.parseLong(line.replaceAll(" ",""));
                                }
                            }
                            break;
                        case "//ArrivalDepot":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    arrivalDepot = Long.parseLong(line.replaceAll(" ",""));
                                }
                            }
                            break;
                        case "NbVerticesIntersections ":
                            while(!(line = br.readLine()).equals(" ")){
                                if(!line.startsWith("//")){
                                    nbIntersections = Integer.parseInt(line.replaceAll(" ",""));
                                }
                            }
                            break;
                    }
                    
                }
                /* CREATION DES LOCALISATIONS */
                for(LocalisationBrute localisationB : localisationsBrutes){
                    localisations.put(localisationB.getLocalisationId(), new Localisation(localisationB.getLocalisationId(), localisationB.getX(), localisationB.getY()));
                }
                
                /* CREATION DES ARCS */
                for(ArcBrut arcB : arcsBruts){
                    Arc newArc = new Arc(localisations.get(arcB.getArriveeId()), arcB.getDistance(), localisations.get(arcB.getDepartId()));
                    arcs.add(newArc);
                    localisations.get(arcB.getDepartId()).addArc(newArc);
                }
                /* CREATION DES PRODUITS */
                for(ProduitBrut prodB : produitsBruts){
                    Produit newProduit = new Produit(prodB.getId(), localisations.get(prodB.getLocalisationId()), prodB.getPoids(), prodB.getVolume());
                    newProduit.setInstance(newInstance);
                    produits.put(prodB.getId(), newProduit);
                    localisations.get(prodB.getLocalisationId()).addProduit(newProduit);
                    
                }
                /* CREATION DES COMMANDES */
                i = 0;
                for(CommandeBrute commB : commandesBrutes){
                    
                    Set<Ligne> lignes = new HashSet();
                    Commande newCommande = new Commande(commB.getCommandeId(), commB.getColisMax(), lignes);
                    for(QuantiteProduit qP : commB.getqP()){
                        Ligne l = new Ligne(i, qP.getQuantite(), produits.get(qP.getProduitId()));
                        l.setCommande(newCommande);
                        produits.get(qP.getProduitId()).addLigne(l);
                        lignes.add(l);
                        i++;
                    }
                    commandes.put(commB.getCommandeId(), newCommande );
                }
                
                for(Localisation loc : localisations.values()){
                    newEntrepot.addLocalisation(loc);
                }
            }
            result.setArcs(arcs);
            result.setArrivalDepot(arrivalDepot);
            result.setCapaBox(capaBox);
            result.setCommandes(commandes);
            result.setDepartingDepot(departingDepot);
            result.setLocalisations(localisations);
            result.setNbBoxesTrolley(nbBoxesTrolley);
            result.setNbCommandes(nbCommandes);
            result.setNbDimensionsCapacity(nbDimensionsCapacity);
            result.setNbIntersections(nbIntersections);
            result.setNbLocalisations(nbLocalisations);
            result.setNbProduits(nbProduits);
            result.setProduits(produits);
            result.setEntrepot(newEntrepot);
            result.setInstance(newInstance);
            /* TEST AFFICHAGE OBJETS */
            //System.out.println(commandes);
            //System.out.println(arcs);
            //System.out.println(produits);

            /* TESTS VARIABLES */
            //System.out.println(nbLocalisations);
            //System.out.println(localisations.size());
            //System.out.println(nbProduits);
            //System.out.println(produits.size());

            return result;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Result result = new Result();
        result = getCreatedObjects("src/test/test.txt");
        System.out.println(result.toString());
    }
}
