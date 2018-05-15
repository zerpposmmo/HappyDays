package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lecture.Result;
import metier.Arc;
import metier.Commande;
import metier.Instance;
import metier.Localisation;
import metier.Produit;

/**
 * Représente un DAO de type Instance utilisant comme source de données une bdd.
 * @author Arnaud
 */
public class JpaInstanceDao extends JpaDao<Instance> implements InstanceDao {

	private static JpaInstanceDao instance;

	/**
	 * Constrcuteur par défault.
	 */
	private JpaInstanceDao() {
		super(Instance.class);
	}

	/**
	 * Retourne une instance de JpaInstanceDao.
	 * @return JpaInstanceDao
	 */
	public static JpaInstanceDao getInstance() {
		if (instance == null) {
			instance = new JpaInstanceDao();
		}
		return instance;
	}

	@Override
	public boolean deleteAll() {
		return super.deleteAll();
	}

	@Override
	public Collection<Instance> findAll() {
		return super.findAll();
	}

	@Override
	public Instance find(Integer id) {
		return super.find(id);
	}

	@Override
	public void close() {
		super.close();
	}

	@Override
	public boolean delete(Instance obj) {
		return super.delete(obj);
	}

	@Override
	public boolean update(Instance obj) {
		return super.update(obj);
	}

	@Override
	public boolean create(Instance obj) {
		return super.create(obj);
	}
        
        @Override
        public boolean processResult(Result result) {
            this.instance.create(result.getInstance());
            ProduitDao produitDao = JpaProduitDao.getInstance();
            for(Produit p : result.getProduits().values()) {
                produitDao.create(p);
            }
            ArcDao arcDao = JpaArcDao.getInstance();
            for(Arc a : result.getArcs()) {
                arcDao.create(a);
            }
            LocalisationDao localisationDao = JpaLocalisationDao.getInstance();
            for(Localisation l : result.getLocalisations().values()) {
                localisationDao.create(l);
            }
            CommandeDao commandeDao = JpaCommandeDao.getInstance();
            for(Commande c : result.getCommandes().values()) {
                commandeDao.create(c);
            }
            return false;
        }
}
