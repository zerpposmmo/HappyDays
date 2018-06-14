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
 * Test de calcul des temps d'exuecutions
 *
 * @author Samuel
 */
public class Test6 {

    public static void main(String[] args) {
        String[] fichier = new String[10];
        int i;

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

        for (i = 0; i < fichier.length; i++) {
            Result result;
            ReadFiles readFiles = new ReadFiles();
            long begin;
            long end;

            //Lecture Fichier
            try {
                result = readFiles.getCreatedObjects("src/files/" + fichier[i]);
                HashSet commandes = new HashSet(result.getCommandes().values());
                Algorithme a = new Algorithme(result.getInstance(), commandes, result);
                Solution bestSolution = null;
                int index = 0;
                System.out.println("======      Fichier "+fichier[i]+"       ========\n");
                //V1
                begin = System.currentTimeMillis();
                a.creerSolution();
                end = System.currentTimeMillis();
                System.out.println("Durée V1 :" + (end - begin)+"\n");
                
                
                
                //V3
                begin = System.currentTimeMillis();
                for (; index < 2000; index++) {
                    // System.out.println(index);
                    a.creerSolutionUpdated();
                }
                end = System.currentTimeMillis();

                //Display
                System.out.println("Durée V3 :" + (end - begin)+"\n");

            } catch (Exception ex) {
                Logger.getLogger(Test6.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
