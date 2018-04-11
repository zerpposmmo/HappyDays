package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Entrepot
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
	 
	@javax.persistence.OneToMany(mappedBy = "entrepot") 
	protected Set<Localisation> localisation;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Entrepot(){
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
	public Set<Localisation> getLocalisation() {
		if(this.localisation == null) {
				this.localisation = new HashSet<Localisation>();
		}
		return (Set<Localisation>) this.localisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllLocalisation(Set<Localisation> newLocalisation) {
		if (this.localisation == null) {
			this.localisation = new HashSet<Localisation>();
		}
		for (Localisation tmp : newLocalisation)
			tmp.setEntrepot(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllLocalisation(Set<Localisation> newLocalisation) {
		if(this.localisation == null) {
			return;
		}
		
		this.localisation.removeAll(newLocalisation);
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
	public void addLocalisation(Localisation newLocalisation) {
		if(this.localisation == null) {
			this.localisation = new HashSet<Localisation>();
		}
		
		if (this.localisation.add(newLocalisation))
			newLocalisation.basicSetEntrepot(this);
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
	public void removeLocalisation(Localisation oldLocalisation) {
		if(this.localisation == null)
			return;
		
		if (this.localisation.remove(oldLocalisation))
			oldLocalisation.unsetEntrepot();
		
	}

	
}

