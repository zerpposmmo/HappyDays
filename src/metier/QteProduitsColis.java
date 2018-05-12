package metier;

/**
 * Classe quantité de produit par colis (Nommée QPC)
 *
 * @generated
 */
@javax.persistence.Entity
public class QteProduitsColis {

    /**
     * ID de la QPC
     *
     * @generated
     * @ordered
     */

    @javax.persistence.Id
    @javax.persistence.Column(nullable = false)
    protected Long id;

    /**
     * Quantité de la QPC
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected int quantite;

    /**
     * Produit lié à la QPC
     *
     * @generated
     * @ordered
     */
    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(nullable = false)
    protected Produit produit;

    /**
     * Colis de la QPC
     *
     * @generated
     * @ordered
     */
    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(nullable = false)
    protected Colis colis;

    /**
     * Constructeur par défaut de la QPC
     *
     * @generated
     */
    public QteProduitsColis() {
        super();
    }

    /**
     * Ajout basique d'un produit à la QPC
     *
     * @generated
     * @ordered
     * @param myProduct Le produit à ajouter à la QPC
     */
    public void basicSetProduit(Produit myProduit) {
        if (this.produit != myProduit) {
            if (myProduit != null) {
                if (this.produit != myProduit) {
                    Produit oldproduit = this.produit;
                    this.produit = myProduit;
                    if (oldproduit != null) {
                        oldproduit.removeColisProduits(this);
                    }
                }
            }
        }
    }

    /**
     * Ajout basique d'un colis à la QPC
     *
     * @generated
     * @ordered
     * @param myColis Colis à ajouter à la QPC
     */
    public void basicSetColis(Colis myColis) {
        if (this.colis != myColis) {
            if (myColis != null) {
                if (this.colis != myColis) {
                    Colis oldcolis = this.colis;
                    this.colis = myColis;
                    if (oldcolis != null) {
                        oldcolis.removeColisProduits(this);
                    }
                }
            }
        }
    }

    /**
     * Récupère l'ID de la QPC
     *
     * @generated
     * @ordered
     */
    public long getId() {
        return this.id;
    }

    /**
     * Récupère la quantité de la QPC
     *
     * @generated
     * @ordered
     */
    private int getQuantite() {
        return this.quantite;
    }

    /**
     * Récupère le produit de la QPC
     *
     * @generated
     * @ordered
     */
    public Produit getProduit() {
        return this.produit;
    }

    /**
     * Récupère le colis lié à la QPC
     *
     * @generated
     * @ordered
     */
    public Colis getColis() {
        return this.colis;
    }

    /**
     * Définit l'ID de la QPC
     *
     * @generated
     * @ordered
     * @param myId ID à définir
     */
    public void setId(long myId) {
        this.id = myId;
    }

    /**
     * Définit la quantité de la QPC
     *
     * @generated
     * @ordered
     * @param myQuantite Quantité à ajouter
     */
    private void setQuantite(int myQuantite) {
        this.quantite = myQuantite;
    }

    /**
     * Définit le produit lié à la QPC
     *
     * @generated
     * @ordered
     * @param myProduit Produit que l'on veut ajouter
     */
    public void setProduit(Produit myProduit) {
        this.basicSetProduit(myProduit);
        myProduit.addColisProduits(this);
    }

    /**
     * Définit un colis à la QPC
     *
     * @generated
     * @ordered
     * @param myColis Le colis que l'on veut ajouter
     */
    public void setColis(Colis myColis) {
        this.basicSetColis(myColis);
        myColis.addColisProduits(this);
    }

    /**
     * Retire l'ID de la QPC
     *
     * @generated
     * @ordered
     */
    public void unsetId() {
        this.id = 0L;
    }

    /**
     * Retire la quantité de la QPC
     *
     * @generated
     * @ordered
     */
    private void unsetQuantite() {
        this.quantite = 0;
    }

    /**
     * Retire le produit de la QPC
     *
     * @generated
     * @ordered
     */
    public void unsetProduit() {
        if (this.produit == null) {
            return;
        }
        Produit oldproduit = this.produit;
        this.produit = null;
        oldproduit.removeColisProduits(this);
    }

    /**
     * Retire le colis de la QPC
     *
     * @generated
     * @ordered
     */
    public void unsetColis() {
        if (this.colis == null) {
            return;
        }
        Colis oldcolis = this.colis;
        this.colis = null;
        oldcolis.removeColisProduits(this);
    }

}
