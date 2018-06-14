package dao;

import java.util.Collection;
import metier.Produit;

/**
 * Représente un DAO de type Produit utilisant comme source de données une bdd.
 *
 * @author Danny
 */
public class JpaProduitDao extends JpaDao<Produit> implements ProduitDao {

    private static JpaProduitDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaProduitDao() {
        super(Produit.class);
    }

    /**
     * Retourne une instance de JpaProduitDao.
     *
     * @return JpaProduitDao
     */
    public static JpaProduitDao getInstance() {
        if (instance == null) {
            instance = new JpaProduitDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    /**
     * Récupère l'ensemble des Produit sous forme de collection
     *
     * @return
     */
    @Override
    public Collection<Produit> findAll() {
        return super.findAll();
    }

    /**
     * Cherche un produit donné
     *
     * @param id ID du produit à chercher
     * @return
     */
    @Override
    public Produit find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    /**
     * Supprime un produit en base
     *
     * @param obj Produit à supprimer
     * @return
     */
    @Override
    public boolean delete(Produit obj) {
        return super.delete(obj);
    }

    /**
     * Met à jour un produit en base
     *
     * @param obj Produit à mettre à jour
     * @return
     */
    @Override
    public boolean update(Produit obj) {
        return super.update(obj);
    }

    /**
     * Crée un produit en base
     *
     * @param obj Produit à créer
     * @return
     */
    @Override
    public boolean create(Produit obj) {
        return super.create(obj);
    }

}
