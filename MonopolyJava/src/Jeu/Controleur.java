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
    
    public Controleur() {
       
        ihm = new IHM(this);
        monopoly = new Monopoly();
         
    }
    
    public void lancerPartie() {
        
    }
  
}