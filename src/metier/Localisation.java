package metier;
import java.util.HashSet;
import java.util.Set;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Localisation
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
	protected int x;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int y;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "localisation") 
	protected Set<Arc> arc;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "localisation") 
	protected Set<Produit> produit;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Entrepot entrepot;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Localisation(){
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void basicSetEntrepot(Entrepot myEntrepot) {
		if (this.entrepot != myEntrepot) {
			if (myEntrepot != null){
				if (this.entrepot != myEntrepot) {
					Entrepot oldentrepot = this.entrepot;
					this.entrepot = myEntrepot;
					if (oldentrepot != null)
						oldentrepot.removeLocalisation(this);
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
	private int getX() {
		return this.x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private int getY() {
		return this.y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Set<Arc> getArc() {
		if(this.arc == null) {
				this.arc = new HashSet<Arc>();
		}
		return (Set<Arc>) this.arc;
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
	public Entrepot getEntrepot() {
		return this.entrepot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addAllArc(Set<Arc> newArc) {
		if (this.arc == null) {
			this.arc = new HashSet<Arc>();
		}
		for (Arc tmp : newArc)
			tmp.setLocalisation(this);
		
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
			tmp.setLocalisation(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeAllArc(Set<Arc> newArc) {
		if(this.arc == null) {
			return;
		}
		
		this.arc.removeAll(newArc);
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
	private void setX(int myX) {
		this.x = myX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setY(int myY) {
		this.y = myY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void addArc(Arc newArc) {
		if(this.arc == null) {
			this.arc = new HashSet<Arc>();
		}
		
		if (this.arc.add(newArc))
			newArc.basicSetLocalisation(this);
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
			newProduit.basicSetLocalisation(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void setEntrepot(Entrepot myEntrepot) {
		this.basicSetEntrepot(myEntrepot);
		myEntrepot.addLocalisation(this);
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
	private void unsetX() {
		this.x = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetY() {
		this.y = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void removeArc(Arc oldArc) {
		if(this.arc == null)
			return;
		
		if (this.arc.remove(oldArc))
			oldArc.unsetLocalisation();
		
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
			oldProduit.unsetLocalisation();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetEntrepot() {
		if (this.entrepot == null)
			return;
		Entrepot oldentrepot = this.entrepot;
		this.entrepot = null;
		oldentrepot.removeLocalisation(this);
	}

	
}

