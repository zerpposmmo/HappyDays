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
	protected Set<Solution> solutionSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "instance") 
	protected Set<Produit> produitSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Instance(){
                this.produitSet = new HashSet();
                this.solutionSet = new HashSet();
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
	public Set<Solution> getSolutionSet() {
		if(this.solutionSet == null) {
				this.solutionSet = new HashSet<Solution>();
		}
		return (Set<Solution>) this.solutionSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Produit> getProduitSet() {
		if(this.produitSet == null) {
				this.produitSet = new HashSet<Produit>();
		}
		return (Set<Produit>) this.produitSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllSolution(Set<Solution> newSolution) {
		if (this.solutionSet == null) {
			this.solutionSet = new HashSet<Solution>();
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
		if (this.produitSet == null) {
			this.produitSet = new HashSet<Produit>();
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
		if(this.solutionSet == null) {
			return;
		}
		
		this.solutionSet.removeAll(newSolution);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllProduit(Set<Produit> newProduit) {
		if(this.produitSet == null) {
			return;
		}
		
		this.produitSet.removeAll(newProduit);
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
		if(this.solutionSet == null) {
			this.solutionSet = new HashSet<Solution>();
		}
		
		if (this.solutionSet.add(newSolution))
			newSolution.basicSetInstance(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addProduit(Produit newProduit) {
		if(this.produitSet == null) {
			this.produitSet = new HashSet<Produit>();
		}
		
		if (this.produitSet.add(newProduit))
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
		if(this.solutionSet == null)
			return;
		
		if (this.solutionSet.remove(oldSolution))
			oldSolution.unsetInstance();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeProduit(Produit oldProduit) {
		if(this.produitSet == null)
			return;
		
		if (this.produitSet.remove(oldProduit))
			oldProduit.unsetInstance();
		
	}

	
}

