package metier;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

/**
 * Class Tournee Posséde une collection d'objet Colis et une collection d'objet
 * Solution
 *
 * @author Samuel
 * @generated
 */ 
@javax.persistence.Entity 
public class Tournee
{
	/**
	 * Identifiant
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
        @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	/**
	 * Solution de la tournée
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Solution solution;

	/**
	 * Colis qui seront livrés par la tournée
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(cascade = CascadeType.PERSIST, mappedBy = "tournee") 
	protected Set<Colis> colisSet;

	protected static Long nbTournee = (long) 0;
        
        /**
         * Route empreintée par la tournée
         */
        @Transient
        protected transient Chemin chemin;

  /**
  * Constructeur par défaut
  *
  */
  public Tournee() {
    this.id = Tournee.nbTournee;
    Tournee.nbTournee++;
    this.colisSet = new HashSet();
    
  }

  public Tournee(Solution s) {
    this();
    this.setSolution(s);
    this.chemin = new Chemin(s.getInstance().getDepartingDepot(), s.getInstance().getArrivalDepot());
  }

	/**
	 * Permet de set la solution de la tournée 
         * en maintenant une cohérence avec les variable de Solution
	 * @generated
	 * @ordered
         * @param mySolution Solution à définir
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
	 * Getter de l'identifiant de la tournée
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Getter de la solution de la tournée
	 * @generated
	 * @ordered
	 */
	public Solution getSolution() {
		return this.solution;
	}

	/**
	 * Getter du HashSet des colis
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
	 * Récupérer les colis d'une commande par id
	 * @generated
	 * @ordered
	 */
	public Set<Colis> getColisSet(Long idCommande) {
                Set<Colis> colisCommandeSet = new HashSet();
		if(this.colisSet == null) {
				this.colisSet = new HashSet<Colis>();
		}
                for(Colis c : this.colisSet){
                    if(c.getCommande().getId() == idCommande){
                        colisCommandeSet.add(c);
                    }
                }
		return colisCommandeSet;
	}

	/**
	 * Permet d'ajouter un groupe de colis a la collection de colis de la tournée
	 * @generated
	 * @ordered
         * @param newColis Ensemble de colis à ajouter
	 */
	public void addAllColis(Set<Colis> newColis) {
		if (this.colisSet == null) {
			this.colisSet = new HashSet<Colis>();
		}
		for (Colis tmp : newColis)
			tmp.setTournee(this);
		
	}

	/**
	 * Permet de supprimer un ensemble de colis
	 * @generated
	 * @ordered
         * @param newColis Ensemble de colis à supprimer
	 */
	public void removeAllColis(Set<Colis> newColis) {
		if(this.colisSet == null) {
			return;
		}
		
		this.colisSet.removeAll(newColis);
	}
    
	/**
	 * Setter  id
	 * @generated
	 * @ordered
         * @param myId ID à définir
	 */
	public void setId(long myId) {
		this.id = myId;
	}

	/**
	 * Setter Solution
	 * @generated
	 * @ordered
         * @param mySolution Solution à définir
	 */
	public void setSolution(Solution mySolution) {
		this.basicSetSolution(mySolution);
		mySolution.addTournee(this);
	}

	/**
	 * Permet d'ajouter un colis
	 * @generated
	 * @ordered
         * @param newColis Colis à ajouter
	 */
	public void addColis(Colis newColis) {
		if(this.colisSet == null) {
			this.colisSet = new HashSet<Colis>();
		}
		
		if (this.colisSet.add(newColis))
			newColis.basicSetTournee(this);
	}

	/**
	 * Unsetter Id
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * Unsetter Solution
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
         * Permet de récupérer le chemin de la tournée
         * @return 
         */
        public Chemin getChemin() {
            return chemin;
        } 

	/**
	 * Permet de supprimer un colis de la collection de colis
	 * @generated
	 * @ordered
         * @param oldColis Colis à retirer
	 */
	public void removeColis(Colis oldColis) {
		if(this.colisSet == null)
			return;
		
		if (this.colisSet.remove(oldColis))
			oldColis.unsetTournee();
		
	}

        public int getNbColis() {
            int nb = 0;
            for(Colis c : this.colisSet){
                if(c.getColisProduits().size() > 0)
                    nb++;
            }
            return nb;
        }

	
}
