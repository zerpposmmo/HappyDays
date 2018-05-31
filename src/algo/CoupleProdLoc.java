/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

import java.util.Comparator;
import metier.Produit;

/**
 * Couple Produit, id de localisation 
 * @author Samuel
 */
public class CoupleProdLoc implements Comparable{
    
    private Produit p;
    
    private Long idLocalisation;

    public CoupleProdLoc(Produit p, Long idLocalisation) {
        this.p = p;
        this.idLocalisation = idLocalisation;
    }

    public Produit getP() {
        return p;
    }

    public Long getIdLocalisation() {
        return idLocalisation;
    }

   

    @Override
    public int compareTo(Object o) {
        CoupleProdLoc o2 = (CoupleProdLoc) o;
        if (o2.getIdLocalisation()> this.getIdLocalisation()) {
            return -1;
        } else if (o2.idLocalisation < this.idLocalisation) {
            return 1;
        }
        
        if(o2.getP().getId() > this.getP().getId())
        {
            return 1;
        }
        return -1;
    }
    
    
    
    
}
