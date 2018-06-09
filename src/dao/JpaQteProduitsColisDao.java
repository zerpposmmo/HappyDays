package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.QteProduitsColis;

/**
 * Représente un DAO de type QteProduitColis utilisant comme source de données
 * une bdd.
 *
 * @author Danny
 */
public class JpaQteProduitsColisDao extends JpaDao<QteProduitsColis> implements QteProduitsColisDao {

    private static JpaQteProduitsColisDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaQteProduitsColisDao() {
        super(QteProduitsColis.class);
    }

    /**
     * Retourne une instance de JpaQteProduitColisDao.
     *
     * @return JpaQteProduitColisDao
     */
    public static JpaQteProduitsColisDao getInstance() {
        if (instance == null) {
            instance = new JpaQteProduitsColisDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Récupère l'ensemble des QteProduitColis sous forme de collection
     *
     * @return
     */
    @Override
    public Collection<QteProduitsColis> findAll() {
        return super.findAll();
    }

    /**
     * Cherche une QteProduitColis donné
     *
     * @param id ID de la QteProduitColis à récupérer
     * @return
     */
    @Override
    public QteProduitsColis find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime une QteProduitColis en base
     *
     * @param obj La QteProduitColis a supprimer
     * @return
     */
    @Override
    public boolean delete(QteProduitsColis obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour une QteProduitColis en base
     *
     * @param obj La QteProduitColis à mettre à jour
     * @return
     */
    @Override
    public boolean update(QteProduitsColis obj) {
        return super.update(obj);
    }

    /**
     * Crée une QteProduitColis en base
     *
     * @param obj QteProduitColis à créer
     * @return
     */
    @Override
    public boolean create(QteProduitsColis obj) {
        return super.create(obj);
    }

}
