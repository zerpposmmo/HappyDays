package dao;

import metier.Instance;

/**
 * Interface générique représentant un DAO de type Instance.
 * @author Arnaud
 */
public interface InstanceDao extends Dao<Instance> {

	/**
	 * Permet derechercher une instance par nom.
	 * @param name TODO
	 * @return Instance
	 */
	public Instance findByName(String name);

}
