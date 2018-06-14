package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
<<<<<<< HEAD
import lecture.TestRead;
import metier.Commande;
=======
import lecture.ReadFiles;
>>>>>>> develop
import metier.Instance;
import metier.Produit;

/**
 * Lit un fichier de test et regarde les chemins existants entre la 2iè
 * localisation et les autres
 *
 * @author Samuel
 */
public class Test2 {

    public static void main(String[] args) {
        Result r;
        ReadFiles readFiles = new ReadFiles();
        try {
            //création des objets
<<<<<<< HEAD
            r = TestRead.getCreatedObjects("src/test/test2.txt");
            //System.out.println(r.toString());
=======
            r = readFiles.getCreatedObjects("src/test/test2.txt");
>>>>>>> develop
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
