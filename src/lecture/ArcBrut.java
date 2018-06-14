package lecture;

/**
 * Représente un arc brut servant à créer l'objet après lecture dans un fichier
 * texte
 *
 * @author Julien
 */
public class ArcBrut {

    private long departId;
    private long arriveeId;
    private int distance;

    /**
     * Constructeur par données d'un arcBrut
     *
     * @param departId l'id du départ de l'arc
     * @param arriveeId l'id de l'arrivée de l'arc
     * @param distance la distance de l'arc
     */
    public ArcBrut(long departId, long arriveeId, int distance) {
        this.departId = departId;
        this.arriveeId = arriveeId;
        this.distance = distance;
    }

    /**
     * Récupère l'id du départ de l'arc
     *
     * @return l'id du départ de l'arc
     */
    public long getDepartId() {
        return departId;
    }

    /**
     * Récupère l'id de l'arrivée de l'arc
     *
     * @return l'id de l'arrivée de l'arc
     */
    public long getArriveeId() {
        return arriveeId;
    }

    /**
     * Récupère la distance de l'arc
     *
     * @return
     */
    public int getDistance() {
        return distance;
    }

}
