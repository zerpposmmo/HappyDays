package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Colis;

/**
 *
 * @author Ando
 */
public class JpaColisDao extends JpaDao<Colis> implements ColisDao {

    private static JpaColisDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaColisDao() {
        super(Colis.class);
    }

    /**
     * Retourne une instance de JpaDaoArc.
     * @return JpaDaoArc
     */
    public static JpaColisDao getInstance() {
        if (instance == null) {
            instance = new JpaColisDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<Colis> findAll() {
        return super.findAll();
    }

    @Override
    public Colis find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Colis obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Colis obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Colis obj) {
        return super.create(obj);
    }

    public Collection<Colis> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<Colis> cq = cb.createQuery(Colis.class);
        Root<Colis> tasks = cq.from(Colis.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}