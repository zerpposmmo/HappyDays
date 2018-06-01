package metier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.Transient;



/**
 * Classe Instance
 * @generated
 */
 
@javax.persistence.Entity 
public class Instance
{
	/**
	 * ID de l'instance
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
        @javax.persistence.GeneratedValue(strategy = GenerationType.TABLE)
	protected Long id;

	/**
	 * Ensemble de solutions
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(cascade = CascadeType.PERSIST,mappedBy = "instance") 
	protected Set<Solution> solutionSet;

	/**
	 * Ensemble de produit
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "instance") 
	protected Set<Produit> produitSet;

        
        
        @Transient
        protected Localisation arrivalDepot;
        
        @Transient
        protected Localisation departingDepot;
        
	/**
	 * Constructeur par défaut de l'instance
	 * @generated
	 */
	public Instance(){
                this.produitSet = new HashSet();
                this.solutionSet = new HashSet();
	}

	/**
	 * Récupère l'ID
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Récupère l'ensemble des solutions de l'instance
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
	 * Récupère l'ensemble des produits
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
	 * Ajouter un ensemble de solution à l'instance
	 * @generated
	 * @ordered
         * @param newSolution Ensemble de solutions à ajouter
	 */
	public void addAllSolution(Set<Solution> newSolution) {
		if (this.solutionSet == null) {
			this.solutionSet = new HashSet<Solution>();
		}
		for (Solution tmp : newSolution)
			tmp.setInstance(this);
		
	}

	/**
	 * Ajoute un ensemble de produits à l'instance
	 * @generated
	 * @ordered
         * @param newProduit Ensemble de produit à ajouter
	 */
	public void addAllProduit(Set<Produit> newProduit) {
		if (this.produitSet == null) {
			this.produitSet = new HashSet<Produit>();
		}
		for (Produit tmp : newProduit)
			tmp.setInstance(this);
		
	}

	/**
	 * Retire l'ensemble des solutions donnée de l'instance
	 * @generated
	 * @ordered
         * @param newSolution Ensemble de solutions à retirer 
	 */
	public void removeAllSolution(Set<Solution> newSolution) {
		if(this.solutionSet == null) {
			return;
		}
		
		this.solutionSet.removeAll(newSolution);
	}

	/**
	 * Retire l'ensemble de produits donné de l'instance
	 * @generated
	 * @ordered
         * @param newProduit Ensemble de produit à retirer
	 */
	public void removeAllProduit(Set<Produit> newProduit) {
		if(this.produitSet == null) {
			return;
		}
		
		this.produitSet.removeAll(newProduit);
	}

	/**
	 * Définit un ID à l'instance
	 * @generated
	 * @ordered
         * @param myId ID à fixer
	 */
	public void setId(long myId) {
		this.id = myId;
	}

        /**
         * Permet de récupérer le dépôt d'arrivée
         * @return 
         */
        public Localisation getArrivalDepot() {
            return arrivalDepot;
        }

        /**
         * Définit le dépôt d'arrivée
         * @param arrivalDepot 
         */
        public void setArrivalDepot(Localisation arrivalDepot) {
            this.arrivalDepot = arrivalDepot;
        }

        /**
         * Permet de récupérer le dépôt de départ
         * @return 
         */
        public Localisation getDepartingDepot() {
            return departingDepot;
        }

        /**
         * Définit le dépôt de départ
         * @param arrivalDepot 
         */
        public void setDepartingDepot(Localisation departingDepot) {
            this.departingDepot = departingDepot;
        }    
        
	/**
	 * Ajoute une solution à l'instance
	 * @generated
	 * @ordered
         * @param newSolution Solution à ajouter
	 */
	public void addSolution(Solution newSolution) {
		if(this.solutionSet == null) {
			this.solutionSet = new HashSet<Solution>();
		}
		
		if (this.solutionSet.add(newSolution))
			newSolution.basicSetInstance(this);
	}

	/**
	 * Ajoute un produit à l'instance
	 * @generated
	 * @ordered
         * @param newProduit Produit à ajouter
	 */
	public void addProduit(Produit newProduit) {
		if(this.produitSet == null) {
			this.produitSet = new HashSet<Produit>();
		}
		
		if (this.produitSet.add(newProduit))
			newProduit.basicSetInstance(this);
	}

	/**
	 * Retire l'ID de l'instance
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * Retire une solution donnée de l'ensemble des solutions de l'instance
	 * @generated
	 * @ordered
         * @param oldSolution Solution à retirer
	 */
	public void removeSolution(Solution oldSolution) {
		if(this.solutionSet == null)
			return;
		
		if (this.solutionSet.remove(oldSolution))
			oldSolution.unsetInstance();
		
	}

	/**
	 * Retire un produit donné de l'ensemble de produits de l'instance
	 * @generated
	 * @ordered
         * @param oldProduit Produit à retirer
	 */
	public void removeProduit(Produit oldProduit) {
		if(this.produitSet == null)
			return;
		
		if (this.produitSet.remove(oldProduit))
			oldProduit.unsetInstance();
		
	}

	
}

