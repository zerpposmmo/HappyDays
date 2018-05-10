package metier;
import java.util.HashSet;
import java.util.Map;
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
	protected Set<Localisation> localisationSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Entrepot(){
		this.localisationSet = new HashSet();
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
	public Set<Localisation> getLocalisationSet() {
		if(this.localisationSet == null) {
				this.localisationSet = new HashSet<Localisation>();
		}
		return (Set<Localisation>) this.localisationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllLocalisation(Set<Localisation> newLocalisation) {
		if (this.localisationSet == null) {
			this.localisationSet = new HashSet<Localisation>();
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
		if(this.localisationSet == null) {
			return;
		}
		
		this.localisationSet.removeAll(newLocalisation);
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
		if(this.localisationSet == null) {
			this.localisationSet = new HashSet<Localisation>();
		}
		
		if (this.localisationSet.add(newLocalisation))
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
		if(this.localisationSet == null)
			return;
		
		if (this.localisationSet.remove(oldLocalisation))
			oldLocalisation.unsetEntrepot();
		
	}

    @Override
    public String toString() {
        return "Entrepot{" + "id=" + id + '}';
    }

	
}

