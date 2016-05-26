package Jeu;
import Ui.IHM;
import Data.*;



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
        
        for(Joueur j : monopoly.getJoueurs()) {
            ihm.afficherDebutTour(j);
            int d1;
            int d2;
            do {
                System.out.println(j.getPositionCourante().getNumero());
                j.getPositionCourante().getNumero();
                d1 = lanceDe();
                d2 = lanceDe();
                ihm.afficherDe(d1,d2);
                if(j.getPositionCourante().getNumero()-1 + d1 + d2 >= 40){
                    j.passageDepart();
                    j.setCarreau(monopoly.getCarreaux().get(  (j.getPositionCourante().getNumero()-1 + d1 + d2) % 40    ));
                    System.out.println(j.getPositionCourante().getNumero());
                    System.out.println("cash :" + j.getCash());
                }
                else {
                    j.setCarreau(monopoly.getCarreaux().get(j.getPositionCourante().getNumero()-1 + d1 + d2));
                    System.out.println(j.getPositionCourante().getNumero());
                }
                
            }while(d1 == d2);
            
            
            
        }
        
    }
    
    private int lanceDe() {
        return (int) (Math.random() * (7 - 1)) + 1;
    }
    
    
    
  
}