package metier;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
 
@javax.persistence.Entity 
public class Arc
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	@javax.persistence.Column(nullable = false) 
	protected Long id;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToOne 
	protected Localisation arrivee;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Column(nullable = false) 
	protected int distance;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Localisation depart;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Arc(){
            this.distance = 0;
            this.arrivee = new Localisation();
            this.depart = new Localisation();
	}

        public Arc(Localisation arrivee, int distance, Localisation depart) {
            this.arrivee = arrivee;
            this.distance = distance;
            this.depart = depart;
        }
        
        

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void basicSetLocalisation(Localisation myLocalisation) {
		if (this.depart != myLocalisation) {
			if (myLocalisation != null){
				if (this.depart != myLocalisation) {
					Localisation oldlocalisation = this.depart;
					this.depart = myLocalisation;
					if (oldlocalisation != null)
						oldlocalisation.removeArc(this);
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
	private Localisation getArrivee() {
		return this.arrivee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private int getDistance() {
		return this.distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Localisation getDepart() {
		return this.depart;
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
	private void setArrivee(Localisation myArrivee) {
		this.arrivee = myArrivee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void setDistance(int myDistance) {
		this.distance = myDistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
         * @param myLocalisation Localisation de départ
	 */
	public void setDepart(Localisation myLocalisation) {
		this.basicSetLocalisation(myLocalisation);
                if(!myLocalisation.arcMap.containsKey(this.arrivee)) { 
                    myLocalisation.addArc(this);
                }
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
	private void unsetArrivee() {
		this.arrivee = new Localisation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	private void unsetDistance() {
		this.distance = 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void unsetDepart() {
		if (this.depart == null)
			return;
		Localisation oldlocalisation = this.depart;
		this.depart = null;
		oldlocalisation.removeArc(this);
	}

	
}

