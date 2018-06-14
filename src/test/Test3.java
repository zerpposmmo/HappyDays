package test;

import algo.Algorithme;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
import lecture.TestRead;
import metier.Commande;
import metier.Instance;
import metier.Produit;

/**
 *
 * @author Samuel
 */
public class Test3 {

    public static void main(String[] args) {
        Result result;
        ReadFiles readFiles = new ReadFiles();
        try {
            //création des objets
<<<<<<< HEAD
            r = TestRead.getCreatedObjects("src/test/test2.txt");
            //System.out.println(r.toString());
=======
            result = readFiles.getCreatedObjects("src/test/test2.txt");
>>>>>>> develop
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
            System.out.println(a);
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
