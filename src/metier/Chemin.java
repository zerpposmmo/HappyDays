/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class Chemin {
    
    /**
     * Route entre différents produits
     */
    private List<Produit> route;

    private Localisation depart;
    
    private Localisation arrivee;
    
    //Permet de ne pas avoir à recalculer la distance si on appelle 
    //plusieurs fois le getter
    private boolean flag;
    
    /**
     * Distance de la route
     */
    private Double distance;
    
    /** Constructor **/ 
    
    private Chemin() {
        route = new LinkedList<Produit>();
        distance=(double) 0;
        flag = true;
    }

    public Chemin(Localisation depart, Localisation arrivee) {
        this();
        this.depart = depart;
        this.arrivee = arrivee;
    }

    
    
    
    /**
     * Renvoie la liste des produits( La route ) 
     * @return route lsite chainée de produit de la classe Produit
     */
    public List<Produit> getRoute() {
        return route;
    }

    /**
     * Renvoie la distance de la route
     * @return 
     */
    public double getDistance() {
        if(flag == false){
            this.calculerDistance();
        }
        return distance.doubleValue();
    }
    
    /**
     * Ajoute un produit à la route
     * @param produit produit a ajouter
     * @return renvoie vrai si l'aaajout c'est bien dérouler false sinon
     */
    public boolean addProduit(Produit produit){
        if(this.route.add(produit)){
            flag = false;
            // recalculer la distance;
            return true;
        }
        return false;
    }
    
    /**
     * Permet de calculer la distance totale de la route
     */
    private void calculerDistance(){
        
        this.distance = (double) 0;
        for(Produit p : this.route){
            if(this.route.indexOf(p) == 0){
                //premier élément de la chaine
                distance += depart.getDistanceTo(p.getLocalisation());
            }
            else if(this.route.indexOf(p) == this.route.size() -1){
                //dernier element la chaine
                distance+= this.route.get(this.route.indexOf(p) - 1).getDistanceTo(p);
                distance += p.getLocalisation().getDistanceTo(arrivee);
            }
            else{
                //element interne à la chaine
                distance+= this.route.get(this.route.indexOf(p) - 1).getDistanceTo(p);
               // System.out.println(distance);
            }
            
            
        }
        
        
        flag = true;
        
        
        
    }
    
    
    
    
}
