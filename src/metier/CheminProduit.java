/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Samuel
 */
@Entity
public class CheminProduit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(nullable = false)
    private Chemin chemin;

    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(nullable = false)
    private Produit produit;

    private Integer ordre;

    public CheminProduit() {
    }

    /**
     * Constructeur par données
     *
     * @param chemin le chemin
     * @param produit le produit
     * @param ordre l'ordre
     */
    public CheminProduit(Chemin chemin, Produit produit, int ordre) {
        this.chemin = chemin;
        this.produit = produit;
        this.ordre = ordre;
    }

    /**
     * Récupère l'id du CheminProduit
     *
     * @return l'id du CheminProduit
     */
    public Long getId() {
        return id;
    }

    /**
     * Récupère le chemin de la tournée
     *
     * @return le chemin de la tournée
     */
    public Chemin getChemin() {
        return chemin;
    }

    /**
     * Set le chemin
     *
     * @param chemin le chemin
     */
    public void setChemin(Chemin chemin) {
        this.chemin = chemin;
    }

    /**
     * Récupère le produit
     *
     * @return le produit
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * Set le produit
     *
     * @param produit le produit
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CheminProduit other = (CheminProduit) obj;
        if (!Objects.equals(this.chemin, other.chemin)) {
            return false;
        }
        if (!Objects.equals(this.produit, other.produit)) {
            return false;
        }
        return Objects.equals(this.ordre, other.ordre);
    }

    @Override
    public String toString() {
        return "metier.CheminProduits[ id=" + id + " ]";
    }

}
