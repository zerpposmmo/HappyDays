/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import algo.Algorithme;
import dao.DaoFactory;
import dao.InstanceDao;
import dao.PersistenceType;
import ecriture.WriteSolution;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.ReadFiles;
import lecture.Result;
import metier.Instance;
import metier.Solution;

/**
 *
 * @author Samuel
 */
public class Persistence_Test2 {

    public static void main(String[] args) {
        Result result;
        ReadFiles readFiles = new ReadFiles();
        long begin;
        long end;
        try {
            String[] fichier = new String[10];
            fichier[0] = "instance_0116_131940_Z2.txt";
            fichier[1] = "instance_0116_131950_Z1.txt";
            fichier[2] = "instance_0130_132439_Z2.txt";
            fichier[3] = "instance_0202_132568_Z2.txt";
            fichier[4] = "instance_0203_132623_Z1.txt";
            fichier[5] = "instance_0214_132873_Z2.txt";
            fichier[6] = "instance_0215_132916_Z2.txt";
            fichier[7] = "instance_0606_136170_Z1.txt";
            fichier[8] = "instance_0606_136175_Z1.txt";
            fichier[9] = "instance_0606_136178_Z1.txt";
            
            result = readFiles.getCreatedObjects("src/files/"+fichier[9]);
            HashSet commandes = new HashSet(result.getCommandes().values());
            Algorithme a = new Algorithme(result.getInstance(), commandes, result);
            Solution bestSolution = null;
            int index = 0;
            begin = System.currentTimeMillis();
            for (; index < 200; index++) {
                // System.out.println(index);
                a.creerSolutionUpdated();
            }
            end = System.currentTimeMillis();
            System.out.println("Durée:" + (end - begin));
            for (Solution s : result.getInstance().getSolutionSet()) {
                if (bestSolution == null) {
                    bestSolution = s;
                }
                if (s.getDistance() < bestSolution.getDistance()) {
                    bestSolution = s;
                }
            }

            HashSet<Solution> sss = (HashSet<Solution>) result.getInstance().getSolutionSet();
            sss.clear();
            sss.add(bestSolution);

            bestSolution.createCheminProduit();

            DaoFactory fabrique = DaoFactory.getDaoFactory(PersistenceType.JPA);
            InstanceDao instanceDao = fabrique.getInstanceDao();
            instanceDao.create(result.getInstance());
            Instance i = instanceDao.find(1);
            WriteSolution.ecrireSolution(a.getInstance());
        } catch (Exception ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
