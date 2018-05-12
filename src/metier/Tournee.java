package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * Class Tournee
 * Posséde une collection d'objet Colis et une collection d'objet Solution
 * @author Samuel
 * @generated
 */
 
@javax.persistence.Entity 
public class Tournee
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
	 * Solution de la tournée
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Solution solution;

	/**
	 * Colis qui seront livrés par la tournée
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "tournee") 
	protected Set<Colis> colisSet;

	/**
	 * Constructeur par défaut
	 * @generated
	 */
	public Tournee(){
		this.colisSet = new HashSet();
	}

	/**
	 * Permet de set la solution de la tournée 
         * en maintenant une cohérence avec les variable de Solution
	 * @generated
	 * @ordered
         * @param mySolution Solution à définir
	 */
	public void basicSetSolution(Solution mySolution) {
		if (this.solution != mySolution) {
			if (mySolution != null){
				if (this.solution != mySolution) {
					Solution oldsolution = this.solution;
					this.solution = mySolution;
					if (oldsolution != null)
						oldsolution.removeTournee(this);
				}
			}
		}
	}

	/**
	 * Getter de l'identifiant de la tournée
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Getter de la solution de la tournée
	 * @generated
	 * @ordered
	 */
	public Solution getSolution() {
		return this.solution;
	}

	/**
	 * Getter du HashSet des colis
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
	 * Permet d'ajouter un groupe de colis a la collection de colis de la tournée
	 * @generated
	 * @ordered
         * @param newColis Ensemble de colis à ajouter
	 */
	public void addAllColis(Set<Colis> newColis) {
		if (this.colisSet == null) {
			this.colisSet = new HashSet<Colis>();
		}
		for (Colis tmp : newColis)
			tmp.setTournee(this);
		
	}

	/**
	 * Permet de supprimer un ensemble de colis
	 * @generated
	 * @ordered
         * @param newColis Ensemble de colis à supprimer
	 */
	public void removeAllColis(Set<Colis> newColis) {
		if(this.colisSet == null) {
			return;
		}
		
		this.colisSet.removeAll(newColis);
	}

        
        
        
        
	/**
	 * Setter  id
	 * @generated
	 * @ordered
         * @param myId ID à définir
	 */
	public void setId(long myId) {
		this.id = myId;
	}

	/**
	 * Setter Solution
	 * @generated
	 * @ordered
         * @param mySolution Solution à définir
	 */
	public void setSolution(Solution mySolution) {
		this.basicSetSolution(mySolution);
		mySolution.addTournee(this);
	}

	/**
	 * Permet d'ajouter un colis
	 * @generated
	 * @ordered
         * @param newColis Colis à ajouter
	 */
	public void addColis(Colis newColis) {
		if(this.colisSet == null) {
			this.colisSet = new HashSet<Colis>();
		}
		
		if (this.colisSet.add(newColis))
			newColis.basicSetTournee(this);
	}

	/**
	 * Unsetter Id
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * Unsetter Solution
	 * @generated
	 * @ordered
	 */
	public void unsetSolution() {
		if (this.solution == null)
			return;
		Solution oldsolution = this.solution;
		this.solution = null;
		oldsolution.removeTournee(this);
	}

	/**
	 * Permet de supprimer un colis de la collection de colis
	 * @generated
	 * @ordered
         * @param oldColis Colis à retirer
	 */
	public void removeColis(Colis oldColis) {
		if(this.colisSet == null)
			return;
		
		if (this.colisSet.remove(oldColis))
			oldColis.unsetTournee();
		
	}

	
}

