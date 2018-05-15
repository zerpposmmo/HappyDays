package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Produit;

/**
 *
 * @author Ando
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
     * Retourne une instance de JpaDaoArc.
     * @return JpaDaoArc
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

    @Override
    public Collection<Produit> findAll() {
        return super.findAll();
    }

    @Override
    public Produit find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Produit obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Produit obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Produit obj) {
        return super.create(obj);
    }

    public Collection<Produit> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
        Root<Produit> tasks = cq.from(Produit.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}