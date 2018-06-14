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
 * Test v1 
 * @author Samuel
 */
public class Persistence_Test3 {
     public static void main(String[] args) {
        Result result;
        ReadFiles readFiles = new ReadFiles();
        long begin;
        long end;
        try {
            //création des objets
            result = readFiles.getCreatedObjects("src/files/instance_0116_131940_Z2.txt");
            //récupération instance
            Instance inst = result.getInstance();
            HashSet<Produit> ps;
            ps = (HashSet<Produit>) inst.getProduitSet();

            HashMap<Long, Produit> p1 = (HashMap<Long, Produit>) result.getProduits();
            Produit p2;
            Long y;
            y = (long) 190;
            p2 = p1.get(y);

            Produit p3 = p1.get((long) 281);
            HashSet commandes = new HashSet(result.getCommandes().values());
            Algorithme a = new Algorithme(result.getInstance(), commandes, result);
            begin = System.currentTimeMillis();
            a.creerSolution();
            end  = System.currentTimeMillis();
            System.out.println("Durée:"+(end-begin));

            //bestSolution.createCheminProduit();

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
