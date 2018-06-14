package algo;

import java.util.Objects;
import metier.Ligne;

/**
 * Couple d'objet ligne et idLocalisation
 *
 * @author Samuel
 */
public class Couple {

    /**
     * Ligne de produit
     */
    private Ligne l;
    /**
     * ID de la localisation du produit de la ligne
     */
    private int idLocalisation;

    /**
     * Constructeur par donnée
     *
     * @param l ligne du produit
     * @param idLocalisation nombre de chemin correspondant
     */
    public Couple(Ligne l, int idLocalisation) {
        this.l = l;
        this.idLocalisation = idLocalisation;
    }

    /**
     * ----------------------------Getter---------------------------*
     */
    /**
     * Récupère la ligne produit
     *
     * @return Ligne : la ligne
     */
    public Ligne getL() {
        return l;
    }

    /**
     * Récupère le nombre de chemin(s)
     *
     * @return nbChemin : le nombre de chemin
     */
    public int getIdLocalisation() {
        return idLocalisation;
    }

    /**
     * -----------------------------Setter---------------------------------*
     */
    /**
     * Définit la ligne de produit
     *
     * @param l la ligne
     */
    public void setL(Ligne l) {
        this.l = l;
    }

    /**
     * Set l'id de la localisation
     *
     * @param idLocalisation l'id de la localisation
     */
    public void setIdLocalisation(int idLocalisation) {
        this.idLocalisation = idLocalisation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.l);
        hash = 97 * hash + this.idLocalisation;
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
        if (this.idLocalisation != other.idLocalisation || !Objects.equals(this.l, other.l)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Couple{" + "l=" + l + ", nbChemin=" + idLocalisation + '}';
    }
}
