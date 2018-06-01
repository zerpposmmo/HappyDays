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
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.ReadFiles;
import lecture.Result;
import metier.Commande;
import metier.Instance;
import metier.Produit;
import metier.Solution;

/**
 *
 * @author Samuel
 */
public class Persistence_Test2 {
    public static void main(String[] args) {
        Result result;
        try {
            result = ReadFiles.getCreatedObjects("src/files/instance_0203_132623_Z1.txt");
            HashSet commandes = new HashSet(result.getCommandes().values());
            Algorithme a = new Algorithme(result.getInstance(), commandes, result);
            Solution bestSolution = null;
            int index = 0;
            for(; index  < 200; index++){
                System.out.println(index);
                a.creerSolutionUpdated();
            }
            
            
            for(Solution s:result.getInstance().getSolutionSet()){
                if(bestSolution == null)
                    bestSolution = s;
                if(s.getDistance() < bestSolution.getDistance())
                    bestSolution = s;
            }
            
            
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
