package algo;

import java.util.Comparator;
import java.util.Objects;
import metier.Ligne;

/**
 * Couple d'objet ligne et nbChemin
 * @author Samuel
 */
public class Couple  {

    /**
     * Ligne de produit
     */
    private Ligne l;
    /**
     * Nombre de chemin disponible à partir de sa localisation vers tous les localisation des autres ligne de produit
     */
    private int nbChemin;

    /**
     * Constructeur par donnée
     * @param l ligne du produit
     * @param nbChemin nombre de chemin correspondant
     */
    public Couple(Ligne l, int nbChemin) {
        this.l = l;
        this.nbChemin = nbChemin;
    }

    /**                         Getter                             **/
    
    /**
     * Récupère la ligne produit
     * @return Ligne : la ligne
     */
    public Ligne getL() {
        return l;
    }

    /**
     * Récupère le nombre de chemin(s)
     * @return nbChemin : le nombre de chemin
     */
    public int getNbChemin() {
        return nbChemin;
    }

    
    /**                         Setter                             **/
    
    /**
     * Définit la ligne de produit 
     * @param l la ligne 
     */
    public void setL(Ligne l) {
        this.l = l;
    }

    /**
     * Définit le nbChemin
     * @param nbChemin Le nombre de chemin à définir  
     */
    public void setNbChemin(int nbChemin) {
        this.nbChemin = nbChemin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.l);
        hash = 97 * hash + this.nbChemin;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Couple other = (Couple) obj;
        if (this.nbChemin != other.nbChemin || !Objects.equals(this.l, other.l)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return "Couple{" + "l=" + l + ", nbChemin=" + nbChemin + '}';
    }
}
