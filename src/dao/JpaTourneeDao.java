package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Tournee;

/**
 *
 * @author Ando
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
     * Retourne une instance de JpaDaoArc.
     * @return JpaDaoArc
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

    @Override
    public Collection<Tournee> findAll() {
        return super.findAll();
    }

    @Override
    public Tournee find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Tournee obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Tournee obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Tournee obj) {
        return super.create(obj);
    }

    public Collection<Tournee> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<Tournee> cq = cb.createQuery(Tournee.class);
        Root<Tournee> tasks = cq.from(Tournee.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}