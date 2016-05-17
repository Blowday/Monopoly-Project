package Ui;

import Jeu.*;
import Data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IHM {

	Controleur controleur;

        public IHM (Controleur c) {
            setControleur(c);
        }
        
 
        
        public ArrayList<Joueur> inscrireJoueur() {
            ArrayList<Joueur> jTemp = new ArrayList<>();
            String s;
            Scanner sc = new Scanner(System.in); 
            System.out.println("Nom de joueur: "); String n = sc.nextLine();
            
            jTemp.add(new Joueur(n));
            
            do{
                
            System.out.println("Nom de joueur: "); n = sc.nextLine();
            jTemp.add(new Joueur(n));
            
                System.out.println("Nouveau joueur? (o/n)"); s = sc.nextLine();
            
            
            }while(s.equals("o") && jTemp.size()<6);
            
            return jTemp;

        }
        
        private void setControleur(Controleur c) {
            this.controleur = c;
        }
        
        
        
}