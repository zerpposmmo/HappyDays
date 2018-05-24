/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

import java.util.Comparator;

/**
 *
 * @author Samuel
 */
public class CoupleComparator implements Comparator<Couple>{

    public CoupleComparator() {
    }

    
    /**
     * Permet de comparer 2 objets de type Couple
     * Ordre décroissant, pas de cas d'egalité si les nombre de chemin sont egaux
     * alors l'id de la ligne détermine l'egalité
     * @param o1
     * @param o2
     * @return 
     */
    @Override
    public int compare(Couple o1, Couple o2) {
       
        if (o2.getNbChemin() > o1.getNbChemin()) {
            return -1;
        } else if (o2.getNbChemin() < o1.getNbChemin()) {
            return 1;
        }
        
        if(o2.getL().getId() > o1.getL().getId())
        {
            return 1;
        }
        return -1;
        
    }

    
    
}
