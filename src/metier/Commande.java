package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * Classe Commande
 * @generated
 */
 
@javax.persistence.Entity 
public class Commande
{
    
	/**
	 * ID de la commande
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected Long id;

	/**
	 * ColisMax : Nombre maximum de colis dans une commande
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int colisMax;

	/**
	 * Ensemble de lignes dans la commande représentant un produit donné
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "commande") 
	protected Set<Ligne> ligneSet;

	/**
	 * Ensemble de colis composant la commande
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "commande") 
	protected Set<Colis> colisSet;

	/**
	 * Constructeur par défaut
	 * @generated
	 */
	public Commande(){
		super();
                this.colisSet = new HashSet();
                this.ligneSet = new HashSet(); 
	}

	/**
	 * Récupère l'ID de la commande
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Récupère la quantité de colis maximum de la commande
	 * @generated
	 * @ordered
	 */
	private int getColisMax() {
		return this.colisMax;
	}

	/**
	 * Récupère l'ensemble des lignes de produit de la commande
	 * @generated
	 * @ordered
	 */
	public Set<Ligne> getLigneSet() {
		if(this.ligneSet == null) {
				this.ligneSet = new HashSet<Ligne>();
		}
		return (Set<Ligne>) this.ligneSet;
	}

	/**
	 * Récupère l'ensemble des colis de la commande
	 * @generated
	 * @ordered
	 */
	public Set<Colis> getColisSet() {
		if(this.colisSet == null) {
				this.colisSet = new HashSet<Colis>();
		}
		return (Set<Colis>) this.colisSet;
	}

	/**
	 * Ajouter un ensemble de lignes de produits à la commande actuelle
	 * @generated
	 * @ordered
	 */
	public void addAllLigne(Set<Ligne> newLigne) {
		if (this.ligneSet == null) {
			this.ligneSet = new HashSet<Ligne>();
		}
		for (Ligne tmp : newLigne)
			tmp.setCommande(this);
		
	}

	/**
	 * Ajoute un ensemble de colis à la commande actuelle
	 * @generated
	 * @ordered
	 */
	public void addAllColis(Set<Colis> newColis) {
		if (this.colisSet == null) {
			this.colisSet = new HashSet<Colis>();
		}
		for (Colis tmp : newColis)
			tmp.setCommande(this);
		
	}

	/**
	 * Retire l'ensemble des lignes de produits de la commande
	 * @generated
	 * @ordered
	 */
	public void removeAllLigne(Set<Ligne> newLigne) {
		if(this.ligneSet == null) {
			return;
		}
		
		this.ligneSet.removeAll(newLigne);
	}

	/**
	 * Retire l'ensemble des colis de la commande
	 * @generated
	 * @ordered
	 */
	public void removeAllColis(Set<Colis> newColis) {
		if(this.colisSet == null) {
			return;
		}
		
		this.colisSet.removeAll(newColis);
	}

	/**
	 * Permet de définir l'ID d'une commande
	 * @generated
	 * @ordered
	 */
	public void setId(long myId) {
		this.id = myId;
	}

	/**
	 * Permet de définir l'ID d'une commande
	 * @generated
	 * @ordered
	 */
	private void setColisMax(int myColisMax) {
		this.colisMax = myColisMax;
	}

	/**
	 * Ajoute une ligne donnée à l'ensemble des lignes de produits dans la commande
	 * @generated
	 * @ordered
	 */
	public void addLigne(Ligne newLigne) {
		if(this.ligneSet == null) {
			this.ligneSet = new HashSet<Ligne>();
		}
		
		if (this.ligneSet.add(newLigne))
			newLigne.basicSetCommande(this);
	}

	/**
	 * Ajoute un colis donné à l'ensemble des colis dans la commande
	 * @generated
	 * @ordered
	 */
	public void addColis(Colis newColis) {
		if(this.colisSet == null) {
			this.colisSet = new HashSet<Colis>();
		}
		
		if (this.colisSet.add(newColis))
			newColis.basicSetCommande(this);
	}

	/**
	 * Retire l'ID de la commande
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * Retire le nombre de colis max de la commande
	 * @generated
	 * @ordered
	 */
	private void unsetColisMax() {
		this.colisMax = 0;
	}

	/**
	 * Retire une ligne de produit à l'ensemble de lignes de produits de la commande
	 * @generated
	 * @ordered
	 */
	public void removeLigne(Ligne oldLigne) {
		if(this.ligneSet == null)
			return;
		
		if (this.ligneSet.remove(oldLigne))
			oldLigne.unsetCommande();
		
	}

	/**
	 * Retire un colis à l'ensemble des colis
	 * @generated
	 * @ordered
	 */
	public void removeColis(Colis oldColis) {
		if(this.colisSet == null)
			return;
		
		if (this.colisSet.remove(oldColis))
			oldColis.unsetCommande();
		
	}

	
}

