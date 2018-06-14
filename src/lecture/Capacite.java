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
     *
     * @param poids le poids de la capacité
     * @param volume le volume de la capacité
     */
    public Capacite(int poids, int volume) {
        this.poids = poids;
        this.volume = volume;
    }

    /**
     * Récupère le poids de la capacité
     *
     * @return le poids de la capacité
     */
    public int getPoids() {
        return poids;
    }

    /**
     * Set le poids de la capacité
     *
     * @param poids le poids que l'on veut set
     */
    public void setPoids(int poids) {
        this.poids = poids;
    }

    /**
     * Récupère le volume de la capacité
     *
     * @return le volume de la capacité
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Set le volume de la capacité
     *
     * @param volume le volume de la capacité
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Capacite{" + "poids=" + poids + ", volume=" + volume + '}';
    }

}
