package metier;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/**
 * Classe entrepôt
 * @generated
 */
 
@javax.persistence.Entity 
public class Entrepot
{
	/**
	 * ID de l'entrepot
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected Long id;

	/**
	 * Ensemble de localisation de l'entrepot
	 * @generated
	 * @ordered
	 */
	 
	@javax.persistence.OneToMany(mappedBy = "entrepot") 
	protected Set<Localisation> localisationSet;

	/**
	 * Constructeur par défaut de l'entrepôt
	 * @generated
	 */
	public Entrepot(){
		this.localisationSet = new HashSet();
	}

	/**
	 * Récupère l'ID de l'entrepôt
	 * @generated
	 * @ordered
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Definis l'ensemble des localisations de l'entrepôt
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
	 * Ajoute un ensemble de localisation donnée à un entrepôt
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
	 * Retire toutes les localisations dans l'entrepôt
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
	 * Définit l'ID de l'entrepôt
	 * @generated
	 * @ordered
	 */
	public void setId(long myId) {
		this.id = myId;
	}

	/**
	 * Ajoute la localisation donnée à l'ensemble de localisation de l'entrepôt
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
	 * Retire l'ID de l'entrepôt
	 * @generated
	 * @ordered
	 */
	public void unsetId() {
		this.id = 0L;
	}

	/**
	 * Retire la localisation de l'entrepôt
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

