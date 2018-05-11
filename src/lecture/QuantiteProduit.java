/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture;

/**
 *
 * @author Xtree
 */
public class QuantiteProduit {
    
    private long produitId;
    private int quantite;

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
