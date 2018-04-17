package metier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Colis
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected Long id;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int poidsMax;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int volumeMax;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Commande commande;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Tournee tournee;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "colis") 
	protected Collection<QteProduitsColis> colisProduits;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Colis(){
		this.colisProduits = new HashSet<>();
                poidsMax = 0;
                volumeMax = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private int getPoidsMax() {
		return this.poidsMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private int getVolumeMax() {
		return this.volumeMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Commande getCommande() {
		return this.commande;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Tournee getTournee() {
		return this.tournee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setId(long myId) {
		this.id = myId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setPoidsMax(int myPoidsMax) {
		this.poidsMax = myPoidsMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setVolumeMax(int myVolumeMax) {
		this.volumeMax = myVolumeMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setCommande(Commande myCommande) {
		this.basicSetCommande(myCommande);
		myCommande.addColis(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setTournee(Tournee myTournee) {
		this.basicSetTournee(myTournee);
		myTournee.addColis(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addColisProduits(QteProduitsColis newColisProduits) {
		if(this.colisProduits == null) {
			this.colisProduits = new HashSet<QteProduitsColis>();
		}
		
		if (this.colisProduits.add(newColisProduits))
			newColisProduits.basicSetColis(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetPoidsMax() {
		this.poidsMax = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetVolumeMax() {
		this.volumeMax = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeColisProduits(QteProduitsColis oldColisProduits) {
		if(this.colisProduits == null)
			return;
		
		if (this.colisProduits.remove(oldColisProduits))
			oldColisProduits.unsetColis();
		
	}

	
}

