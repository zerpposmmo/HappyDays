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

}
