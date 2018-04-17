package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Tournee
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
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Solution solution;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "tournee") 
	protected Set<Colis> colis;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Tournee(){
		this.colis = new HashSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
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
	public Solution getSolution() {
		return this.solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Colis> getColis() {
		if(this.colis == null) {
				this.colis = new HashSet<Colis>();
		}
		return (Set<Colis>) this.colis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllColis(Set<Colis> newColis) {
		if (this.colis == null) {
			this.colis = new HashSet<Colis>();
		}
		for (Colis tmp : newColis)
			tmp.setTournee(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllColis(Set<Colis> newColis) {
		if(this.colis == null) {
			return;
		}
		
		this.colis.removeAll(newColis);
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
	public void setSolution(Solution mySolution) {
		this.basicSetSolution(mySolution);
		mySolution.addTournee(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addColis(Colis newColis) {
		if(this.colis == null) {
			this.colis = new HashSet<Colis>();
		}
		
		if (this.colis.add(newColis))
			newColis.basicSetTournee(this);
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
	public void unsetSolution() {
		if (this.solution == null)
			return;
		Solution oldsolution = this.solution;
		this.solution = null;
		oldsolution.removeTournee(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeColis(Colis oldColis) {
		if(this.colis == null)
			return;
		
		if (this.colis.remove(oldColis))
			oldColis.unsetTournee();
		
	}

	
}

