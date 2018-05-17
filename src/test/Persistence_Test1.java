/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import algo.Algorithme;
import dao.ArcDao;
import dao.CommandeDao;
import dao.DaoFactory;
import dao.EntrepotDao;
import dao.InstanceDao;
import dao.JpaArcDao;
import dao.JpaCommandeDao;
import dao.JpaEntrepotDao;
import dao.JpaInstanceDao;
import dao.JpaLocalisationDao;
import dao.JpaProduitDao;
import dao.LocalisationDao;
import dao.PersistenceType;
import dao.ProduitDao;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
import lecture.ReadFiles;
import metier.Arc;
import metier.Commande;
import metier.Instance;
import metier.Localisation;
import metier.Produit;

/**
 *
 * @author Arnaud
 */
public class Persistence_Test1 {
    public static void main(String[] args) {
        Result result;
        try {
            result = ReadFiles.getCreatedObjects("src/files/instance_0116_131940_Z2.txt");
            DaoFactory fabrique = DaoFactory.getDaoFactory(PersistenceType.JPA);
            InstanceDao instanceDao = fabrique.getInstanceDao();
            instanceDao.create(result.getInstance());
            
        } catch (Exception ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
