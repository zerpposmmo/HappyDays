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
	protected Set<Ligne> ligne;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "commande") 
	protected Set<Colis> colis;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Commande(){
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
	private int getColisMax() {
		return this.colisMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Ligne> getLigne() {
		if(this.ligne == null) {
				this.ligne = new HashSet<Ligne>();
		}
		return (Set<Ligne>) this.ligne;
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
	public void addAllLigne(Set<Ligne> newLigne) {
		if (this.ligne == null) {
			this.ligne = new HashSet<Ligne>();
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
		if (this.colis == null) {
			this.colis = new HashSet<Colis>();
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
		if(this.ligne == null) {
			return;
		}
		
		this.ligne.removeAll(newLigne);
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
		if(this.ligne == null) {
			this.ligne = new HashSet<Ligne>();
		}
		
		if (this.ligne.add(newLigne))
			newLigne.basicSetCommande(this);
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
		if(this.ligne == null)
			return;
		
		if (this.ligne.remove(oldLigne))
			oldLigne.unsetCommande();
		
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
			oldColis.unsetCommande();
		
	}

	
}

