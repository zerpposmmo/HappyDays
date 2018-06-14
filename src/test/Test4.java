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
        Result result;
        ReadFiles readFiles = new ReadFiles();
        try {
            //création des objets
            result= readFiles.getCreatedObjects("src/files/instance_0116_131940_Z2.txt");
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
            HashSet commandes = new HashSet();
            for (Map.Entry<Long, Commande> entry : result.getCommandes().entrySet()) {
                commandes.add(entry.getValue());
            }
            Algorithme a = new Algorithme(result.getInstance(), commandes, result);
            a.creerSolution();
            WriteSolution.ecrireSolution(i);
            System.out.println(a);
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
