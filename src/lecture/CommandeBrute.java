/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture;

import java.util.List;

/**
 *
 * @author Xtree
 */
public class CommandeBrute {
    private long commandeId;
    private int colisMax;
    private int nbLignes;
    private List<QuantiteProduit> qP;

    public CommandeBrute(long commandeId, int colisMax, int nbLignes, List<QuantiteProduit> qP) {
        this.commandeId = commandeId;
        this.colisMax = colisMax;
        this.nbLignes = nbLignes;
        this.qP = qP;
    }

    public long getCommandeId() {
        return commandeId;
    }

    public int getColisMax() {
        return colisMax;
    }

    public int getNbLignes() {
        return nbLignes;
    }

    public List<QuantiteProduit> getqP() {
        return qP;
    }
    
    
}
