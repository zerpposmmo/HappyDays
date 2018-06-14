package metier;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;

/**
 * Classe Commande
 *
 * @generated
 */
@javax.persistence.Entity
public class Commande {

    /**
     * ID de la commande
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Id
    @javax.persistence.Column(nullable = false)
    // @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * ColisMax : Nombre maximum de colis dans une commande
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected int colisMax;

    /**
     * Ensemble de lignes dans la commande représentant un produit donné
     *
     * @generated
     * @ordered
     */
    @javax.persistence.OneToMany(cascade = CascadeType.PERSIST, mappedBy = "commande")
    protected Set<Ligne> ligneSet;

    /**
     * Ensemble de colis composant la commande
     *
     * @generated
     * @ordered
     */
    @javax.persistence.OneToMany(cascade = CascadeType.PERSIST, mappedBy = "commande")
    protected Set<Colis> colisSet;

    /**
     * Constructeur par défaut
     *
     * @generated
     */
    public Commande() {
        super();
        this.colisSet = new HashSet();
        this.ligneSet = new HashSet();
    }

    /**
     * Constructeur par données
     *
     * @param id ID de la commande
     * @param colisMax Nombre de colis Max de la commande
     * @param ligneSet Ensemble de ligne de produits
     */
    public Commande(Long id, int colisMax, Set<Ligne> ligneSet) {
        this.id = id;
        this.colisMax = colisMax;
        this.ligneSet = ligneSet;
    }

    /**
     * Récupère l'ID de la commande
     *
     * @return l'id de la commande
     * @generated
     * @ordered
     */
    public long getId() {
        return this.id;
    }

    /**
     * Récupère la quantité de colis maximum de la commande
     *
     * @generated
     * @ordered
     */
    private int getColisMax() {
        return this.colisMax;
    }

    /**
     * Récupère l'ensemble des lignes de produit de la commande
     *
     * @return l'ensemble des lignes de produits de la commande
     * @generated
     * @ordered
     */
    public Set<Ligne> getLigneSet() {
        if (this.ligneSet == null) {
            this.ligneSet = new HashSet<>();
        }
        return (Set<Ligne>) this.ligneSet;
    }

    /**
     * Récupère l'ensemble des colis de la commande
     *
     * @return l'ensemble des colis de la commande
     * @generated
     * @ordered
     */
    public Set<Colis> getColisSet() {
        if (this.colisSet == null) {
            this.colisSet = new HashSet<>();
        }
        return (Set<Colis>) this.colisSet;
    }

    /**
     * Ajouter un ensemble de lignes de produits à la commande actuelle
     *
     * @generated
     * @ordered
     * @param newLigne Ensemble de lignes à ajouter
     */
    public void addAllLigne(Set<Ligne> newLigne) {
        if (this.ligneSet == null) {
            this.ligneSet = new HashSet<>();
        }
        for (Ligne tmp : newLigne) {
            tmp.setCommande(this);
        }

    }

    /**
     * Ajoute un ensemble de colis à la commande actuelle
     *
     * @generated
     * @ordered
     * @param newColis Ensemble de colis à rajouter
     */
    public void addAllColis(Set<Colis> newColis) {
        if (this.colisSet == null) {
            this.colisSet = new HashSet<>();
        }
        for (Colis tmp : newColis) {
            tmp.setCommande(this);
        }

    }

    /**
     * Retire l'ensemble des lignes de produits de la commande
     *
     * @generated
     * @ordered
     * @param newLigne Ensemble de ligne à retirer
     */
    public void removeAllLigne(Set<Ligne> newLigne) {
        if (this.ligneSet == null) {
            return;
        }

        this.ligneSet.removeAll(newLigne);
    }

    /**
     * Retire l'ensemble des colis de la commande
     *
     * @generated
     * @ordered
     * @param newColis Ensemble de colis à retirer
     */
    public void removeAllColis(Set<Colis> newColis) {
        if (this.colisSet == null) {
            return;
        }

        this.colisSet.removeAll(newColis);
    }

    /**
     * Permet de définir l'ID d'une commande
     *
     * @generated
     * @ordered
     * @param myId ID à fixer
     */
    public void setId(long myId) {
        this.id = myId;
    }

    /**
     * Permet de définir le nombre maximal de colis d'une commande
     *
     * @generated
     * @ordered
     * @param myColisMax nombre maximale de colis à fixer
     */
    private void setColisMax(int myColisMax) {
        this.colisMax = myColisMax;
    }

    /**
     * Ajoute une ligne donnée à l'ensemble des lignes de produits dans la
     * commande
     *
     * @generated
     * @ordered
     * @param newLigne Ligne de produit à ajouter
     */
    public void addLigne(Ligne newLigne) {
        if (this.ligneSet == null) {
            this.ligneSet = new HashSet<>();
        }

        if (this.ligneSet.add(newLigne)) {
            newLigne.basicSetCommande(this);
        }
    }

    /**
     * Ajoute un colis donné à l'ensemble des colis dans la commande
     *
     * @generated
     * @ordered
     * @param newColis Colis à ajouter
     */
    public void addColis(Colis newColis) {
        if (this.colisSet == null) {
            this.colisSet = new HashSet<>();
        }

        if (this.colisSet.add(newColis)) {
            newColis.basicSetCommande(this);
        }
    }

    /**
     * Retire l'ID de la commande
     *
     * @generated
     * @ordered
     */
    public void unsetId() {
        this.id = 0L;
    }

    /**
     * Retire le nombre de colis max de la commande
     *
     * @generated
     * @ordered
     */
    private void unsetColisMax() {
        this.colisMax = 0;
    }

    /**
     * Retire une ligne de produit à l'ensemble de lignes de produits de la
     * commande
     *
     * @generated
     * @ordered
     * @param oldLigne Ligne de produit à retirer
     */
    public void removeLigne(Ligne oldLigne) {
        if (this.ligneSet == null) {
            return;
        }

        if (this.ligneSet.remove(oldLigne)) {
            oldLigne.unsetCommande();
        }

    }

    /**
     * Retire un colis à l'ensemble des colis
     *
     * @generated
     * @ordered
     * @param oldColis Colis à retirer
     */
    public void removeColis(Colis oldColis) {
        if (this.colisSet == null) {
            return;
        }

        if (this.colisSet.remove(oldColis)) {
            oldColis.unsetCommande();
        }

    }

    /**
     * Permet de renvoyer la quantité de produit totale de la commande
     *
     * @return
     */
    public int getNbProduit() {
        int qte = 0;
        for (Ligne l : this.ligneSet) {
            qte += l.getQuantite();
        }
        return qte;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + this.colisMax;
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
        final Commande other = (Commande) obj;
        if (this.colisMax != other.colisMax) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", colisMax=" + colisMax + ", ligneSet=" + ligneSet + "} \n";
    }
}
