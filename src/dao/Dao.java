package dao;

import java.util.Collection;

/**
 * Interface générique représentant un DAO.
 * @author Arnaud
 * @param <T> TODO
 */
//CHECKSTYLE:OFF: AbbreviationAsWordInNameCheck
public interface Dao<T> {
	//CHECKSTYLE:ON
	/**
	 * Méthode permettant de créer un objet.
	 * @param obj TODO
	 * @return boolean
	 */
	public boolean create(T obj);

	/**
	 * Méthode permettant de rechercher un objet.
	 * @param id TODO
	 * @return object
	 */
	public T find(Integer id);

	/**
	 * Méthode permettant de rechercher une collection d'objet.
	 * @return collection of object
	 */
	public Collection<T> findAll();

	/**
	 * Méthode permettant de mettre à jour un objet.
	 * @param obj objet à mettre à jour
	 * @return boolean
	 */
	public boolean update(T obj);

	/**
	 * Méthode permettant de supprimer un objet.
	 * @param obj objet à supprimer
	 * @return boolean
	 */
	public boolean delete(T obj);

	/**
	 * Méthode permettant de supprimer un ensemble d'objet.
	 * @return boolean
	 */
	public boolean deleteAll();

	/**
	 * Méthode permettant de fermer la connexion à la source des données (bdd ou fichier).
	 */
	public void close();

}
