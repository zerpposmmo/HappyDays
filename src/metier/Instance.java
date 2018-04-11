package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Instance
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
	 
	@javax.persistence.OneToMany(mappedBy = "instance") 
	protected Set<Solution> solution;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "instance") 
	protected Set<Produit> produit;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Instance(){
		super();
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
	public Set<Solution> getSolution() {
		if(this.solution == null) {
				this.solution = new HashSet<Solution>();
		}
		return (Set<Solution>) this.solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Produit> getProduit() {
		if(this.produit == null) {
				this.produit = new HashSet<Produit>();
		}
		return (Set<Produit>) this.produit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllSolution(Set<Solution> newSolution) {
		if (this.solution == null) {
			this.solution = new HashSet<Solution>();
		}
		for (Solution tmp : newSolution)
			tmp.setInstance(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllProduit(Set<Produit> newProduit) {
		if (this.produit == null) {
			this.produit = new HashSet<Produit>();
		}
		for (Produit tmp : newProduit)
			tmp.setInstance(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllSolution(Set<Solution> newSolution) {
		if(this.solution == null) {
			return;
		}
		
		this.solution.removeAll(newSolution);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllProduit(Set<Produit> newProduit) {
		if(this.produit == null) {
			return;
		}
		
		this.produit.removeAll(newProduit);
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
	public void addSolution(Solution newSolution) {
		if(this.solution == null) {
			this.solution = new HashSet<Solution>();
		}
		
		if (this.solution.add(newSolution))
			newSolution.basicSetInstance(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addProduit(Produit newProduit) {
		if(this.produit == null) {
			this.produit = new HashSet<Produit>();
		}
		
		if (this.produit.add(newProduit))
			newProduit.basicSetInstance(this);
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
	public void removeSolution(Solution oldSolution) {
		if(this.solution == null)
			return;
		
		if (this.solution.remove(oldSolution))
			oldSolution.unsetInstance();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeProduit(Produit oldProduit) {
		if(this.produit == null)
			return;
		
		if (this.produit.remove(oldProduit))
			oldProduit.unsetInstance();
		
	}

	
}

