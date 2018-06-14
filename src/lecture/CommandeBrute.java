package lecture;

import java.util.List;

/**
 * Représente une commande brute servant à créer l'objet après lecture dans un
 * fichier texte
 *
 * @author Julien
 */
public class CommandeBrute {

    private long commandeId;
    private int colisMax;
    private int nbLignes;
    private List<QuantiteProduit> qP;

    /**
     * Constructeur par données de CommandeBrute
     *
     * @param commandeId l'id de la commande
     * @param colisMax le nombre de colis maximum
     * @param nbLignes le nombre de lignes de la commande
     * @param qP la liste des produits et leur quantité
     */
    public CommandeBrute(long commandeId, int colisMax, int nbLignes, List<QuantiteProduit> qP) {
        this.commandeId = commandeId;
        this.colisMax = colisMax;
        this.nbLignes = nbLignes;
        this.qP = qP;
    }

    /**
     * Récupère l'id de la commande
     *
     * @return l'id de la commande
     */
    public long getCommandeId() {
        return commandeId;
    }

    /**
     * Récupère le nombre de colis maximum de la commande
     *
     * @return
     */
    public int getColisMax() {
        return colisMax;
    }

    /**
     * Récupère le nombre de lignes de la commande
     *
     * @return
     */
    public int getNbLignes() {
        return nbLignes;
    }

    /**
     * Récupère la liste des produits et leur quantité
     *
     * @return
     */
    public List<QuantiteProduit> getqP() {
        return qP;
    }

}
