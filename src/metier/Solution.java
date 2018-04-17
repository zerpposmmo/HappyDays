package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Solution
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
	protected String nom;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "solution") 
	protected Set<Tournee> tourneeSet;

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
	public Solution(){
                this.tourneeSet = new HashSet();
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
						oldinstance.removeSolution(this);
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
	private String getNom() {
		return this.nom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	public void addAllTournee(Set<Tournee> newTournee) {
		if (this.tourneeSet == null) {
			this.tourneeSet = new HashSet<Tournee>();
		}
		for (Tournee tmp : newTournee)
			tmp.setSolution(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	private void setNom(String myNom) {
		this.nom = myNom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setInstance(Instance myInstance) {
		this.basicSetInstance(myInstance);
		myInstance.addSolution(this);
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
	private void unsetNom() {
		this.nom = "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
		oldinstance.removeSolution(this);
	}

	
}

