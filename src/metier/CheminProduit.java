/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    public CheminProduit(Chemin chemin, Produit produit, int ordre) {
        this.chemin = chemin;
        this.produit = produit;
        this.ordre = ordre;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public Chemin getChemin() {
        return chemin;
    }

    public void setChemin(Chemin chemin) {
        this.chemin = chemin;
    }

    public Produit getProduit() {
        return produit;
    }

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
        if (!Objects.equals(this.ordre, other.ordre)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "metier.CheminProduits[ id=" + id + " ]";
    }
    
}
