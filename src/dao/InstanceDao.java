package dao;

import lecture.Result;
import metier.Instance;

/**
 * Interface générique représentant un DAO de type Instance.
 * @author Arnaud
 */
public interface InstanceDao extends Dao<Instance> {
        /**
	 * Permet de remplir la base de données
         * à partir d'un objet Result
	 * @param result le résultat de la lecture de fichier
	 * @return Instance
	 */
	public boolean processResult(Result result);
}
