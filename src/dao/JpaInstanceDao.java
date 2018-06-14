package dao;

import java.util.Collection;
import metier.Instance;

/**
 * Représente un DAO de type Instance utilisant comme source de données une bdd.
 *
 * @author Arnaud
 */
public class JpaInstanceDao extends JpaDao<Instance> implements InstanceDao {

    private static JpaInstanceDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaInstanceDao() {
        super(Instance.class);
    }

    /**
     * Retourne une instance de JpaInstanceDao.
     *
     * @return JpaInstanceDao
     */
    public static JpaInstanceDao getInstance() {
        if (instance == null) {
            instance = new JpaInstanceDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Renvoie toutes les instances sous la forme d'une collection d'Instances
     *
     * @return
     */
    @Override
    public Collection<Instance> findAll() {
        return super.findAll();
    }

    /**
     * Cherche une instance avec l'ID donné
     *
     * @param id ID de l'instance à chercher
     * @return
     */
    @Override
    public Instance find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime une instance donnée en base
     *
     * @param obj Instance à supprimer
     * @return
     */
    @Override
    public boolean delete(Instance obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour une instance en base
     *
     * @param obj Instance à mettre à jour
     * @return
     */
    @Override
    public boolean update(Instance obj) {
        return super.update(obj);
    }

    /**
     * Crée une instance en base
     *
     * @param obj Instance à créer
     * @return
     */
    @Override
    public boolean create(Instance obj) {
        return super.create(obj);
    }
}
