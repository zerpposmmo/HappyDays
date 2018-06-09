package metier;

import java.util.Objects;
import javax.persistence.GenerationType;

/**
 * Classe Arc
 *
 * @author Arnaud
 * @generated
 */
public class Arc {

    /**
     * Identifiant
     *
     * @generated
     * @ordered
     */
    protected Long id;

    /**
     * Localisation de l'arrivée de l'arc
     * @generated
     * @ordered
     */
    protected Localisation arrivee;

    /**
     * Distance entre le départ et l'arrivée de l'arc
     * @generated
     * @ordered
     */
    protected int distance;

    /**
     * Localisation du départ de l'arc
     * @generated
     * @ordered
     */
    protected Localisation depart;

    /**
     * Constructeur par défaut
     * @generated
     */
    public Arc() {
        this.distance = 0;
        this.arrivee = new Localisation();
        this.depart = new Localisation();
    }

    /**
     * Constructeur par arrivée, distance et départ
     * @param arrivee
     * @param distance
     * @param depart
     */
    public Arc(Localisation arrivee, int distance, Localisation depart) {
        this.arrivee = arrivee;
        this.distance = distance;
        this.depart = depart;
    }

    /**
     * Verifie le parametre localisation et le met en départ de l'arc
     *
     * @generated
     * @ordered
     * @param myLocalisation localisation de départ
     */
    private void basicSetDepart(Localisation myLocalisation) {
        if (this.depart != myLocalisation) {
            if (myLocalisation != null) {
                if (this.depart != myLocalisation) {
                    Localisation oldlocalisation = this.depart;
                    this.depart = myLocalisation;
                    if (oldlocalisation != null) {
                        oldlocalisation.removeArc(this);
                    }
                }
            }
        }
    }

    /**
     * Renvoie l'id de l'arc
     *
     * @generated
     * @ordered
     */
    public long getId() {
        return this.id;
    }

    /**
     * Renvoie la localisation d'arrivée de l'arc
     *
     * @generated
     * @ordered
     */
    private Localisation getArrivee() {
        return this.arrivee;
    }

    /**
     * Renvoie la distance de l'arc
     *
     * @generated
     * @ordered
     */
    public int getDistance() {
        return this.distance;
    }

    /**
     * Renvoie la localisation du départ de l'arc
     *
     * @generated
     * @ordered
     */
    public Localisation getDepart() {
        return this.depart;
    }

    /**
     * Set l'id de l'arc
     *
     * @generated
     * @ordered
     * @param myId identifiant
     */
    public void setId(long myId) {
        this.id = myId;
    }

    /**
     * Set la localisation de l'arrivée de l'arc
     *
     * @generated
     * @ordered
     * @param myArrivee localisation d'arrivée
     */
    private void setArrivee(Localisation myArrivee) {
        this.arrivee = myArrivee;
    }

    /**
     * Set la distance entre le départ et l'arrivée de l'arc
     *
     * @generated
     * @ordered
     * @param myDistance distance
     */
    private void setDistance(int myDistance) {
        this.distance = myDistance;
    }

    /**
     * Set la localisation du départ de l'arc
     *
     * @generated
     * @ordered
     * @param myLocalisation Localisation de départ
     */
    public void setDepart(Localisation myLocalisation) {
        this.basicSetDepart(myLocalisation);
        if (!myLocalisation.arcMap.containsKey(this.arrivee)) {
            myLocalisation.addArc(this);
        }
    }

    /**
     * Unset l'id de l'arc
     *
     * @generated
     * @ordered
     */
    public void unsetId() {
        this.id = 0L;
    }

    /**
     * Unset la localisation de l'arrivée de l'arc
     *
     * @generated
     * @ordered
     */
    private void unsetArrivee() {
        this.arrivee = new Localisation();
    }

    /**
     * Unset la distance de l'arc
     *
     * @generated
     * @ordered
     */
    private void unsetDistance() {
        this.distance = 0;
    }

    /**
     * Unset la localisation de départ de l'arc
     *
     * @generated
     * @ordered
     */
    public void unsetDepart() {
        if (this.depart == null) {
            return;
        }
        Localisation oldlocalisation = this.depart;
        this.depart = null;
        oldlocalisation.removeArc(this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.arrivee);
        hash = 53 * hash + this.distance;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arc other = (Arc) obj;
        if (this.distance != other.distance) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.arrivee, other.arrivee)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Arc{" + "id=" + id + ", arrivee=" + arrivee + ", distance=" + distance + ", depart=" + depart + "} \n";
    }

}
