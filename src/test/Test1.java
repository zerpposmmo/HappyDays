/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lecture.Result;
import lecture.TestRead;

/**
 * Lecture des fichiers et création des objets 
 * @author Samuel
 */
public class Test1 {
    public static void main(String[] args){
        Result r;
        try {
            r = TestRead.getCreatedObjects("src/test/test.txt");
            System.out.println(r.toString());
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
