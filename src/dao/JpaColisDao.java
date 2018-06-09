package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Colis;

/**
 * Représente un DAO de type Colis utilisant comme source de données une bdd.
 *
 * @author Danny
 */
public class JpaColisDao extends JpaDao<Colis> implements ColisDao {

    private static JpaColisDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaColisDao() {
        super(Colis.class);
    }

    /**
     * Retourne une instance de JpaColisDao.
     *
     * @return JpaColisDao
     */
    public static JpaColisDao getInstance() {
        if (instance == null) {
            instance = new JpaColisDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * renvoie une collection de colis
     *
     * @return
     */
    @Override
    public Collection<Colis> findAll() {
        return super.findAll();
    }

    /**
     * Cherche un colis particulier
     *
     * @param id ID du colis
     * @return
     */
    @Override
    public Colis find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime un colis donné en base
     *
     * @param obj colis à supprimer
     * @return
     */
    @Override
    public boolean delete(Colis obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour un colis en base
     *
     * @param obj colis à mettre à jour
     * @return
     */
    @Override
    public boolean update(Colis obj) {
        return super.update(obj);
    }

    /**
     * Crée un colis en base
     *
     * @param obj colis à créer
     * @return
     */
    @Override
    public boolean create(Colis obj) {
        return super.create(obj);
    }

}
