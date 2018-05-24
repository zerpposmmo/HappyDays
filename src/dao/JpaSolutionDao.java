package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Solution;

/**
 *
 * @author Ando
 */
public class JpaSolutionDao extends JpaDao<Solution> implements SolutionDao {

    private static JpaSolutionDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaSolutionDao() {
        super(Solution.class);
    }

    /**
     * Retourne une instance de JpaDaoArc.
     * @return JpaDaoArc
     */
    public static JpaSolutionDao getInstance() {
        if (instance == null) {
            instance = new JpaSolutionDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<Solution> findAll() {
        return super.findAll();
    }

    @Override
    public Solution find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Solution obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Solution obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Solution obj) {
        return super.create(obj);
    }

    public Collection<Solution> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<Solution> cq = cb.createQuery(Solution.class);
        Root<Solution> tasks = cq.from(Solution.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}