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
        
        public int afficherMenu() {
            int s;
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Monopoly : Que voulez vous faire ? "); 
            System.out.println("1 : Inscrire joueur"); 
            System.out.println("2 : Lancer partie"); 
            System.out.println("3 : Quitter"); 
            
            s = sc.nextInt();
            return s;
            
        }
        
        public void afficherDebutTour(Joueur j) {
            System.out.println("Le joueur " + j.getName() + " lance les dés : ");
        }
        
        public void afficherDe(int d1, int d2) {
            System.out.println("Dé 1 : " + d1);
            System.out.println("Dé 2 : " + d2);
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