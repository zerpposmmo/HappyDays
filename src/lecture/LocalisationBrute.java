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
     * @param localisationId l'id de la localisation
     * @param x l'abscisse de la localisation
     * @param y l'ordonnée de la localisation
     */
    public LocalisationBrute(Long localisationId, int x, int y) {
        this.localisationId = localisationId;
        this.x = x;
        this.y = y;
    }

    /**
     * Récupère l'id de la localisation
     *
     * @return l'id de la localisation
     */
    public Long getLocalisationId() {
        return localisationId;
    }

    /**
     * Récupère l'abscisse de la localisation
     *
     * @return l'abscicce de la localisation
     */
    public int getX() {
        return x;
    }

    /**
     * Récupère l'ordonnée de la localisation
     *
     * @return l'ordonnée de la localisation
     */
    public int getY() {
        return y;
    }

}
