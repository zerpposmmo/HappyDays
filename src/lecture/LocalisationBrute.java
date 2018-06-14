package lecture;

/**
 * Représente une localisation brute servant à créer l'objet après lecture dans
 * un fichier texte
 *
 * @author Xtree
 */
public class LocalisationBrute {

    private Long localisationId;
    private int x;
    private int y;

    /**
     * Constructeur par données
     *
     * @param localisationId
     * @param x
     * @param y
     */
    public LocalisationBrute(Long localisationId, int x, int y) {
        this.localisationId = localisationId;
        this.x = x;
        this.y = y;
    }

    //------------Getter-----------//
    public Long getLocalisationId() {
        return localisationId;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
