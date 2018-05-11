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
public class ProduitBrut {
    
    private long id;
    private long localisationId;
    private int poids;
    private int volume;

    public ProduitBrut(long id, long localisationId, int poids, int volume) {
        this.id = id;
        this.localisationId = localisationId;
        this.poids = poids;
        this.volume = volume;
    }   

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
