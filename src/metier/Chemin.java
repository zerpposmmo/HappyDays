/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Samuel
 */
@javax.persistence.Entity
public class Chemin {
    
    
    
    @javax.persistence.Id
    @javax.persistence.Column(nullable = false)
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    
    
    /**
     * Route entre différents produits
     */
    private transient List<Produit> route;

    
    /*@ManyToOne
    @javax.persistence.JoinColumn(nullable = false)*/
    private transient Localisation depart;
    
   /* @ManyToOne
    @javax.persistence.JoinColumn(nullable = false)*/
    private transient Localisation arrivee;
    
    //Permet de ne pas avoir à recalculer la distance si on appelle 
    //plusieurs fois le getter
    private boolean flag;
    
    /**
     * Distance de la route
     */
    @javax.persistence.Column(nullable = false)
    private Double distance;
    
    
    @OneToOne
    private Tournee tournee;
    /** Constructor **/ 
    
    @javax.persistence.OneToMany( mappedBy = "chemin", cascade = CascadeType.PERSIST)
    private Set<CheminProduit> cheminProduits;
    
    private Chemin() {
        this.route = new LinkedList<Produit>();
        this.cheminProduits = new HashSet<>();
        this.distance=(double) 0;
        this.flag = true;
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
     * Ajoute un chemin produit qui lie le produit et le chemin
     * @param cP CheminProduit
     * @return 
     */
    public boolean addCheminProduit(CheminProduit cP){
        if(this.cheminProduits.add(cP)){
            cP.getProduit().addCheminProduit(cP);
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
