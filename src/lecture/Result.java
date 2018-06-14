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

    public Result() {
        this.produits = new HashMap();
        this.arcs = new HashSet();
        this.localisations = new HashMap<>();
        this.commandes = new HashMap();
        this.nbLocalisations = 0;
        this.nbProduits = 0;
        this.nbBoxesTrolley = 0;
        this.nbDimensionsCapacity = 0;
        this.capaBox = new Capacite(0, 0);
        this.nbCommandes = 0;
        this.nbIntersections = 0;
        this.entrepot = new Entrepot();
        this.instance = new Instance();
    }

    /**
     * Récupère un Map contenant tous les produits
     *
     * @return un Map contenant tous les produits
     */
    public Map<Long, Produit> getProduits() {
        return produits;
    }

    /**
     * Set le Map contenant tous les produits
     *
     * @param produits Map contenant tous les produits
     */
    public void setProduits(Map<Long, Produit> produits) {
        this.produits = produits;
    }

    /**
     * Récupère le Set avec tous les arcs
     *
     * @return Set contenant tous les arcs
     */
    public Set<Arc> getArcs() {
        return arcs;
    }

    /**
     * Set le Set contenant tous les arcs
     *
     * @param arcs Set contenant tous les arcs
     */
    public void setArcs(Set<Arc> arcs) {
        this.arcs = arcs;
    }

    /**
     * Récupère le Map contenant toutes les localisations
     *
     * @return Map contenant toutes les localisations
     */
    public Map<Long, Localisation> getLocalisations() {
        return localisations;
    }

    /**
     * Set le Map contenant toutes les localisations
     *
     * @param localisations Map contenant toutes les localisations
     */
    public void setLocalisations(Map<Long, Localisation> localisations) {
        this.localisations = localisations;
    }

    /**
     * Récupère toutes les commandes
     *
     * @return un Map contenant toutes les commandes
     */
    public Map<Long, Commande> getCommandes() {
        return commandes;
    }

    /**
     * Set le Map contenant toutes les commandes
     *
     * @param commandes un Map contenant toutes les commandes
     */
    public void setCommandes(Map<Long, Commande> commandes) {
        this.commandes = commandes;
    }

    /**
     * Récupère le nombre total de localisations
     *
     * @return le nombre total de localisations
     */
    public int getNbLocalisations() {
        return nbLocalisations;
    }

    /**
     * Set le nombre total de localisations
     *
     * @param nbLocalisations le nombre total de localisations
     */
    public void setNbLocalisations(int nbLocalisations) {
        this.nbLocalisations = nbLocalisations;
    }

    /**
     * Récupère le nombre total de produits
     *
     * @return nombre total de produits
     */
    public int getNbProduits() {
        return nbProduits;
    }

    /**
     * Set le nombre total de produits
     *
     * @param nbProduits
     */
    public void setNbProduits(int nbProduits) {
        this.nbProduits = nbProduits;
    }

    /**
     * Récupère le nombre de colis sur le chariot
     *
     * @return nombre de colis sur le chariot
     */
    public int getNbBoxesTrolley() {
        return nbBoxesTrolley;
    }

    /**
     * Set le nombre de colis sur le chariot
     *
     * @param nbBoxesTrolley nombre de colis sur le chariot
     */
    public void setNbBoxesTrolley(int nbBoxesTrolley) {
        this.nbBoxesTrolley = nbBoxesTrolley;
    }

    /**
     * Récupère le nombre de dimensions pour la capacité
     *
     * @return le nombre de dimensions pour la capacité
     */
    public int getNbDimensionsCapacity() {
        return nbDimensionsCapacity;
    }

    /**
     * Set le nombre de dimensions pour la capacité
     *
     * @param nbDimensionsCapacity le nombre de dimensions pour la capacité
     */
    public void setNbDimensionsCapacity(int nbDimensionsCapacity) {
        this.nbDimensionsCapacity = nbDimensionsCapacity;
    }

    /**
     * Récupère la capacité des colis
     *
     * @return capacité des colis
     */
    public Capacite getCapaBox() {
        return capaBox;
    }

    /**
     * Set la capacité des colis
     *
     * @param capaBox capacité des colis
     */
    public void setCapaBox(Capacite capaBox) {
        this.capaBox = capaBox;
    }

    /**
     * Récupère le nombre de commandes
     *
     * @return nombre de commandes
     */
    public int getNbCommandes() {
        return nbCommandes;
    }

    /**
     * Set le nombre total de commandes
     *
     * @param nbCommandes nombre total de commandes
     */
    public void setNbCommandes(int nbCommandes) {
        this.nbCommandes = nbCommandes;
    }

    /**
     * Récupère le nombre total d'intersections
     *
     * @return le nombre total d'intersections
     */
    public int getNbIntersections() {
        return nbIntersections;
    }

    /**
     * Set le nombre total d'intersections
     *
     * @param nbIntersections nombre total d'intersections
     */
    public void setNbIntersections(int nbIntersections) {
        this.nbIntersections = nbIntersections;
    }

    /**
     * Récupère l'id du dêpot de départ
     *
     * @return l'id du dépôt de départ
     */
    public long getDepartingDepot() {
        return departingDepot;
    }

    /**
     * Set l'id du dépôt de départ
     *
     * @param departingDepot l'id du dépôt de départ
     */
    public void setDepartingDepot(long departingDepot) {
        this.departingDepot = departingDepot;
    }

    /**
     * Récupère l'id de la localisation d'arrivée
     *
     * @return l'id de la localisation d'arrivée
     */
    public long getArrivalDepot() {
        return arrivalDepot;
    }

    /**
     * Set l'id de la localisation d'arrivée
     *
     * @param arrivalDepot l'id de la localisation d'arrivée
     */
    public void setArrivalDepot(long arrivalDepot) {
        this.arrivalDepot = arrivalDepot;
    }

    /**
     * Récupère l'entrepôt
     *
     * @return l'entrepôt
     */
    public Entrepot getEntrepot() {
        return entrepot;
    }

    /**
     * Set l'entrepot
     *
     * @param entrepot l'entrepot
     */
    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

    /**
     * Récupère l'instance
     *
     * @return l'instance
     */
    public Instance getInstance() {
        return instance;
    }

    /**
     * Set l'instance
     *
     * @param instance l'instance
     */
    public void setInstance(Instance instance) {
        this.instance = instance;
    }
}
