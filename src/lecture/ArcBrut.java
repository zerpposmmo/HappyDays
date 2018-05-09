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
public class ArcBrut {
    
    private long departId;
    private long arriveeId;
    private int distance;

    public ArcBrut(long departId, long arriveeId, int distance) {
        this.departId = departId;
        this.arriveeId = arriveeId;
        this.distance = distance;
    }

    public long getDepartId() {
        return departId;
    }

    public long getArriveeId() {
        return arriveeId;
    }

    public int getDistance() {
        return distance;
    }
    
    
}
