package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Entrepot;

/**
 * Représente un DAO de type Entrepot utilisant comme source de données une bdd.
 *
 * @author Danny
 */
public class JpaEntrepotDao extends JpaDao<Entrepot> implements EntrepotDao {

    private static JpaEntrepotDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaEntrepotDao() {
        super(Entrepot.class);
    }

    /**
     * Retourne une instance de JpaEntrepotDao.
     *
     * @return JpaEntrepotDao
     */
    public static JpaEntrepotDao getInstance() {
        if (instance == null) {
            instance = new JpaEntrepotDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Renvoie la collection d'entrepot
     *
     * @return
     */
    @Override
    public Collection<Entrepot> findAll() {
        return super.findAll();
    }

    /**
     * Récupère un entrepôt donné
     *
     * @param id ID de l'entrepôt à récupérer
     * @return
     */
    @Override
    public Entrepot find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime un entrepôt donné en base
     *
     * @param obj entrepôt à supprimer
     * @return
     */
    @Override
    public boolean delete(Entrepot obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour un entrepôt en base
     *
     * @param obj Entrepôt à mettre à jour
     * @return
     */
    @Override
    public boolean update(Entrepot obj) {
        return super.update(obj);
    }

    /**
     * Crée un entrepôt donné en base
     *
     * @param obj Entrepôt à créer
     * @return
     */
    @Override
    public boolean create(Entrepot obj) {
        return super.create(obj);
    }

}
