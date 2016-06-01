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
            System.out.println("************************************************");
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

    public boolean afficherPropostion(Evenement e) { //fenetre de proposition d'achat
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Vous êtes arrivé sur la case " + e.getNomCase());
        System.out.println("Cette case n'a pas de porpriétaire et coute "+e.getPrixAchatCase());
        
        System.out.println("Voulez vous l'acheter? (o/n)");
        String r = sc.nextLine();
        
        if(!"o".equals(r) && !"n".equals(r)){
            do{
                System.out.println("Entrer une reponse valide: o/n");
                r = sc.nextLine();
            }while(!"o".equals(r) && !"n".equals(r));
        }
        return "o".equals(r);
    }
    
    
    public void afficherDebit(Evenement e) { //fenetre de notification de débit
        System.out.println("---------------------------------------------------------------");
        System.out.println("Vous êtes arrivé sur la case "+e.getNomCase()+" appartennant à "+e.getProprio().getName());
        System.out.println("Vous avez payé "+e.getLoyerCase()+" vous avez maintenant "+e.getJoueur().getCash());
        System.out.println("Le propriétaire "+e.getProprio().getName()+" a maintenant "+e.getProprio().getCash());
    }

    public void afficherJproprio(Evenement e) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Vous êtes arrivé sur la case "+e.getNomCase() + "vous en êtes le propriétaire");
    }

    public void autreCarreau() {
        System.out.println("Arrivée sur un autre carreau"); //à changer à l'iplémentation des autres carreaux
    }

        
    
        
        
        
}