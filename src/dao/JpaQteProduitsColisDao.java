package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.QteProduitsColis;

/**
 *
 * @author Ando
 */
public class JpaQteProduitsColisDao extends JpaDao<QteProduitsColis> implements QteProduitsColisDao {

    private static JpaQteProduitsColisDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaQteProduitsColisDao() {
        super(QteProduitsColis.class);
    }

    /**
     * Retourne une instance de JpaDaoArc.
     * @return JpaDaoArc
     */
    public static JpaQteProduitsColisDao getInstance() {
        if (instance == null) {
            instance = new JpaQteProduitsColisDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<QteProduitsColis> findAll() {
        return super.findAll();
    }

    @Override
    public QteProduitsColis find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(QteProduitsColis obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(QteProduitsColis obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(QteProduitsColis obj) {
        return super.create(obj);
    }

    public Collection<QteProduitsColis> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<QteProduitsColis> cq = cb.createQuery(QteProduitsColis.class);
        Root<QteProduitsColis> tasks = cq.from(QteProduitsColis.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}