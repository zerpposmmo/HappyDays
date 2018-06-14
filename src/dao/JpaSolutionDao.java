package dao;

import java.util.Collection;
import metier.Solution;

/**
 * Représente un DAO de type Solution utilisant comme source de données une bdd.
 *
 * @author Danny
 */
public class JpaSolutionDao extends JpaDao<Solution> implements SolutionDao {

    private static JpaSolutionDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaSolutionDao() {
        super(Solution.class);
    }

    /**
     * Retourne une instance de JpaSolutionDao.
     *
     * @return JpaSolutionDao
     */
    public static JpaSolutionDao getInstance() {
        if (instance == null) {
            instance = new JpaSolutionDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Récupère l'ensemble des solutions sous la forme d'une collection
     *
     * @return
     */
    @Override
    public Collection<Solution> findAll() {
        return super.findAll();
    }

    /**
     * Cherche une Solution particulière
     *
     * @param id ID de la solution à chercher
     * @return
     */
    @Override
    public Solution find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime une Solution en base
     *
     * @param obj Solution à supprimer
     * @return
     */
    @Override
    public boolean delete(Solution obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour une Solution en base
     *
     * @param obj Solution à mettre à jour
     * @return
     */
    @Override
    public boolean update(Solution obj) {
        return super.update(obj);
    }

    /**
     * Crée une solution en base
     *
     * @param obj Solution à créer
     * @return
     */
    @Override
    public boolean create(Solution obj) {
        return super.create(obj);
    }

}
