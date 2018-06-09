package lecture;

import java.util.List;

/**
 * Représente une commande brute servant à créer l'objet après lecture dans un fichier texte
 * @author Julien
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
