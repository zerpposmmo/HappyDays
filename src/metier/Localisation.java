package metier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  --> @generated
 */
@javax.persistence.Entity
public class Localisation {

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */

    @javax.persistence.Id
    @javax.persistence.Column(nullable = false)
    protected Long id;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected int x;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected int y;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    @javax.persistence.OneToMany(mappedBy = "localisation")
    protected Map<Localisation, Arc> arcMap;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    @javax.persistence.OneToMany(mappedBy = "localisation")
    protected Set<Produit> produitSet;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(nullable = false)
    protected Entrepot entrepot;

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated
     */
    public Localisation() {
        super();
        this.arcMap = new HashMap<>();
        this.produitSet = new HashSet();
    }
    
    public Localisation(long id,int x, int y) {
        this();
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
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
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public long getId() {
        return this.id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    private int getX() {
        return this.x;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    private int getY() {
        return this.y;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public Map<Localisation, Arc> getArc() {
        if (this.arcMap == null) {
            this.arcMap = new HashMap<Localisation, Arc>();
        }
        return (Map<Localisation, Arc>) this.arcMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public Set<Produit> getProduitSet() {
        if (this.produitSet == null) {
            this.produitSet = new HashSet<Produit>();
        }
        return (Set<Produit>) this.produitSet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public Entrepot getEntrepot() {
        return this.entrepot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered @param newArc Set d'arc à
     * ajouter à la localisation
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
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @param newProduit
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
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    private void removeAllArc() {
        if (this.arcMap == null) {
            return;
        }
        this.arcMap.clear();
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public void removeAllProduit(Set<Produit> newProduit) {
        if (this.produitSet == null) {
            return;
        }

        this.produitSet.removeAll(newProduit);
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public void setId(long myId) {
        this.id = myId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    private void setX(int myX) {
        this.x = myX;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    private void setY(int myY) {
        this.y = myY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public void addArc(Arc newArc) {
        if (this.arcMap == null) {
            this.arcMap = new HashMap<Localisation, Arc>();
        }
        this.arcMap.put(newArc.arrivee, newArc);
        newArc.setDepart(this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
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
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public void setEntrepot(Entrepot myEntrepot) {
        this.basicSetEntrepot(myEntrepot);
        myEntrepot.addLocalisation(this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public void unsetId() {
        this.id = 0L;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    private void unsetX() {
        this.x = 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    private void unsetY() {
        this.y = 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public void removeArc(Arc oldArc) {
        if (this.arcMap == null) {
            return;
        }
        this.arcMap.remove(oldArc.arrivee);
        oldArc.unsetDepart();
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
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
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  --> @generated @ordered
     */
    public void unsetEntrepot() {
        if (this.entrepot == null) {
            return;
        }
        Entrepot oldentrepot = this.entrepot;
        this.entrepot = null;
        oldentrepot.removeLocalisation(this);
    }

}
