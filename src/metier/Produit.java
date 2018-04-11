package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Produit
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
	protected int poids;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int volume;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "produit") 
	protected Set<Ligne> ligne;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Localisation localisation;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "produit") 
	protected Set<QteProduitsColis> colisProduits;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Instance instance;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Produit(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetLocalisation(Localisation myLocalisation) {
		if (this.localisation != myLocalisation) {
			if (myLocalisation != null){
				if (this.localisation != myLocalisation) {
					Localisation oldlocalisation = this.localisation;
					this.localisation = myLocalisation;
					if (oldlocalisation != null)
						oldlocalisation.removeProduit(this);
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
	public void basicSetInstance(Instance myInstance) {
		if (this.instance != myInstance) {
			if (myInstance != null){
				if (this.instance != myInstance) {
					Instance oldinstance = this.instance;
					this.instance = myInstance;
					if (oldinstance != null)
						oldinstance.removeProduit(this);
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
	private int getPoids() {
		return this.poids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private int getVolume() {
		return this.volume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Ligne> getLigne() {
		if(this.ligne == null) {
				this.ligne = new HashSet<Ligne>();
		}
		return (Set<Ligne>) this.ligne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Localisation getLocalisation() {
		return this.localisation;
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
	public Instance getInstance() {
		return this.instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllLigne(Set<Ligne> newLigne) {
		if (this.ligne == null) {
			this.ligne = new HashSet<Ligne>();
		}
		for (Ligne tmp : newLigne)
			tmp.setProduit(this);
		
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
			tmp.setProduit(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllLigne(Set<Ligne> newLigne) {
		if(this.ligne == null) {
			return;
		}
		
		this.ligne.removeAll(newLigne);
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
	private void setPoids(int myPoids) {
		this.poids = myPoids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setVolume(int myVolume) {
		this.volume = myVolume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addLigne(Ligne newLigne) {
		if(this.ligne == null) {
			this.ligne = new HashSet<Ligne>();
		}
		
		if (this.ligne.add(newLigne))
			newLigne.basicSetProduit(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setLocalisation(Localisation myLocalisation) {
		this.basicSetLocalisation(myLocalisation);
		myLocalisation.addProduit(this);
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
			newColisProduits.basicSetProduit(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setInstance(Instance myInstance) {
		this.basicSetInstance(myInstance);
		myInstance.addProduit(this);
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
	private void unsetPoids() {
		this.poids = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetVolume() {
		this.volume = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeLigne(Ligne oldLigne) {
		if(this.ligne == null)
			return;
		
		if (this.ligne.remove(oldLigne))
			oldLigne.unsetProduit();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetLocalisation() {
		if (this.localisation == null)
			return;
		Localisation oldlocalisation = this.localisation;
		this.localisation = null;
		oldlocalisation.removeProduit(this);
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
			oldColisProduits.unsetProduit();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetInstance() {
		if (this.instance == null)
			return;
		Instance oldinstance = this.instance;
		this.instance = null;
		oldinstance.removeProduit(this);
	}

	
}

