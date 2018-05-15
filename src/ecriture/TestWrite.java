/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecriture;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Colis;
import metier.Instance;
import metier.QteProduitsColis;
import metier.Solution;
import metier.Tournee;

/**
 *
 * @author Samuel
 */
public class TestWrite {

    /**
     * //NbTournees 2 //IdTournes NbColis 1 6 //IdColis IdCommandeInColis
     * NbProducts IdProd1 QtyProd1 IdProd2 QtyProd2 ... 1 1 13 69 1 44 1 45 4 70
     * 1 71 1 72 1 73 1 54 2 74 1 75 1 76 1 56 2 77 1 2 1 13 78 2 79 2 80 2 81 1
     * 82 1 84 2 85 1 86 2 88 3 89 1 90 1 92 2 93 1 3 1 34 94 3 95 1 100 1 101 1
     * 102 1 103 1 104 1 107 1 108 1 110 1 111 1 112 1 113 1 114 1 115 1 117 1
     * 118 1 119 1 120 1 121 1 122 1 123 1 125 1 126 2 127 1 128 2 130 3 134 1
     * 135 3 136 1 138 1 139 2 140 1 144 4 4 2 34 78 1 60 1 80 1 82 1 83 1 85 2
     * 87 1 91 1 96 1 97 1 98 1 99 1 102 1 104 1 105 1 106 1 107 2 108 2 109 1
     * 111 2 116 1 124 1 127 1 129 1 131 1 132 1 133 1 134 2 135 1 137 1 139 2
     * 141 2 142 1 143 1 5 2 10 144 4 145 1 146 1 149 1 152 7 154 1 157 1 158 1
     * 159 1 160 1 6 1 8 147 1 148 1 150 1 151 1 152 7 153 1 155 1 156 2
     * //IdTournes NbColis 2 6 //IdColis IdCommandeInColis NbProducts IdProd1
     * QtyProd1 IdProd2 QtyProd2 ... 7 1 17 1 1 3 1 4 1 61 1 62 1 63 1 64 1 6 1
     * 7 2 8 2 9 4 65 1 66 1 67 1 11 3 12 2 13 1 8 2 12 2 1 5 1 9 1 10 1 13 1 14
     * 2 15 1 19 1 20 1 21 1 23 2 24 2 9 1 6 15 3 16 1 17 1 18 3 21 3 22 4 10 1
     * 5 23 4 24 1 25 3 26 3 27 1 11 1 12 27 3 29 1 31 2 32 1 33 1 34 2 68 1 35
     * 2 36 2 37 2 38 1 43 1 12 2 20 28 1 30 1 39 1 40 1 41 1 42 1 43 1 46 1 47
     * 1 48 1 49 1 50 1 51 1 52 1 53 1 54 1 55 1 57 1 58 1 59 1
     *
     */
    /**
     *
     * @param i
     */
    public boolean ecrireSolution(Instance i) {
        PrintWriter writer = null;
        String myLineColis ="";
        try {

            for (Solution s : i.getSolutionSet()) {
                writer = new PrintWriter("id" + s.getId() + "_solution.txt", "UTF-8");
                writer.println("//NbTournees");
                writer.println(s.getTournee().size());
                for (Tournee t : s.getTournee()) {
                    writer.println("//IdTournes NbColis");
                    writer.println(t.getId()+" "+t.getColisSet().size());
                    writer.println("//IdColis IdCommandeInColis NbProducts IdProd1 QtyProd1 IdProd2 QtyProd2 ...");
                    for (Colis c : t.getColisSet() ) {
                        myLineColis = "";
                        myLineColis.concat(c.getId()+" "+c.getCommande().getId()+" "+c.getColisProduits().size()+" ");
                        for(QteProduitsColis qpc : c.getColisProduits()){
                                 myLineColis.concat(qpc.getProduit().getId()+" "+qpc.getQuantite()+" ");
                        }
                        writer.println(myLineColis);
                    }
                }
                writer.close();
            }
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestWrite.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TestWrite.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            writer.close();
        }
    }

}
