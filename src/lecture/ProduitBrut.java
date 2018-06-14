package lecture;

/**
 * Représente un produit brut servant à créer l'objet après lecture dans un
 * fichier texte
 *
 * @author Julien
 */
public class ProduitBrut {

    private long id;
    private long localisationId;
    private int poids;
    private int volume;

    /**
     * Constructeur par données
     *
     * @param id l'id du ProduitBrut
     * @param localisationId l'id de la localisation du produit
     * @param poids le poids du produit
     * @param volume le volume du produit
     */
    public ProduitBrut(long id, long localisationId, int poids, int volume) {
        this.id = id;
        this.localisationId = localisationId;
        this.poids = poids;
        this.volume = volume;
    }

    /**
     * Récupère l'id du produit
     *
     * @return l'id du produit
     */
    public long getId() {
        return id;
    }

    /**
     * Récupère l'id de la localisation du produit
     *
     * @return l'id de la localisation du produit
     */
    public long getLocalisationId() {
        return localisationId;
    }

    /**
     * Récupère le poids du produit
     *
     * @return le poids du produit
     */
    public int getPoids() {
        return poids;
    }

    /**
     * Récupère le volume du produit
     *
     * @return le volume du produit
     */
    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "ProduitBrut{" + "id=" + id + ", localisationId=" + localisationId + ", poids=" + poids + ", volume=" + volume + '}';
    }

}
