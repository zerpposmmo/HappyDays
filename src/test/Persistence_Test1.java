/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import algo.Algorithme;
import dao.ArcDao;
import dao.CommandeDao;
import dao.EntrepotDao;
import dao.InstanceDao;
import dao.JpaArcDao;
import dao.JpaCommandeDao;
import dao.JpaEntrepotDao;
import dao.JpaInstanceDao;
import dao.JpaLocalisationDao;
import dao.JpaProduitDao;
import dao.LocalisationDao;
import dao.ProduitDao;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
import lecture.TestRead;
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
            result = TestRead.getCreatedObjects("src/test/instance_0116_131940_Z2.txt");
            InstanceDao instanceDao = JpaInstanceDao.getInstance();
            instanceDao.create(result.getInstance());
            ProduitDao produitDao = JpaProduitDao.getInstance();
            EntrepotDao entrepotDao = JpaEntrepotDao.getInstance();
            entrepotDao.create(result.getEntrepot());
            LocalisationDao localisationDao = JpaLocalisationDao.getInstance();
            for(Localisation l : result.getLocalisations().values()) {
                localisationDao.create(l);
            }
            for(Produit p : result.getProduits().values()) {
                produitDao.create(p);
            }
            ArcDao arcDao = JpaArcDao.getInstance();
            for(Arc a : result.getArcs()) {
                arcDao.create(a);
            }
            CommandeDao commandeDao = JpaCommandeDao.getInstance();
            for(Commande c : result.getCommandes().values()) {
                commandeDao.create(c);
            }
        } catch (Exception ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
