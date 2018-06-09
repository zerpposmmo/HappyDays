package test;

import algo.Algorithme;
import dao.DaoFactory;
import dao.InstanceDao;
import dao.PersistenceType;
import ecriture.WriteSolution;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
import lecture.ReadFiles;
import metier.Commande;
import metier.Instance;

/**
 * Test de l'écriture en base via JPA
 * @author Arnaud
 */
public class Persistence_Test1 {
    public static void main(String[] args) {
        Result result;
        try {
            result = ReadFiles.getCreatedObjects("src/files/instance_0116_131940_Z2.txt");
            HashSet commandes = new HashSet();
            for (Map.Entry<Long, Commande> entry : result.getCommandes().entrySet()) {
                commandes.add(entry.getValue());
            }
            Algorithme a = new Algorithme(result.getInstance(), commandes, result);
            a.creerSolution();
            
            DaoFactory fabrique = DaoFactory.getDaoFactory(PersistenceType.JPA);
            InstanceDao instanceDao = fabrique.getInstanceDao();
            instanceDao.create(result.getInstance());
            Instance i = instanceDao.find(1);
            WriteSolution.ecrireSolution(i);
        } catch (Exception ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
