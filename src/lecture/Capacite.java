package lecture;

/**
 *
 * @author Samuel
 */
public class Capacite {
    
    private int poids;
    private int volume;

    /**
     * Constructeur par données
     * @param poids poids de la capacité
     * @param volume volume de la capacité
     */
    public Capacite(int poids, int volume) {
        this.poids = poids;
        this.volume = volume;
    }

    


    /**-----------Getter & setter-------------**/ 
    
    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Capacite{" + "poids=" + poids + ", volume=" + volume + '}';
    }
    
    
    
}
