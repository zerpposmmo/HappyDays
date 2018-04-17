package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * Classe produit
 * @generated
 */
 
@javax.persistence.Entity 
public class Produit
{
	/**
	 * ID du produit
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected Long id;

	/**
	 * Poids du produit
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int poids;

	/**
	 * Volume du produit
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int volume;

	/**
	 * Ensemble de lignes dans lesquelles figurent le produit
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "produit") 
	protected Set<Ligne> ligne;

	/**
	 * Localisation du produit
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Localisation localisation;

	/**
	 * Ensemble de quantité de produit dans un colis
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "produit") 
	protected Set<QteProduitsColis> colisProduits;

	/**
	 * Instance à laquelle le produit est lié
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Instance instance;

	/**
	 * Constructeur par défaut du produit
	 * @generated
	 */
	public Produit(){
            this.ligne = new HashSet<>();
            this.colisProduits = new HashSet<>();
	}

	/**
	 * Ajout basique d'une localisation au produit
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
	 * Ajout basique d'une instance dans le produit
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
	 * Récupère l'ID du produit
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Récupère le poids du produit
	 * @generated
	 * @ordered
	 */
	private int getPoids() {
		return this.poids;
	}

	/**
	 * Récupère le volume du produit
	 * @generated
	 * @ordered
	 */
	private int getVolume() {
		return this.volume;
	}

	/**
	 * Récupère l'ensemble des lignes de produit lié au produit
	 * @generated
	 * @ordered
	 */
	public HashSet<Ligne> getLigne() {
		if(this.ligne == null) {
				this.ligne = new HashSet<Ligne>();
		}
		return (HashSet<Ligne>) this.ligne;
	}

	/**
	 * Récupère la localisation
	 * @generated
	 * @ordered
	 */
	public Localisation getLocalisation() {
		return this.localisation;
	}

	/**
	 * Récupère l'ensemble des colis lié au produit
	 * @generated
	 * @ordered
	 */
	public HashSet<QteProduitsColis> getColisProduits() {
		if(this.colisProduits == null) {
				this.colisProduits = new HashSet<QteProduitsColis>();
		}
		return (HashSet<QteProduitsColis>) this.colisProduits;
	}

	/**
	 * Récupère l'instance lié au produit
	 * @generated
	 * @ordered
	 */
	public Instance getInstance() {
		return this.instance;
	}

	/**
	 * Ajoute l'ensemble de ligne donné au produit
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
	 * Ajoute l'ensemble des quantité de produit dans un colis dans le produit
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
	 * Retire l'ensemble des lignes du produit
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
	 * Retire l'ensemble des quantités de produit dans un colis du produit
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
	 * Définit l'ID du produit
	 * @generated
	 * @ordered
	 */
	public void setId(long myId) {
		this.id = myId;
	}

	/**
	 * Définit le poids du produit
	 * @generated
	 * @ordered
	 */
	private void setPoids(int myPoids) {
		this.poids = myPoids;
	}

	/**
	 * Ajoute le volume à un produit
         * @param myVolume Volume à ajouter au produit
	 * @generated
	 * @ordered
	 */
	private void setVolume(int myVolume) {
		this.volume = myVolume;
	}

	/**
	 * Ajout eune ligne donnée au produit
         * @param newLigne La ligne à ajouter
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
	 * Définit la localisation du produit
         * @param myLocalisation La localisation que l'on veut ajouter au produit
	 * @generated
	 * @ordered
	 */
	public void setLocalisation(Localisation myLocalisation) {
		this.basicSetLocalisation(myLocalisation);
		myLocalisation.addProduit(this);
	}

	/**
	 * Ajouter la quantité de produit d'un colis dans le produit
         * @param newColisProduits La quantité de produit d'un colis que l'on veut rajouter
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
	 * Définit l'instance du produit
         * @param myInstance l'instance que l'on veut ajouter
	 * @generated
	 * @ordered
	 */
	public void setInstance(Instance myInstance) {
		this.basicSetInstance(myInstance);
		myInstance.addProduit(this);
	}

	/**
	 * Retire l'ID du produit
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * Retire le poids du produit
	 * @generated
	 * @ordered
	 */
	private void unsetPoids() {
		this.poids = 0;
	}

	/**
	 * Retire le volume du produit
	 * @generated
	 * @ordered
	 */
	private void unsetVolume() {
		this.volume = 0;
	}

	/**
	 * Retire une ligne donnée de l'ensemble des lignes du produit
         * @param oldLigne La ligne à retirer de l'ensemble
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
	 * Retire la localisation du produit
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
	 * Retire la quantité de produit dans un colis du produit
         * @param oldColisProduits La quantité de produit dans un colis à retirer du produit
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
	 * Retire l'instance du produit
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

