package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Commande;

/**
 *
 * @author Ando
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
     * Retourne une instance de JpaDaoArc.
     * @return JpaDaoArc
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

    @Override
    public Collection<Commande> findAll() {
        return super.findAll();
    }

    @Override
    public Commande find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Commande obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Commande obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Commande obj) {
        return super.create(obj);
    }

    public Collection<Commande> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<Commande> cq = cb.createQuery(Commande.class);
        Root<Commande> tasks = cq.from(Commande.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}