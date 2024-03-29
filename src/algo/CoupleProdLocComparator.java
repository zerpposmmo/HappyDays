package algo;

import java.util.Comparator;

/**
 * Comparateur d'un couple Produit, Localisation
 *
 * @author Samuel
 */
public class CoupleProdLocComparator implements Comparator<CoupleProdLoc> {

    /**
     * Compare 2 objets CoupleProdLoc passé en paramètre
     *
     * @param o1 couple à comparer
     * @param o2 couple à comparer
     * @return un int indiquant le résultat de la comparaison
     */
    @Override
    public int compare(CoupleProdLoc o1, CoupleProdLoc o2) {
        if (o2.getIdLocalisation() > o1.getIdLocalisation()) {
            return -1;
        } else if (o2.getIdLocalisation() < o1.getIdLocalisation()) {
            return 1;
        }
        if (o2.getP().getId() > o1.getP().getId()) {
            return 1;
        }
        return -1;
    }

}
