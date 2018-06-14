package dao;

import java.util.Collection;
import metier.Ligne;

/**
 * Représente un DAO de type Ligne utilisant comme source de données une bdd.
 *
 * @author Danny
 */
public class JpaLigneDao extends JpaDao<Ligne> implements LigneDao {

    private static JpaLigneDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaLigneDao() {
        super(Ligne.class);
    }

    /**
     * Retourne une instance de JpaLigneDao.
     *
     * @return JpaLigneDao
     */
    public static JpaLigneDao getInstance() {
        if (instance == null) {
            instance = new JpaLigneDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Récupère toutes les lignes sous forme de collection
     *
     * @return
     */
    @Override
    public Collection<Ligne> findAll() {
        return super.findAll();
    }

    /**
     * Cherche une Ligne particulière
     *
     * @param id ID de la ligne à chercher
     * @return
     */
    @Override
    public Ligne find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime une Ligne donnée en base
     *
     * @param obj Ligne à supprimer
     * @return
     */
    @Override
    public boolean delete(Ligne obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour une Ligne donnée en base
     *
     * @param obj Ligne à modifier
     * @return
     */
    @Override
    public boolean update(Ligne obj) {
        return super.update(obj);
    }

    /**
     * Crée une nouvelle ligne en base
     *
     * @param obj Ligne à créer
     * @return
     */
    @Override
    public boolean create(Ligne obj) {
        return super.create(obj);
    }

}
