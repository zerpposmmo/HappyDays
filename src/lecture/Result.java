/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import metier.Arc;
import metier.Commande;
import metier.Entrepot;
import metier.Localisation;
import metier.Produit;

/**
 *
 * @author Xtree
 */
public class Result {
    
    /* LISTES D'OBJETS */
    private Map<Long, Produit> produits;
    private Set<Arc> arcs;
    private Map<Long, Localisation> localisations;
    private Map<Long, Commande> commandes;
    private Entrepot entrepot;
    
    /* VARIABLES */
    private int nbLocalisations;
    private int nbProduits;
    private int nbBoxesTrolley;
    private int nbDimensionsCapacity;
    private int capaBox;
    private int nbCommandes;
    private int nbIntersections;
    private long departingDepot;
    private long arrivalDepot;

    public Result(){
        produits = new HashMap();
        arcs = new HashSet();
        localisations = new HashMap<>();
        commandes = new HashMap();
        nbLocalisations = 0;
        nbProduits = 0;
        nbBoxesTrolley = 0;
        nbDimensionsCapacity = 0;
        capaBox = 0;
        nbCommandes = 0;
        nbIntersections = 0;
    }

    public Map<Long, Produit> getProduits() {
        return produits;
    }

    public void setProduits(Map<Long, Produit> produits) {
        this.produits = produits;
    }

    public Set<Arc> getArcs() {
        return arcs;
    }

    public void setArcs(Set<Arc> arcs) {
        this.arcs = arcs;
    }

    public Map<Long, Localisation> getLocalisations() {
        return localisations;
    }

    public void setLocalisations(Map<Long, Localisation> localisations) {
        this.localisations = localisations;
    }

    public Map<Long, Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Map<Long, Commande> commandes) {
        this.commandes = commandes;
    }

    public int getNbLocalisations() {
        return nbLocalisations;
    }

    public void setNbLocalisations(int nbLocalisations) {
        this.nbLocalisations = nbLocalisations;
    }

    public int getNbProduits() {
        return nbProduits;
    }

    public void setNbProduits(int nbProduits) {
        this.nbProduits = nbProduits;
    }

    public int getNbBoxesTrolley() {
        return nbBoxesTrolley;
    }

    public void setNbBoxesTrolley(int nbBoxesTrolley) {
        this.nbBoxesTrolley = nbBoxesTrolley;
    }

    public int getNbDimensionsCapacity() {
        return nbDimensionsCapacity;
    }

    public void setNbDimensionsCapacity(int nbDimensionsCapacity) {
        this.nbDimensionsCapacity = nbDimensionsCapacity;
    }

    public int getCapaBox() {
        return capaBox;
    }

    public void setCapaBox(int capaBox) {
        this.capaBox = capaBox;
    }

    public int getNbCommandes() {
        return nbCommandes;
    }

    public void setNbCommandes(int nbCommandes) {
        this.nbCommandes = nbCommandes;
    }

    public int getNbIntersections() {
        return nbIntersections;
    }

    public void setNbIntersections(int nbIntersections) {
        this.nbIntersections = nbIntersections;
    }

    public long getDepartingDepot() {
        return departingDepot;
    }

    public void setDepartingDepot(long departingDepot) {
        this.departingDepot = departingDepot;
    }

    public long getArrivalDepot() {
        return arrivalDepot;
    }

    public void setArrivalDepot(long arrivalDepot) {
        this.arrivalDepot = arrivalDepot;
    }

    public Entrepot getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

}
