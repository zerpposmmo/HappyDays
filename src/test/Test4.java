package test;

import algo.Algorithme;
import ecriture.WriteSolution;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
import lecture.ReadFiles;
import metier.Commande;
import metier.Instance;
import metier.Produit;

/**
 *
 * @author Samuel
 */
public class Test4 {
    public static void main(String[] args) {
        Result r;
        try {
            //création des objets
            r = ReadFiles.getCreatedObjects("src/files/instance_0116_131940_Z2.txt");
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
            HashSet commandes = new HashSet();
            for (Map.Entry<Long, Commande> entry : r.getCommandes().entrySet()) {
                commandes.add(entry.getValue());
            }
            Algorithme a = new Algorithme(r.getInstance(), commandes, r);
            a.creerSolution();
            WriteSolution.ecrireSolution(i);
            System.out.println(a);
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
