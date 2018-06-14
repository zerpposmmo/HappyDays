package lecture;

/**
 * Représente la quantité d'un produit donné
 *
 * @author Julien
 */
public class QuantiteProduit {

    private long produitId;
    private int quantite;

    /**
     * Constructeur par données
     *
     * @param produitId l'id du produit
     * @param quantite la quantité de produit
     */
    public QuantiteProduit(long produitId, int quantite) {
        this.produitId = produitId;
        this.quantite = quantite;
    }

    /**
     * Récupère l'id du produit
     *
     * @return l'id du produit
     */
    public long getProduitId() {
        return produitId;
    }

    /**
     * Récupère la quantité de produit
     *
     * @return la quantité de produit
     */
    public int getQuantite() {
        return quantite;
    }

}
