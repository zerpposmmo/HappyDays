package dao;

/**
 * Représente une frabrique DAO.
 * @author Arnaud
 */
public abstract class DaoFactory {

	/**
	 * Peremt de retourner un DaoFactory.
	 * @param type TODO.
	 * @return DaoFactory
	 */
	public static DaoFactory getDaoFactory(PersistenceType type) {
		if (type.equals(PersistenceType.JPA)) {
			return new DaoFactoryJpa();
		}
		return null;
	}
        
	/**
	 * Retourne une InstanceDao.
	 * @return InstanceDao
	 */
	public abstract InstanceDao getInstanceDao();
        
        /**
	 * Retourne une EntrepotDao.
	 * @return EntrepotDao
	 */
	public abstract EntrepotDao getEntrepotDao();
        
        /**
	 * Retourne une ArcDao.
	 * @return ArcDao
	 */
	public abstract ArcDao getArcDao();
        
        /**
	 * Retourne une ColisDao.
	 * @return ColisDao
	 */
	public abstract ColisDao getColisDao();
        
        /**
	 * Retourne une CommandeDao.
	 * @return CommandeDao
	 */
	public abstract CommandeDao getCommandeDao();
        
        /**
	 * Retourne une LigneDao.
	 * @return LigneDao
	 */
	public abstract LigneDao getLigneDao();
        
        /**
	 * Retourne une LocalisationDao.
	 * @return LocalisationDao
	 */
	public abstract LocalisationDao getLocalisationDao();
        
        /**
	 * Retourne une ProduitDao.
	 * @return ProduitDao
	 */
	public abstract ProduitDao getProduitDao();
        
                
        /**
	 * Retourne une SolutionDao.
	 * @return SolutionDao
	 */
	public abstract SolutionDao getSolutionDao();
        
}
