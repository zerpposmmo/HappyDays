package lecture;

/**
 * Représente un produit brut servant à créer l'objet après lecture dans un fichier texte
 * @author Julien
 */
public class ProduitBrut {
    
    private long id;
    private long localisationId;
    private int poids;
    private int volume;

    /**
     * Constructeur par données
     * @param id
     * @param localisationId
     * @param poids
     * @param volume 
     */
    public ProduitBrut(long id, long localisationId, int poids, int volume) {
        this.id = id;
        this.localisationId = localisationId;
        this.poids = poids;
        this.volume = volume;
    }   

    //--------------Getter--------------//
    public long getId() {
        return id;
    }

    public long getLocalisationId() {
        return localisationId;
    }

    public int getPoids() {
        return poids;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "ProduitBrut{" + "id=" + id + ", localisationId=" + localisationId + ", poids=" + poids + ", volume=" + volume + '}';
    }
    
    
}
