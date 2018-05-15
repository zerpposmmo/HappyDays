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

}
