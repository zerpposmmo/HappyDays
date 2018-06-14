package dao;

import java.util.Collection;
import metier.Localisation;

/**
 * Représente un DAO de type Localisation utilisant comme source de données une
 * bdd.
 *
 * @author Danny
 */
public class JpaLocalisationDao extends JpaDao<Localisation> implements LocalisationDao {

    private static JpaLocalisationDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaLocalisationDao() {
        super(Localisation.class);
    }

    /**
     * Retourne une instance de JpaLocalisationDao.
     *
     * @return JpaLocalisationDao
     */
    public static JpaLocalisationDao getInstance() {
        if (instance == null) {
            instance = new JpaLocalisationDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Récupère toutes les localisation sous la forme d'une collection
     *
     * @return
     */
    @Override
    public Collection<Localisation> findAll() {
        return super.findAll();
    }

    /**
     * Cherche une localisation donnée
     *
     * @param id ID de la localisation à chercher
     * @return
     */
    @Override
    public Localisation find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime une Localisation en base
     *
     * @param obj Localisation à supprimer
     * @return
     */
    @Override
    public boolean delete(Localisation obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour une Localisation en base
     *
     * @param obj Localisation à mettre à jour
     * @return
     */
    @Override
    public boolean update(Localisation obj) {
        return super.update(obj);
    }

    /**
     * Crée une Localisation en base
     *
     * @param obj Localisation à créer
     * @return
     */
    @Override
    public boolean create(Localisation obj) {
        return super.create(obj);
    }

}
