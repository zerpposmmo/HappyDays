/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import algo.Algorithme;
import ecriture.WriteSolution;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.ReadFiles;
import lecture.Result;
import metier.Commande;
import metier.Instance;
import metier.Produit;

/**
 *
 * @author Samuel
 */
public class Test5 {
    public static void main(String[] args) {
        Result result;
        ReadFiles readFiles = new ReadFiles();
        try {
            //création des objets
            result = readFiles.getCreatedObjects("src/files/instance_0116_131940_Z2.txt");
            //System.out.println(r.toString());
            //récupération instance
            Instance i = result.getInstance();
            HashSet<Produit> ps;
            ps = (HashSet<Produit>) i.getProduitSet();

            HashMap<Long, Produit> p1 = (HashMap<Long, Produit>) result.getProduits();
            Produit p2;
            Long y;
            y = (long) 190;
            p2 = p1.get(y);

            Produit p3 = p1.get((long) 281);

            /*if (p2.existPath(p3)) {
                System.out.println("Path exist between " + p2.getId() + " and " + p3.getId() + "\n");
            } else {
                System.err.print("Path does not exist between " + p2.getId() + " and " + p3.getId() + "\n");
            }

            for (Produit p : ps) {
                //System.out.println(p.toString());
                if (p2.existPath(p)) {
                    System.out.println("Path exist from " + p2.getId() + " to " + p.getId() + "\n");
                } else {
                    System.err.print("Path does not exist from " + p2.getId() + " to " + p.getId() + "\n");
                }
            }*/
            HashSet commandes = new HashSet();
            for (Map.Entry<Long, Commande> entry : result.getCommandes().entrySet()) {
                //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                commandes.add(entry.getValue());
            }
            Algorithme a = new Algorithme(result.getInstance(), commandes, result);
            try {
                a.creerSolutionUpdated();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Test5.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(a.toString());
            //Stack<Couple> ac= a.nbPath();
            //Stack<Ligne> ab= a.creerSolution();
           // WriteSolution.ecrireSolution(i);
            System.out.println(a);
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
