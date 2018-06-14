package metier;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;

/**
 * Classe solution
 *
 * @generated
 */
@javax.persistence.Entity
public class Solution {

    /**
     * ID de la solution
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Id
    @javax.persistence.Column(nullable = false)
    @javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Nom de la solution
     *
     * @generated
     * @ordered
     */
    @javax.persistence.Column(nullable = false)
    protected String nom;

    /**
     * Ensemble des tournées de la solution
     *
     * @generated
     * @ordered
     */
    @javax.persistence.OneToMany(cascade = CascadeType.PERSIST, mappedBy = "solution")
    protected Set<Tournee> tourneeSet;

    /**
     * Instance de la solution
     *
     * @generated
     * @ordered
     */
    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(nullable = false)
    protected Instance instance;

    @javax.persistence.Column(nullable = false)
    protected Double distance;

    /**
     * Constructeur de la solution
     *
     * @generated
     */
    public Solution() {
        this.tourneeSet = new HashSet();
        this.distance = (double) 0;
    }

    /**
     * Ajout basique d'une instance à la solution
     *
     * @generated
     * @ordered
     * @param myInstance Instance à ajouter à la solution
     */
    public void basicSetInstance(Instance myInstance) {
        if (this.instance != myInstance) {
            if (myInstance != null) {
                if (this.instance != myInstance) {
                    Instance oldinstance = this.instance;
                    this.instance = myInstance;
                    if (oldinstance != null) {
                        oldinstance.removeSolution(this);
                    }
                }
            }
        }
    }

    /**
     * Récupère l'ID de la solution
     *
     * @return l'ID de la solution
     * @generated
     * @ordered
     */
    public long getId() {
        return this.id;
    }

    /**
     * Récupère le nom de la solution
     *
     * @return le nom de la solution
     * @generated
     * @ordered
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Récupère l'ensemble des tournées de la solution
     *
     * @return l'ensemble des tournées de la solution
     * @generated
     * @ordered
     */
    public Set<Tournee> getTournee() {
        if (this.tourneeSet == null) {
            this.tourneeSet = new HashSet<>();
        }
        return (Set<Tournee>) this.tourneeSet;
    }

    /**
     * Récupère l'instance de la solution
     *
     * @return l'instance de la solution
     * @generated
     * @ordered
     */
    public Instance getInstance() {
        return this.instance;
    }

    /**
     * Ajoute l'ensemble des tournées donnée à la solution
     *
     * @generated
     * @ordered
     *
     * @param newTournee L'ensemble des tounrées à ajouter à la solution
     *
     */
    public void addAllTournee(Set<Tournee> newTournee) {
        if (this.tourneeSet == null) {
            this.tourneeSet = new HashSet<>();
        }
        for (Tournee tmp : newTournee) {
            tmp.setSolution(this);
        }

    }

    /**
     * Retire l'ensemble des tournées données de la solution
     *
     * @param tournees l'ensemble des tournées que l'on souhaite retirer
     * @generated
     * @ordered
     *
     */
    public void removeAllTournee(Set<Tournee> tournees) {
        if (this.tourneeSet == null) {
            return;
        }

        this.tourneeSet.removeAll(tournees);
    }

    /**
     * Définit l'ID de la solution
     *
     * @generated
     * @ordered
     * @param myId ID que l'on veut ajouter
     */
    public void setId(long myId) {
        this.id = myId;
    }

    /**
     * Définit le nom de la solution
     *
     * @generated
     * @ordered
     * @param myNom Nom que l'on veut ajouter
     */
    public void setNom(String myNom) {
        this.nom = myNom;
    }

    /**
     * Ajouter une tournée donnée à l'ensemble des tournées de la solution
     *
     * @generated
     * @ordered
     * @param newTournee La tournée de que l'on souhaite ajouter à l'ensemble
     * des tournées
     */
    public void addTournee(Tournee newTournee) {
        if (this.tourneeSet == null) {
            this.tourneeSet = new HashSet<>();
        }

        if (this.tourneeSet.add(newTournee)) {
            newTournee.basicSetSolution(this);
        }
    }

    /**
     * Définit l'instance de la solution
     *
     * @generated
     * @ordered
     * @param myInstance Instance que l'on veut ajouter
     */
    public void setInstance(Instance myInstance) {
        this.basicSetInstance(myInstance);
        myInstance.addSolution(this);
    }

    /**
     * Retire l'ID de la solution
     *
     * @generated
     * @ordered
     */
    public void unsetId() {
        this.id = 0L;
    }

    /**
     * Retire le nom de la solution
     *
     * @generated
     * @ordered
     */
    private void unsetNom() {
        this.nom = "";
    }

    /**
     * Retire la tournée donnée de la solution
     *
     * @generated
     * @ordered
     * @param oldTournee La tournée que l'on souhaite retirer de la solution
     */
    public void removeTournee(Tournee oldTournee) {
        if (this.tourneeSet == null) {
            return;
        }

        if (this.tourneeSet.remove(oldTournee)) {
            oldTournee.unsetSolution();
        }

    }

    /**
     * Retire l'instance de la solution
     *
     * @generated
     * @ordered
     */
    public void unsetInstance() {
        if (this.instance == null) {
            return;
        }
        Instance oldinstance = this.instance;
        this.instance = null;
        oldinstance.removeSolution(this);
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void createCheminProduit() {
        for (Tournee tournee : this.tourneeSet) {
            tournee.createCheminProduit();
        }
    }
}
