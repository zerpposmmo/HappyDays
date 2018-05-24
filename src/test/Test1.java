/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
import lecture.ReadFiles;
import metier.Instance;
import metier.Produit;

/**
 * Lecture des fichiers et création des objets 
 * Vérification de l'existence de path
 * @author Samuel
 */
public class Test1 {
    public static void main(String[] args){
        Result r;
        try {
            //création des objets
            r = ReadFiles.getCreatedObjects("src/test/test.txt");
            //System.out.println(r.toString());
            //récupération instance
            Instance i = r.getInstance();
            HashSet<Produit> ps;
            ps = (HashSet<Produit>) i.getProduitSet();
            
            HashMap<Long, Produit> p1 = (HashMap<Long, Produit>) r.getProduits();
            Produit p2;
            Long y;
            y = (long) 190;
            p2 = p1.get(y);
            
            Produit p3 = p1.get((long) 281);
            
            if(p2.existPath(p3)){
                    System.out.println("Path exist between "+p2.getId()+" and "+ p3.getId()+"\n");
                }
                else {
                    System.err.print("Path does not exist between "+p2.getId()+" and "+ p3.getId()+"\n");
                }
            
            
            for(Produit p : ps){
                //System.out.println(p.toString());
                if(p2.existPath(p)){
                    System.out.println("Path exist from "+p2.getId()+" to "+ p.getId()+"\n");
                }
                else {
                    System.err.print("Path does not exist from "+p2.getId()+" to "+ p.getId()+"\n");
                }
            }
       
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
