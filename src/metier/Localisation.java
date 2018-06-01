package metier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

/**
 * Classe Localisation
 * @generated
 */
@javax.persistence.Entity
public class Localisation {

    /**
     * ID de la localisation
     * @generated 
     * @ordered
     */

    @javax.persistence.Id
    @javax.persistence.Column(nullable = false)
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Coordonnée X de la localisation
     * @generated 
     * @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected int x;

    /**
     * Coordonnée Y de la localisation
     * @generated 
     * @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected int y;

    /**
     * Ensemble d'arc de la localisation
     * @generated 
     * @ordered
     */
    //@javax.persistence.OneToMany(cascade = CascadeType.PERSIST, mappedBy = "arrivee")
    @Transient
    protected Map<Localisation, Arc> arcMap;

    /**
     * Ensemble de produit de la localisation
     * @generated 
     * @ordered
     */
    @javax.persistence.OneToMany(mappedBy = "localisation")
    protected Set<Produit> produitSet;

    /**
     * Entrepôt à laquelle la localisation est liée
     * @generated 
     * @ordered
     */
    @javax.persistence.ManyToOne(cascade = CascadeType.PERSIST)
    @javax.persistence.JoinColumn(nullable = false)
    protected Entrepot entrepot;

    /**
     * Constructeur par défaut de la localisation
     * @generated
     */
    public Localisation() {
        super();
        this.arcMap = new HashMap<>();
        this.produitSet = new HashSet();
    }
    
    /**
     * Constructeur par données
     * @param id ID de la Localisation
     * @param x Coordonnées X de la localisation
     * @param y Coordonnées Y de la localisation
     */
    public Localisation(long id,int x, int y) {
        this();
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * Ajout basique d'un entrepôt à la localisation
     * @generated 
     * @ordered
     * @param myEntrepot Entrepot à ajouter
     */
    public void basicSetEntrepot(Entrepot myEntrepot) {
        if (this.entrepot != myEntrepot) {
            if (myEntrepot != null) {
                if (this.entrepot != myEntrepot) {
                    Entrepot oldentrepot = this.entrepot;
                    this.entrepot = myEntrepot;
                    if (oldentrepot != null) {
                        oldentrepot.removeLocalisation(this);
                    }
                }
            }
        }
    }

    /**
     * Récupère l'ID de la localisation
     * @generated 
     * @ordered
     */
    public long getId() {
        return this.id;
    }

    /**
     * Récupère la coordonnée X de la localisation
     * @generated 
     * @ordered
     */
    private int getX() {
        return this.x;
    }

    /**
     * Récupère la coordonnée Y de la localisation
     * @generated 
     * @ordered
     */
    private int getY() {
        return this.y;
    }

    /**
     * Récupère l'ensenble des arcs lié à la localisation
     * @generated 
     * @ordered
     */
    public Map<Localisation, Arc> getArc() {
        if (this.arcMap == null) {
            this.arcMap = new HashMap<Localisation, Arc>();
        }
        return (Map<Localisation, Arc>) this.arcMap;
    }

    /**
     * Récupère l'ensemble des produits lié à la localisation 
     * @generated 
     * @ordered
     */
    public Set<Produit> getProduitSet() {
        if (this.produitSet == null) {
            this.produitSet = new HashSet<Produit>();
        }
        return (Set<Produit>) this.produitSet;
    }

    /**
     * Récupère l'entrepôt auquel la localisation est liée
     * @generated 
     * @ordered
     */
    public Entrepot getEntrepot() {
        return this.entrepot;
    }

    /**
     * Ajoute l'ensemble d'arc donné
     * @generated 
     * @ordered 
     * @param newArc Set d'arc à ajouter à la localisation
     */
    public void addAllArc(Set<Arc> newArc) {
        if (this.arcMap == null) {
            this.arcMap = new HashMap<>();
        }
        for (Arc tmp : newArc) {
            tmp.setDepart(this);
        }

    }

    /**
     * Ajoute l'ensemble de produit donné à la localisation
     * @param newProduit
     * @generated
     * @ordered
     */
    public void addAllProduit(Set<Produit> newProduit) {
        if (this.produitSet == null) {
            this.produitSet = new HashSet<Produit>();
        }
        for (Produit tmp : newProduit) {
            tmp.setLocalisation(this);
        }
    }

    /**
     * Retire l'ensemble d'arc de la localisation
     * @generated 
     * @ordered
     */
    private void removeAllArc() {
        if (this.arcMap == null) {
            return;
        }
        this.arcMap.clear();
    }

    /**
     * Retire l'ensemble de produits donné
     * @generated 
     * @ordered
     * @param newProduit Ensemble de produit à retirer
     */
    public void removeAllProduit(Set<Produit> newProduit) {
        if (this.produitSet == null) {
            return;
        }

        this.produitSet.removeAll(newProduit);
    }

    /**
     * Définit l'ID
     * @generated 
     * @ordered
     * @param myId ID à définir
     */
    public void setId(long myId) {
        this.id = myId;
    }

    /**
     * Définit la coordonnée X de la localisation
     * @generated 
     * @ordered
     * @param myX coordonnées X à définir
     */
    private void setX(int myX) {
        this.x = myX;
    }

    /**
     * Définit la coordonnée X de la localisation 
     * @generated 
     * @ordered
     * @param myY coordonnées Y à définir
     */
    private void setY(int myY) {
        this.y = myY;
    }

    /**
     * Ajoute un arc donné à la localisation 
     * @generated 
     * @ordered
     * @param myArc Arc à ajouter
     */
    public void addArc(Arc newArc) {
        if (this.arcMap == null) {
            this.arcMap = new HashMap<Localisation, Arc>();
        }
        this.arcMap.put(newArc.arrivee, newArc);
        newArc.setDepart(this);
    }

    /**
     * Ajoute un produit donné à la localisation
     * @generated 
     * @ordered
     * @param newProduit Produit à ajouter
     */
    public void addProduit(Produit newProduit) {
        if (this.produitSet == null) {
            this.produitSet = new HashSet<Produit>();
        }

        if (this.produitSet.add(newProduit)) {
            newProduit.basicSetLocalisation(this);
        }
    }

    /**
     * Définit l'entrepôt auquel la localisation est liée
     * @generated 
     * @ordered
     * @param myEntrepot Entrepot à définir 
     */
    public void setEntrepot(Entrepot myEntrepot) {
        this.basicSetEntrepot(myEntrepot);
        myEntrepot.addLocalisation(this);
    }

    /**
     * Retire l'ID de la localisation
     * @generated 
     * @ordered
     */
    public void unsetId() {
        this.id = 0L;
    }

    /**
     * Retire la coordonnée X de la localisation
     * @generated 
     * @ordered
     */
    private void unsetX() {
        this.x = 0;
    }

    /**
     * Retire la coordonnée Y de la localisation 
     * @generated 
     * @ordered
     */
    private void unsetY() {
        this.y = 0;
    }

    /**
     * Retire un arc donné de l'ensemble d'arcs
     * @generated 
     * @ordered
     * @param oldArc Arc à retirer
     */
    public void removeArc(Arc oldArc) {
        if (this.arcMap == null) {
            return;
        }
        this.arcMap.remove(oldArc.arrivee);
        oldArc.unsetDepart();
    }

    /**
     * Retire le produit donné de l'ensemble des produits
     * @generated 
     * @ordered
     * @param oldProduit Produit à retirer
     */
    public void removeProduit(Produit oldProduit) {
        if (this.produitSet == null) {
            return;
        }

        if (this.produitSet.remove(oldProduit)) {
            oldProduit.unsetLocalisation();
        }

    }

    /**
     * Retire l'entrepôt donné auquel la localisation est liée
     * @generated 
     * @ordered
     */
    public void unsetEntrepot() {
        if (this.entrepot == null) {
            return;
        }
        Entrepot oldentrepot = this.entrepot;
        this.entrepot = null;
        oldentrepot.removeLocalisation(this);
    }
    
    /**
     * Permet de savoir si le chemin entre les 2 localisations existe 
     * @param localisation La localisation dont on cherche un possible chemin avec la localisation courante
     * @return boolean true si existe false sinon
     */
    boolean existPath(Localisation localisation) {
        if(this.arcMap.containsKey(localisation)){
            return true;
        }
        else if(this.equals(localisation)){
            return true;
        }
        return false;
    }
    
    /**
     * Permet d'obtenir la distance entre 2 localisation
     * @param key
     * @return double distance entre les 2 localisations ou + l'infini si n'existe pas
     */
    public double getDistanceTo(Localisation key){
        Arc r = this.arcMap.get(key);
        if(this.equals(key)){
                return 0;
        }
        
        if( r == null)
        {
            //Same place
           /* if(this.equals(key)){
                return 0;
            }*/
            return Double.POSITIVE_INFINITY;
        }
        
        return r.getDistance();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + this.x;
        hash = 67 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Localisation other = (Localisation) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString() {
        return "Localisation{" + "id=" + id + ", x=" + x + ", y=" + y + ", arcMap=" + arcMap.size() + ", produitSet=" + produitSet.size() + ", entrepot=" + entrepot + "} \n";
    }

    

    
}
