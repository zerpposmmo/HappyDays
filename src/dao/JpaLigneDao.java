package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Ligne;

/**
 *
 * @author Ando
 */
public class JpaLigneDao extends JpaDao<Ligne> implements LigneDao {

    private static JpaLigneDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaLigneDao() {
        super(Ligne.class);
    }

    /**
     * Retourne une instance de JpaDaoArc.
     * @return JpaDaoArc
     */
    public static JpaLigneDao getInstance() {
        if (instance == null) {
            instance = new JpaLigneDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<Ligne> findAll() {
        return super.findAll();
    }

    @Override
    public Ligne find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Ligne obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Ligne obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Ligne obj) {
        return super.create(obj);
    }

    public Collection<Ligne> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<Ligne> cq = cb.createQuery(Ligne.class);
        Root<Ligne> tasks = cq.from(Ligne.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}