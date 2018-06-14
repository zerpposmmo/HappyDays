package algo;

import metier.Produit;

/**
 * Couple Produit, id d'une localisation
 *
 * @author Samuel
 */
public class CoupleProdLoc implements Comparable {

    private Produit p;

    private Long idLocalisation;

    /**
     * Constructeur par données
     *
     * @param p le produit
     * @param idLocalisation l'id de la localisation
     */
    public CoupleProdLoc(Produit p, Long idLocalisation) {
        this.p = p;
        this.idLocalisation = idLocalisation;
    }

    //-----------Getter-------------//
    /**
     * Récupère le produit
     * @return le produit
     */
    public Produit getP() {
        return p;
    }

    /**
     * Récupère l'id de la localisation
     * @return l'id de la localisation
     */
    public Long getIdLocalisation() {
        return idLocalisation;
    }

    /**
     * Compare l'objet avec un autre objet passé en paramètre
     *
     * @param o Objet à comparer avec avec l'objet instancié
     * @return
     */
    @Override
    public int compareTo(Object o) {
        CoupleProdLoc o2 = (CoupleProdLoc) o;
        if (o2.getIdLocalisation() > this.getIdLocalisation()) {
            return -1;
        } else if (o2.idLocalisation < this.idLocalisation) {
            return 1;
        }

        if (o2.getP().getId() > this.getP().getId()) {
            return 1;
        }
        return -1;
    }

}
