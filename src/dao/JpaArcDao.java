package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Arc;

/**
 *
 * @author Ando
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

    @Override
    public Collection<Arc> findAll() {
        return super.findAll();
    }

    @Override
    public Arc find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Arc obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Arc obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Arc obj) {
        return super.create(obj);
    }

    public Collection<Arc> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<Arc> cq = cb.createQuery(Arc.class);
        Root<Arc> tasks = cq.from(Arc.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}