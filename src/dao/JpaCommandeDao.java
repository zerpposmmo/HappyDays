package dao;

import java.util.Collection;
import metier.Commande;

/**
 * Représente un DAO de type Commande utilisant comme source de données une bdd.
 *
 * @author Danny
 */
public class JpaCommandeDao extends JpaDao<Commande> implements CommandeDao {

    private static JpaCommandeDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaCommandeDao() {
        super(Commande.class);
    }

    /**
     * Retourne une instance de JpaCommandeDao.
     *
     * @return JpaCommandeDao
     */
    public static JpaCommandeDao getInstance() {
        if (instance == null) {
            instance = new JpaCommandeDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Renvoie une collection de commande
     *
     * @return
     */
    @Override
    public Collection<Commande> findAll() {
        return super.findAll();
    }

    /**
     * Cherche un commande particulière
     *
     * @param id Commande à récupérer
     * @return
     */
    @Override
    public Commande find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime une commande donnée en base
     *
     * @param obj commande à supprimer
     * @return
     */
    @Override
    public boolean delete(Commande obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour une commande donnée en base
     *
     * @param obj Commande à mettre à jour
     * @return
     */
    @Override
    public boolean update(Commande obj) {
        return super.update(obj);
    }

    /**
     * Crée une commande donnée en base
     *
     * @param obj Commande à créer
     * @return
     */
    @Override
    public boolean create(Commande obj) {
        return super.create(obj);
    }

}
