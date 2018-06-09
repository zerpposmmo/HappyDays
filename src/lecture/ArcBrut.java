package lecture;

/**
 * Représente un arc brut servant à créer l'objet après lecture dans un fichier texte
 * @author Julien
 */
public class ArcBrut {
    
    private long departId;
    private long arriveeId;
    private int distance;

    public ArcBrut(long departId, long arriveeId, int distance) {
        this.departId = departId;
        this.arriveeId = arriveeId;
        this.distance = distance;
    }

    // -----Getter-----//
    public long getDepartId() {
        return departId;
    }

    public long getArriveeId() {
        return arriveeId;
    }

    public int getDistance() {
        return distance;
    }
    
    
}
