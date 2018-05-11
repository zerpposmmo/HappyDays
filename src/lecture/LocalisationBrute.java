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
public class LocalisationBrute {
    
    private Long localisationId;
    private int x;
    private int y;

    public LocalisationBrute(Long localisationId, int x, int y) {
        this.localisationId = localisationId;
        this.x = x;
        this.y = y;
    }

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
