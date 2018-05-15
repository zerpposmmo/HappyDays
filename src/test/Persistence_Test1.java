/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import algo.Algorithme;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
import lecture.TestRead;
import metier.Commande;
import metier.Instance;
import metier.Produit;

/**
 *
 * @author Arnaud
 */
public class Persistence_Test1 {
    public static void main(String[] args) {
        Result r;
        try {
            r = TestRead.getCreatedObjects("src/test/test2.txt");
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
