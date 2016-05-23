package Jeu;
import Ui.IHM;
import Data.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controleur {
    
    private IHM ihm;
    private Monopoly monopoly;
    private int c;
    
    public Controleur() {
       
        ihm = new IHM(this);
        monopoly = new Monopoly();
        c = 1;
        while( c != 3) { 
            c = ihm.afficherMenu();
            if (c == 1) {
                this.inscrireJoueur();
            }
            else if (c == 2) {
                this.lancerPartie();
            }
        }
         
    }
    
    public void inscrireJoueur() {
        monopoly.inscrireJoueur(ihm.inscrireJoueur());
        
    }
    
    public void lancerPartie() {
        
    }
  
}