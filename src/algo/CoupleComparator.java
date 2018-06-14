package algo;

import java.util.Comparator;

/**
 * @author Samuel
 */
public class CoupleComparator implements Comparator<Couple> {

    /**
     * Constructeur par défaut
     */
    public CoupleComparator() {
    }

    /**
     * Permet de comparer 2 objets de type Couple Ordre décroissant, pas de cas
     * d'egalité si les nombre de chemin sont egaux alors l'id de la ligne
     * détermine l'egalité
     *
     * @param o1 le premier couple
     * @param o2 le deuxième couple
     * @return
     */
    @Override
    public int compare(Couple o1, Couple o2) {
<<<<<<< HEAD
       
        if (o2.getNbChemin() > o1.getNbChemin()) {
=======
        if (o2.getIdLocalisation() > o1.getIdLocalisation()) {
            return -1;
        } else if (o2.getIdLocalisation() < o1.getIdLocalisation()) {
>>>>>>> develop
            return 1;
        } else if (o2.getNbChemin() < o1.getNbChemin()) {
            return -1;
        }
<<<<<<< HEAD
        
        if(o2.getL().getId() > o1.getL().getId())
        {
            return -1;
        }
        return 1;
        
=======
        if (o2.getL().getId() > o1.getL().getId()) {
            return 1;
        }
        return -1;
>>>>>>> develop
    }
}
