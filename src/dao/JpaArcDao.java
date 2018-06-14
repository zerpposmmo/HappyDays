package dao;

import java.util.Collection;
import metier.Arc;

/**
 * Représente un DAO de type Arc utilisant comme source de données une bdd.
 *
 * @author Danny
 */
public class JpaArcDao extends JpaDao<Arc> implements ArcDao {

    private static JpaArcDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaArcDao() {
        super(Arc.class);
    }

    /**
     * Retourne une instance de JpaDaoArc.
     *
     * @return JpaDaoArc
     */
    public static JpaArcDao getInstance() {
        if (instance == null) {
            instance = new JpaArcDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Renvoie la collection d'arc
     *
     * @return
     */
    @Override
    public Collection<Arc> findAll() {
        return super.findAll();
    }

    /**
     * Cherche un arc
     *
     * @param id ID de l'arc recherché
     * @return
     */
    @Override
    public Arc find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime l'arc donné en base
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Arc obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour l'arc donné en base
     *
     * @param obj
     * @return
     */
    @Override
    public boolean update(Arc obj) {
        return super.update(obj);
    }

    /**
     * Crée un arc en base
     *
     * @param obj
     * @return
     */
    @Override
    public boolean create(Arc obj) {
        return super.create(obj);
    }

}
