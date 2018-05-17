/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import algo.Algorithme;
import algo.Couple;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
import lecture.ReadFiles;
import metier.Commande;
import metier.Instance;
import metier.Ligne;
import metier.Produit;

/**
 * Lit un fichier de test et regarde les chemins existants entre la 2iè localisation et les autres
 * @author Samuel
 */
public class Test2 {

    
    public static void main(String[] args) {
        Result r;
        try {
            //création des objets
            r = ReadFiles.getCreatedObjects("src/test/test2.txt");
            //System.out.println(r.toString());
            //récupération instance
            Instance i = r.getInstance();
            HashSet<Produit> ps;
            ps = (HashSet<Produit>) i.getProduitSet();

            HashMap<Long, Produit> p1 = (HashMap<Long, Produit>) r.getProduits();
            Produit p2;
            Long y;
            y = (long) 2;
            p2 = p1.get(y);
            for (Produit p : ps) {
                //System.out.println(p.toString());
                if (p2.existPath(p)) {
                    System.out.println("Path exist from " + p2.getId() + " to " + p.getId() + "\n");
                } else {
                    System.err.print("Path does not exist from " + p2.getId() + " to " + p.getId() + "\n");
                }
            }
          
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
