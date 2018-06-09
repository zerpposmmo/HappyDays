package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Tournee;

/**
 * Représente un DAO de type Tournee utilisant comme source de données une bdd.
 *
 * @author Danny
 */
public class JpaTourneeDao extends JpaDao<Tournee> implements TourneeDao {

    private static JpaTourneeDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaTourneeDao() {
        super(Tournee.class);
    }

    /**
     * Retourne une instance de JpaTourneeDao.
     *
     * @return JpaTourneeDao
     */
    public static JpaTourneeDao getInstance() {
        if (instance == null) {
            instance = new JpaTourneeDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Récupère l'ensemble des tournées sous la forme d'une collection
     *
     * @return
     */
    @Override
    public Collection<Tournee> findAll() {
        return super.findAll();
    }

    /**
     * Cherche une Tournee particulière
     *
     * @param id ID de la tournee à trouver
     * @return
     */
    @Override
    public Tournee find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime une Tournee en base
     *
     * @param obj Tournee à supprimer
     * @return
     */
    @Override
    public boolean delete(Tournee obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour une Tournée en base
     *
     * @param obj Tournee à mettre à jour
     * @return
     */
    @Override
    public boolean update(Tournee obj) {
        return super.update(obj);
    }

    /**
     * Crée une Tournee en base
     *
     * @param obj Tournée à créer
     * @return
     */
    @Override
    public boolean create(Tournee obj) {
        return super.create(obj);
    }

}
