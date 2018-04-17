package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * Classe solution
 * @generated
 */
 
@javax.persistence.Entity 
public class Solution
{
	/**
	 * ID de la solution
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected Long id;

	/**
	 * Nom de la solution
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected String nom;

	/**
	 * Ensemble des tournées de la solution
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "solution") 
	protected Set<Tournee> tourneeSet;

	/**
	 * Instance de la solution
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Instance instance;

	/**
	 * Constructeur de la solution
	 * @generated
	 */
	public Solution(){
                this.tourneeSet = new HashSet();
	}

	/**
	 * Ajout basique d'une instance à la solution
         * @param myInstance Instance à ajouter à la solution
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
						oldinstance.removeSolution(this);
				}
			}
		}
	}

	/**
	 * Récupère l'ID de la solution
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Récupère le nom de la solution
	 * @generated
	 * @ordered
	 */
	private String getNom() {
		return this.nom;
	}

	/**
	 * Récupère l'ensemble de tournées de la solution
	 * @generated
	 * @ordered
	 */
	public Set<Tournee> getTournee() {
		if(this.tourneeSet == null) {
				this.tourneeSet = new HashSet<Tournee>();
		}
		return (Set<Tournee>) this.tourneeSet;
	}

	/**
	 * Récupère l'instance de la solution
	 * @generated
	 * @ordered
	 */
	public Instance getInstance() {
		return this.instance;
	}

	/**
	 * Ajoute l'ensemble des tournées donnée à la solution
         * @param newTournee L'ensemble des tounrées à ajouter à la solution
	 * @generated
	 * @ordered
	 */
	public void addAllTournee(Set<Tournee> newTournee) {
		if (this.tourneeSet == null) {
			this.tourneeSet = new HashSet<Tournee>();
		}
		for (Tournee tmp : newTournee)
			tmp.setSolution(this);
		
	}

	/**
	 * Retire l'ensemble des tournées données de la solution
         * @param newTournee L'ensemble des tournées que l'on souhaite retirer
	 * @generated
	 * @ordered
	 */
	public void removeAllTournee(Set<Tournee> newTournee) {
		if(this.tourneeSet == null) {
			return;
		}
		
		this.tourneeSet.removeAll(newTournee);
	}

	/**
	 * Définit l'ID de la solution
         * @param myId ID que l'on veut ajouter
	 * @generated
	 * @ordered
	 */
	public void setId(long myId) {
		this.id = myId;
	}

	/**
	 * Définit le nom de la solution
         * @param myNom Nom que l'on veut ajouter
	 * @generated
	 * @ordered
	 */
	private void setNom(String myNom) {
		this.nom = myNom;
	}

	/**
	 * Ajouter une tournée donnée à l'ensemble des tournées de la solution
         * @param newTournee La tournée de que l'on souhaite ajouter à l'ensemble des tournées
	 * @generated
	 * @ordered
	 */
	public void addTournee(Tournee newTournee) {
		if(this.tourneeSet == null) {
			this.tourneeSet = new HashSet<Tournee>();
		}
		
		if (this.tourneeSet.add(newTournee))
			newTournee.basicSetSolution(this);
	}

	/**
	 * Définit l'instance de la solution
         * @param myInstance Instance que l'on veut ajouter 
	 * @generated
	 * @ordered
	 */
	public void setInstance(Instance myInstance) {
		this.basicSetInstance(myInstance);
		myInstance.addSolution(this);
	}

	/**
	 * Retire l'ID de la solution
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * Retire le nom de la solution
	 * @generated
	 * @ordered
	 */
	private void unsetNom() {
		this.nom = "";
	}

	/**
	 * Retire la tournée donnée de la solution
         * @param oldTournee La tournée que l'on souhaite retirer de la solution
	 * @generated
	 * @ordered
	 */
	public void removeTournee(Tournee oldTournee) {
		if(this.tourneeSet == null)
			return;
		
		if (this.tourneeSet.remove(oldTournee))
			oldTournee.unsetSolution();
		
	}

	/**
	 * Retire l'instance de la solution
	 * @generated
	 * @ordered
	 */
	public void unsetInstance() {
		if (this.instance == null)
			return;
		Instance oldinstance = this.instance;
		this.instance = null;
		oldinstance.removeSolution(this);
	}

	
}

