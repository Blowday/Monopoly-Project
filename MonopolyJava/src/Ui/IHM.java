package Ui;

import Jeu.*;
import Data.*;
import java.util.ArrayList;

public class IHM {

	Controleur controleur;

        public ArrayList<Joueur> inscrireJoueur() {
            ArrayList<Joueur> jTemp = new ArrayList<>();
             new Joueur();
            
            Joueur jc = new Joueur();
            jTemp.add(jc);
            
            return jTemp;

        }
        
}