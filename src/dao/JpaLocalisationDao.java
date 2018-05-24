package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Localisation;

/**
 *
 * @author Ando
 */
public class JpaLocalisationDao extends JpaDao<Localisation> implements LocalisationDao {

    private static JpaLocalisationDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaLocalisationDao() {
        super(Localisation.class);
    }

    /**
     * Retourne une instance de JpaDaoArc.
     * @return JpaDaoArc
     */
    public static JpaLocalisationDao getInstance() {
        if (instance == null) {
            instance = new JpaLocalisationDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<Localisation> findAll() {
        return super.findAll();
    }

    @Override
    public Localisation find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Localisation obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Localisation obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Localisation obj) {
        return super.create(obj);
    }

    public Collection<Localisation> findAllNotUsed() {
        CriteriaBuilder cb = super.em.getCriteriaBuilder();
        CriteriaQuery<Localisation> cq = cb.createQuery(Localisation.class);
        Root<Localisation> tasks = cq.from(Localisation.class);
        cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("nplanning")),
                cb.isNotEmpty(tasks.get("nplanning"))));
        return super.em.createQuery(cq).getResultList();
    }

}