package dao;

/**
 * Représente une frabrique DAO de type JPA.
 * @author Arnaud
 */
public class DaoFactoryJpa extends DaoFactory {

	
	@Override
	public InstanceDao getInstanceDao() {
		return JpaInstanceDao.getInstance();
	}
        
        
        /**
	 * Retourne une EntrepotDao.
	 * @return EntrepotDao
	 */
        @Override
	public EntrepotDao getEntrepotDao() {
		return JpaEntrepotDao.getInstance();
        }
        
        /**
	 * Retourne une ArcDao.
	 * @return ArcDao
	 */
        @Override
	public ArcDao getArcDao() {
		return JpaArcDao.getInstance();
        }
        
        /**
	 * Retourne une ColisDao.
	 * @return ColisDao
	 */
        @Override
	public ColisDao getColisDao() {
		return JpaColisDao.getInstance();
        }
        
        /**
	 * Retourne une CommandeDao.
	 * @return CommandeDao
	 */
        @Override
	public CommandeDao getCommandeDao() {
		return JpaCommandeDao.getInstance();
        }
        
        /**
	 * Retourne une LigneDao.
	 * @return LigneDao
	 */
        @Override
	public LigneDao getLigneDao() {
		return JpaLigneDao.getInstance();
        }
        
        /**
	 * Retourne une LocalisationDao.
	 * @return LocalisationDao
	 */
        @Override
	public LocalisationDao getLocalisationDao() {
		return JpaLocalisationDao.getInstance();
        }
        
        
        /**
	 * Retourne une ProduitDao.
	 * @return ProduitDao
	 */
        @Override
	public ProduitDao getProduitDao() {            
		return JpaProduitDao.getInstance();
        }
        
        /**
	 * Retourne une SolutionDao.
	 * @return SolutionDao
	 */
        @Override
	public SolutionDao getSolutionDao() {            
		return JpaSolutionDao.getInstance();
        }
        

}
