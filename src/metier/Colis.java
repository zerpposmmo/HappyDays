package metier;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe Colis
 *
 * @generated
 */
@javax.persistence.Entity
public class Colis {

<<<<<<< HEAD
=======
    private static Integer nbColis = 0;

>>>>>>> develop
    /**
     * Identifiant
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Id
    @javax.persistence.Column(nullable = false)
    protected Long id;

<<<<<<< HEAD
    protected static Long nbColis = (long) 0;
=======
    private Integer discriminator;

>>>>>>> develop
    /**
     * Poids maximum du colis
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected int poidsMax;

    /**
     * Volume maximum du colis
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected int volumeMax;

    /**
     * Commande liée au colis
     *
     * @generated
     * @ordered
     */
    @javax.persistence.ManyToOne(cascade = CascadeType.PERSIST)
    @javax.persistence.JoinColumn(nullable = false)
    protected Commande commande;

    /**
     * Tournée liée au colis
     *
     * @generated
     * @ordered
     */
    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(nullable = false)
    protected Tournee tournee;

    /**
     * Collection de produits liés au colis
     *
     * @generated
     * @ordered
     */
    @javax.persistence.OneToMany(mappedBy = "colis")
    protected Collection<QteProduitsColis> colisProduits;

    /**
     * Constructeur par défaut
     *
     * @generated
     */
    public Colis() {
        this.colisProduits = new HashSet<>();
        this.id=Colis.nbColis;
        Colis.nbColis ++;
        poidsMax = 0;
        volumeMax = 0;
    }

    public Colis(int poidsMax, int volumeMax, Commande commande) {
        this();
        this.poidsMax = poidsMax;
        this.volumeMax = volumeMax;
        this.commande = commande;
    }

    /**
     * Verifie le parametre commande et le set au colis
     *
     * @generated
     * @ordered
     * @param myCommande commande
     */
    public void basicSetCommande(Commande myCommande) {
        if (this.commande != myCommande) {
            if (myCommande != null) {
                if (this.commande != myCommande) {
                    Commande oldcommande = this.commande;
                    this.commande = myCommande;
                    if (oldcommande != null) {
                        oldcommande.removeColis(this);
                    }
                }
            }
        }
    }

    /**
     * Verifie le parametre tournée et le set au colis
     *
     * @generated
     * @ordered
     * @param myTournee tournée
     */
    public void basicSetTournee(Tournee myTournee) {
        if (this.tournee != myTournee) {
            if (myTournee != null) {
                if (this.tournee != myTournee) {
                    Tournee oldtournee = this.tournee;
                    this.tournee = myTournee;
                    if (oldtournee != null) {
                        oldtournee.removeColis(this);
                    }
                }
            }
        }
    }

    /**
     * Retourne l'id du colis
     *
     * @return l'id du colis
     * @generated
     * @ordered
     */
    public long getId() {
        return this.id;
    }

    /**
     * Retourne le poids max du colis
     *
     * @generated
     * @ordered
     */
    private int getPoidsMax() {
        return this.poidsMax;
    }

    /**
     * Retourne le volume max du colis
     *
     * @generated
     * @ordered
     */
    private int getVolumeMax() {
        return this.volumeMax;
    }

    /**
     * Retourne la commande du colis
     *
     * @return la commande du colis
     * @generated
     * @ordered
     */
    public Commande getCommande() {
        return this.commande;
    }

    /**
     * Retourne la tournée du colis
     *
     * @return la tournée du colis
     * @generated
     * @ordered
     */
    public Tournee getTournee() {
        return this.tournee;
    }

    /**
     * Retourne l'ensemble de produits du colis
     *
     * @return l'ensemble de produits du colis
     * @generated
     * @ordered
     */
    public Set<QteProduitsColis> getColisProduits() {
        if (this.colisProduits == null) {
            this.colisProduits = new HashSet<>();
        }
        return (Set<QteProduitsColis>) this.colisProduits;
    }

    /**
     * Ajoute un ensemble de colisProduits au colisProduits du colis
     *
     * @param newColisProduits l'ensemble de colisProduits que l'on veut ajouter
     * @generated
     * @ordered
     */
    public void addAllColisProduits(Set<QteProduitsColis> newColisProduits) {
        if (this.colisProduits == null) {
            this.colisProduits = new HashSet<>();
        }
        for (QteProduitsColis tmp : newColisProduits) {
            tmp.setColis(this);
        }

    }

    /**
     * Retire un ensemble de colisProduits au colisProduits du colis
     *
     * @param newColisProduits l'ensemble de colisProduits que l'on veut enlever
     * @generated
     * @ordered
     */
    public void removeAllColisProduits(Set<QteProduitsColis> newColisProduits) {
        if (this.colisProduits == null) {
            return;
        }

        this.colisProduits.removeAll(newColisProduits);
    }

    /**
     * Set l'identifiant du colis
     *
     * @generated
     * @ordered
     * @param myId identifiant
     */
    public void setId(long myId) {
        this.id = myId;
    }

    /**
     * Set le poids maximum du colis
     *
     * @generated
     * @ordered
     * @param myPoidsMax poids maximum
     */
    private void setPoidsMax(int myPoidsMax) {
        this.poidsMax = myPoidsMax;
    }

    /**
     * Set le volume maximum du colis
     *
     * @generated
     * @ordered
     * @param myVolumeMax volume maximum
     */
    private void setVolumeMax(int myVolumeMax) {
        this.volumeMax = myVolumeMax;
    }

    /**
     * Set la commande du colis
     *
     * @generated
     * @ordered
     * @param myCommande commande
     */
    public void setCommande(Commande myCommande) {
        this.basicSetCommande(myCommande);
        myCommande.addColis(this);
    }

    /**
     * Set la tournée du colis
     *
     * @generated
     * @ordered
     * @param myTournee tournée
     */
    public void setTournee(Tournee myTournee) {
        this.basicSetTournee(myTournee);
        myTournee.addColis(this);
    }

    /**
     * Ajoute un colisProduits au colis
     *
     * @generated
     * @ordered
     * @param newColisProduits colisProduits
     */
    public void addColisProduits(QteProduitsColis newColisProduits) {
        if (this.colisProduits == null) {
            this.colisProduits = new HashSet<>();
        }

        if (this.colisProduits.add(newColisProduits)) {
            newColisProduits.basicSetColis(this);
        }
    }

    /**
     * Unset l'identifiant du colis
     *
     * @generated
     * @ordered
     */
    public void unsetId() {
        this.id = 0L;
    }

    /**
     * Unset le poids maximum du colis
     *
     * @generated
     * @ordered
     */
    private void unsetPoidsMax() {
        this.poidsMax = 0;
    }

    /**
     * Unset le volume maximum du colis
     *
     * @generated
     * @ordered
     */
    private void unsetVolumeMax() {
        this.volumeMax = 0;
    }

    /**
     * Unset la commande du colis
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
        oldcommande.removeColis(this);
    }

    /**
     * Unset la tournée du colis
     *
     * @generated
     * @ordered
     */
    public void unsetTournee() {
        if (this.tournee == null) {
            return;
        }
        Tournee oldtournee = this.tournee;
        this.tournee = null;
        oldtournee.removeColis(this);
    }

    /**
     * Retire le colisProduits du colis
     *
     * @generated
     * @ordered
     * @param oldColisProduits colisProduits
     */
    public void removeColisProduits(QteProduitsColis oldColisProduits) {
        if (this.colisProduits == null) {
            return;
        }

        if (this.colisProduits.remove(oldColisProduits)) {
            oldColisProduits.unsetColis();
        }

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Colis other = (Colis) obj;
<<<<<<< HEAD
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
=======
        return Objects.equals(this.discriminator, other.discriminator);
>>>>>>> develop
    }

    /**
     * Permet de renvoyer la quantité max que le colis peut accepter
     *
     * @param p
     * @return la quantité max que le colis peut accepter
     */
    public int getQteMax(Produit p) {
        int poidsActuel = 0;
        int volumeActuel = 0;
        for (QteProduitsColis qtePC : this.colisProduits) {
            poidsActuel += qtePC.getQuantite() * qtePC.getProduit().getPoids();
            volumeActuel += qtePC.getQuantite() * qtePC.getProduit().getVolume();
        }
        int poidsRestant = this.poidsMax - poidsActuel;
        int volumeRestant = this.volumeMax - volumeActuel;
        int qteParPoids = (int) Math.ceil(poidsRestant / p.getPoids());
        int qteParVolume = (int) Math.ceil(volumeRestant / p.getVolume());

        if (qteParPoids < qteParVolume) {
            return qteParPoids;
        }

        return qteParVolume;
    }

}
