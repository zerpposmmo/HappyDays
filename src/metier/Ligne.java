package metier;

import java.util.Objects;

/**
 * Classe ligne
 *
 * @generated
 */
@javax.persistence.Entity
public class Ligne {

    /**
     * ID de la ligne
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Id
    @javax.persistence.Column(nullable = false)
    protected Long id;

    /**
     * Quantité de produit dans la ligne
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected int quantite;

    /**
     * Produit concerné par la ligne
     *
     * @generated
     * @ordered
     */
    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(nullable = false)
    protected Produit produit;

    /**
     * Commande concernée par la ligne
     *
     * @generated
     * @ordered
     */
    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(nullable = false)
    protected Commande commande;

    /**
     * Constructeur par défaut de la ligne
     *
     * @generated
     */
    public Ligne() {
        super();
    }

    public Ligne(long id, int quantite, Produit produit) {
        this.id = id;
        this.quantite = quantite;
        this.produit = produit;
    }

    /**
     * Ajout basique d'un produit
     *
     * @generated
     * @ordered
     * @param myProduit Produit à ajouter
     */
    public void basicSetProduit(Produit myProduit) {
        if (this.produit != myProduit) {
            if (myProduit != null) {
                if (this.produit != myProduit) {
                    Produit oldproduit = this.produit;
                    this.produit = myProduit;
                    if (oldproduit != null) {
                        oldproduit.removeLigne(this);
                    }
                }
            }
        }
    }

    /**
     * Ajout d'une commande à la ligne
     *
     * @generated
     * @ordered
     * @param myCommande Commande à ajouter
     */
    public void basicSetCommande(Commande myCommande) {
        if (this.commande != myCommande) {
            if (myCommande != null) {
                if (this.commande != myCommande) {
                    Commande oldcommande = this.commande;
                    this.commande = myCommande;
                    if (oldcommande != null) {
                        oldcommande.removeLigne(this);
                    }
                }
            }
        }
    }

    /**
     * Récupère l'ID de la ligne
     *
     * @generated
     * @ordered
     */
    public long getId() {
        return this.id;
    }

    /**
     * Récupère la quantité de produit de la ligne
     *
     * @generated
     * @ordered
     */
    public int getQuantite() {
        return this.quantite;
    }

    /**
     * Récupère le produit de la ligne
     *
     * @generated
     * @ordered
     */
    public Produit getProduit() {
        return this.produit;
    }

    /**
     * Récupère la commande liée à la ligne
     *
     * @generated
     * @ordered
     */
    public Commande getCommande() {
        return this.commande;
    }

    /**
     * Définit l'ID de la ligne
     *
     * @generated
     * @ordered
     * @param myId ID à définir
     */
    public void setId(long myId) {
        this.id = myId;
    }

    /**
     * Définit la quantité de produit dans la ligne
     *
     * @generated
     * @ordered
     * @param myQuantite Quantité à définir
     */
    private void setQuantite(int myQuantite) {
        this.quantite = myQuantite;
    }

    /**
     * Définit un produit donné dans la ligne
     *
     * @generated
     * @ordered
     * @param myProduit Produit à définir
     */
    public void setProduit(Produit myProduit) {
        this.basicSetProduit(myProduit);
        myProduit.addLigne(this);
    }

    /**
     * Définit une commande donnée dans la ligne
     *
     * @generated
     * @ordered
     * @param myCommande Commande à définir
     */
    public void setCommande(Commande myCommande) {
        this.basicSetCommande(myCommande);
        myCommande.addLigne(this);
    }

    /**
     * Retire l'ID de la ligne
     *
     * @generated
     * @ordered
     */
    public void unsetId() {
        this.id = 0L;
    }

    /**
     * Retire la quantité dans la ligne
     *
     * @generated
     * @ordered
     */
    private void unsetQuantite() {
        this.quantite = 0;
    }

    /**
     * Retire le produit lié à la ligne
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
        oldproduit.removeLigne(this);
    }

    /**
     * Retire la commande liée à la ligne
     *
     * @generated
     * @ordered
     */
    public void unsetCommande() {
        if (this.commande == null) {
            return;
        }
        Commande oldcommande = this.commande;
        this.commande = null;
        oldcommande.removeLigne(this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Ligne other = (Ligne) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ligne{" + "id=" + id + ", quantite=" + quantite + ", produit=" + produit.toString() + '}';
    }

}
