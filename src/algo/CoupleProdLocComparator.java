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
public class CoupleProdLocComparator implements Comparator<CoupleProdLoc> {

    @Override
    public int compare(CoupleProdLoc o1, CoupleProdLoc o2) {
         if (o2.getIdLocalisation()> o1.getIdLocalisation()) {
            return -1;
        } else if (o2.getIdLocalisation()< o1.getIdLocalisation()) {
            return 1;
        }
        
        if(o2.getP().getId() > o1.getP().getId())
        {
            return 1;
        }
        return -1;
    }
    
}
