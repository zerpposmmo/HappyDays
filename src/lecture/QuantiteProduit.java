package lecture;

/**
 * Représente la quantité d'un produit donné
 * @author Julien
 */
public class QuantiteProduit {
    
    private long produitId;
    private int quantite;

    /**
     * Constructeur par données
     * @param produitId
     * @param quantite 
     */
    public QuantiteProduit(long produitId, int quantite) {
        this.produitId = produitId;
        this.quantite = quantite;
    }

    public long getProduitId() {
        return produitId;
    }

    public int getQuantite() {
        return quantite;
    }
    
    
}
