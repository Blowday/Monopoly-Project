package Jeu;
import Ui.IHM;
import Data.*;



public class Controleur {
    
    private IHM ihm;
    private Monopoly monopoly;
    private int c;
    
    private int d1;
    private int d2;
    
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
           do {
               jouerUnCoup(j);
               
           }while(d1 == d2);
            
        }
        
    }
    public Carreau lancerDesAvancer(Joueur j){
         ihm.afficherDebutTour(j);
          
        
                System.out.println(j.getPositionCourante().getNumero());
                j.getPositionCourante().getNumero();
                this.d1 = roll();
                this.d2 = roll();
                ihm.afficherDe(d1,d2);
                if(j.getPositionCourante().getNumero()-1 + d1 + d2 >= 40){
                    j.passageDepart();
                    j.setCarreau(monopoly.getCarreaux().get(  (j.getPositionCourante().getNumero()-1 + d1 + d2) - 40    ));
                    System.out.println(j.getPositionCourante().getNumero());
                    System.out.println("cash :" + j.getCash());
                    
                }
                else {
                    j.setCarreau(monopoly.getCarreaux().get(j.getPositionCourante().getNumero()-1 + d1 + d2));
                    System.out.println(j.getPositionCourante().getNumero());
                }
                return j.getPositionCourante();
                
                
            
        
        
    }
    public void jouerUnCoup(Joueur j){
        Carreau c = lancerDesAvancer(j);
        //si le joueur arrive sur un carreau achetable
        if(c instanceof CarreauAchetable){
            Evenement e = ((CarreauAchetable) c).action(j);
            //reponse = false ne peux rien faire (pas assez d'argent / debité)
            //reponse = false n'a pas voulu acheter
            //reponse = true a voulu acheter
            
            boolean reponse = true;//ihm.afficherPropostion(e);
            if (reponse){
                ((CarreauAchetable) c).setProprio(j);
                j.payer(((CarreauAchetable) c).getPrixAchat());
                System.out.println("Argent joueur:"+ j.getCash());
                System.out.println(c.getNom() +":"+((CarreauAchetable) c).getProprietaire().getName());
            }
            
        }
        //s'il arrive sur un autre carreau (a gerer plus tard)
        else{
                   
        }
    }
    
    private int roll() {
        return (int) (Math.random() * (7 - 1)) + 1;
    }
    
    
    
  
}