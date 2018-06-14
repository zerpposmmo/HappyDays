package lecture;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import metier.Arc;
import metier.Commande;
import metier.Entrepot;
import metier.Instance;
import metier.Localisation;
import metier.Produit;

/**
 *
 * @author Julien
 */
public class Result {
    
    /* LISTES D'OBJETS */
    private Map<Long, Produit> produits;
    private Set<Arc> arcs;
    private Map<Long, Localisation> localisations;
    private Map<Long, Commande> commandes;
    private Entrepot entrepot;
    private Instance instance;
    /* VARIABLES */
    private int nbLocalisations;
    private int nbProduits;
    private int nbBoxesTrolley;
    private int nbDimensionsCapacity;
    private Capacite capaBox;
    private int nbCommandes;
    private int nbIntersections;
    private long departingDepot;
    private long arrivalDepot;

    public Result(){
        this.produits = new HashMap();
        this.arcs = new HashSet();
        this.localisations = new HashMap<>();
        this.commandes = new HashMap();
        this.nbLocalisations = 0;
        this.nbProduits = 0;
        this.nbBoxesTrolley = 0;
        this.nbDimensionsCapacity = 0;
        this.capaBox=new Capacite(0,0);
        this.nbCommandes = 0;
        this.nbIntersections = 0;
        this.entrepot = new Entrepot();
        this.instance = new Instance();
    }

    //-------------------GETTER && SETTER ---------------------//
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

    public Capacite getCapaBox() {
        return capaBox;
    }

    public void setCapaBox(Capacite capaBox) {
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

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }
}
