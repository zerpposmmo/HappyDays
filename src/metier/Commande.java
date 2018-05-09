package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Commande
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
	protected int colisMax;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "commande") 
	protected Set<Ligne> ligneSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "commande") 
	protected Set<Colis> colisSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Commande(){
		super();
                this.colisSet = new HashSet();
                this.ligneSet = new HashSet(); 
	}

    public Commande(Long id, int colisMax, Set<Ligne> ligneSet) {
        this.id = id;
        this.colisMax = colisMax;
        this.ligneSet = ligneSet;
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
	private int getColisMax() {
		return this.colisMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	private void setColisMax(int myColisMax) {
		this.colisMax = myColisMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	private void unsetColisMax() {
		this.colisMax = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
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
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeColis(Colis oldColis) {
		if(this.colisSet == null)
			return;
		
		if (this.colisSet.remove(oldColis))
			oldColis.unsetCommande();
		
	}

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", colisMax=" + colisMax + ", ligneSet=" + ligneSet + '}';
    }

	
}

