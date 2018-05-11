package metier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



/**
 * Classe Colis
 * @generated
 */
 
@javax.persistence.Entity 
public class Colis
{
	/**
	 * Identifiant
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected Long id;

	/**
	 * Poids maximum du colis
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int poidsMax;

	/**
	 * Volume maximum du colis
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int volumeMax;

	/**
	 * Commande liée au colis
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Commande commande;

	/**
	 * Tournée liée au colis
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Tournee tournee;

	/**
	 * Collection de produits liés au colis
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "colis") 
	protected Collection<QteProduitsColis> colisProduits;

	/**
	 * Constructeur par défaut
	 * @generated
	 */
	public Colis(){
		this.colisProduits = new HashSet<>();
                poidsMax = 0;
                volumeMax = 0;
	}

	/**
	 * Verifie le parametre commande et le set au colis
	 * @generated
	 * @ordered
         * @param myCommande commande
	 */
	public void basicSetCommande(Commande myCommande) {
		if (this.commande != myCommande) {
			if (myCommande != null){
				if (this.commande != myCommande) {
					Commande oldcommande = this.commande;
					this.commande = myCommande;
					if (oldcommande != null)
						oldcommande.removeColis(this);
				}
			}
		}
	}

	/**
	 * Verifie le parametre tournée et le set au colis
	 * @generated
	 * @ordered
         * @param myTournee tournée
	 */
	public void basicSetTournee(Tournee myTournee) {
		if (this.tournee != myTournee) {
			if (myTournee != null){
				if (this.tournee != myTournee) {
					Tournee oldtournee = this.tournee;
					this.tournee = myTournee;
					if (oldtournee != null)
						oldtournee.removeColis(this);
				}
			}
		}
	}

	/**
	 * Retourne l'id du colis
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Retourne le poids max du colis
	 * @generated
	 * @ordered
	 */
	private int getPoidsMax() {
		return this.poidsMax;
	}

	/**
	 * Retourne le volume max du colis
	 * @generated
	 * @ordered
	 */
	private int getVolumeMax() {
		return this.volumeMax;
	}

	/**
	 * Retourne la commande du colis
	 * @generated
	 * @ordered
	 */
	public Commande getCommande() {
		return this.commande;
	}

	/**
	 * Retourne la tournée du colis
	 * @generated
	 * @ordered
	 */
	public Tournee getTournee() {
		return this.tournee;
	}

	/**
	 * Retourne l'ensemble de produits du colis
	 * @generated
	 * @ordered
	 */
	public Set<QteProduitsColis> getColisProduits() {
		if(this.colisProduits == null) {
				this.colisProduits = new HashSet<QteProduitsColis>();
		}
		return (Set<QteProduitsColis>) this.colisProduits;
	}

	/**
	 * Ajoute un ensemble de colisProduits au colisProduits du colis
	 * @generated
	 * @ordered
	 */
	public void addAllColisProduits(Set<QteProduitsColis> newColisProduits) {
		if (this.colisProduits == null) {
			this.colisProduits = new HashSet<QteProduitsColis>();
		}
		for (QteProduitsColis tmp : newColisProduits)
			tmp.setColis(this);
		
	}

	/**
	 * Retire un ensemble de colisProduits au colisProduits du colis
	 * @generated
	 * @ordered
	 */
	public void removeAllColisProduits(Set<QteProduitsColis> newColisProduits) {
		if(this.colisProduits == null) {
			return;
		}
		
		this.colisProduits.removeAll(newColisProduits);
	}

	/**
	 * Set l'identifiant du colis
	 * @generated
	 * @ordered
         * @param myId identifiant
	 */
	public void setId(long myId) {
		this.id = myId;
	}

	/**
	 * Set le poids maximum du colis
	 * @generated
	 * @ordered
         * @param myPoidsMax poids maximum
	 */
	private void setPoidsMax(int myPoidsMax) {
		this.poidsMax = myPoidsMax;
	}

	/**
	 * Set le volume maximum du colis
	 * @generated
	 * @ordered
         * @param myVolumeMax volume maximum
	 */
	private void setVolumeMax(int myVolumeMax) {
		this.volumeMax = myVolumeMax;
	}

	/**
	 * Set la commande du colis
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
	 * @generated
	 * @ordered
         * @param newColisProduits colisProduits
	 */
	public void addColisProduits(QteProduitsColis newColisProduits) {
		if(this.colisProduits == null) {
			this.colisProduits = new HashSet<QteProduitsColis>();
		}
		
		if (this.colisProduits.add(newColisProduits))
			newColisProduits.basicSetColis(this);
	}

	/**
	 * Unset l'identifiant du colis
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * Unset le poids maximum du colis
	 * @generated
	 * @ordered
	 */
	private void unsetPoidsMax() {
		this.poidsMax = 0;
	}

	/**
	 * Unset le volume maximum du colis
	 * @generated
	 * @ordered
	 */
	private void unsetVolumeMax() {
		this.volumeMax = 0;
	}

	/**
	 * Unset la commande du colis
	 * @generated
	 * @ordered
	 */
	public void unsetCommande() {
		if (this.commande == null)
			return;
		Commande oldcommande = this.commande;
		this.commande = null;
		oldcommande.removeColis(this);
	}

	/**
	 * Unset la tournée du colis
	 * @generated
	 * @ordered
	 */
	public void unsetTournee() {
		if (this.tournee == null)
			return;
		Tournee oldtournee = this.tournee;
		this.tournee = null;
		oldtournee.removeColis(this);
	}

	/**
	 * Retire le colisProduits du colis
	 * @generated
	 * @ordered
         * @param oldColisProduits colisProduits
	 */
	public void removeColisProduits(QteProduitsColis oldColisProduits) {
		if(this.colisProduits == null)
			return;
		
		if (this.colisProduits.remove(oldColisProduits))
			oldColisProduits.unsetColis();
		
	}

	
}

