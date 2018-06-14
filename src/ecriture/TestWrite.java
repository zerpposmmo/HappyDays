package ecriture;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Colis;
import metier.Instance;
import metier.QteProduitsColis;
import metier.Solution;
import metier.Tournee;

/**
 *
 * @author Samuel
 */
public class TestWrite {

    /**
     * Permet d'écrire les solutions présentes dans l'instance passé en
     * paramètre
     *
     * @param i instance sur laquelle au moins une solution à déjà été créé.
     */
    public static boolean ecrireSolution(Instance i) {
        PrintWriter writer = null;
        String myLineColis = "";
        try {

            for (Solution s : i.getSolutionSet()) {
                //Fichier où la solution va être écrite
                writer = new PrintWriter("src/files/solution.txt", "UTF-8");
                writer.println("//NbTournees");
                writer.println(s.getTournee().size());
                for (Tournee t : s.getTournee()) {
                    writer.println("//IdTournes NbColis");
                    writer.println(t.getId() + " " + t.getNbColis());
                    writer.println("//IdColis IdCommandeInColis NbProducts IdProd1 QtyProd1 IdProd2 QtyProd2 ...");
                    for (Colis c : t.getColisSet()) {
                        myLineColis = "";
                        if (c.getColisProduits().size() > 0) {
                            myLineColis = myLineColis.concat(c.getId() + " " + c.getCommande().getId() + " " + c.getColisProduits().size() + " ");
                            for (QteProduitsColis qpc : c.getColisProduits()) {
                                myLineColis = myLineColis.concat(qpc.getProduit().getId() + " " + qpc.getQuantite() + " ");
                            }
                            writer.println(myLineColis);
                        }
                    }
                }
                writer.close();
            }
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestWrite.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TestWrite.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
