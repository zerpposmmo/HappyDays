package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Entrepot;

/**
 *
 * @author Ando
 */
public class JpaEntrepotDao extends JpaDao<Entrepot> implements EntrepotDao {

    private static JpaEntrepotDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaEntrepotDao() {
        super(Entrepot.class);
    }

    /**
     * Retourne une instance de JpaDaoArc.
     * @return JpaDaoArc
     */
    public static JpaEntrepotDao getInstance() {
        if (instance == null) {
            instance = new JpaEntrepotDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<Entrepot> findAll() {
        return super.findAll();
    }

    @Override
    public Entrepot find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Entrepot obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Entrepot obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Entrepot obj) {
        return super.create(obj);
    }

    public Collection<Entrepot> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<Entrepot> cq = cb.createQuery(Entrepot.class);
        Root<Entrepot> tasks = cq.from(Entrepot.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}