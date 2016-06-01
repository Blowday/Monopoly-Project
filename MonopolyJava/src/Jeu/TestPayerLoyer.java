/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
   package Jeu;
import Ui.*;
import Data.*;
import java.util.ArrayList;

/**
 *
 * @author wyklandd
 */
public class TestPayerLoyer {


    private IHMPayerLoyer ihm;
    private Monopoly monopoly;
    private int c;
    
    
    
    public TestPayerLoyer() {
       
        ihm = new IHMPayerLoyer(this);
        monopoly = new Monopoly();
        c = 1;
        lancerPartie();
         
    }
    
    public void inscrireJoueur() {
        monopoly.inscrireJoueur(ihm.inscrireJoueur());
    }
    
    
    public void lancerPartie() {
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur j1 = new Joueur("jc");
        Joueur j2 = new Joueur("robin");
        Joueur j3 = new Joueur("antoine");
        Joueur j4 = new Joueur("damien");
        
        joueurs.add(j1);//achat de prop
        joueurs.add(j2);//echec payement de loyer 
        joueurs.add(j3);//pas assez d'argent pour acheter puis echec payement 2eme loyer
        joueurs.add(j4);//payement loyer 
        
        j2.setCash(5);
        j3.setCash(5);
        monopoly.inscrireJoueur(joueurs);
        
        jouerUnCoup(j3);
        jouerUnCoup(j1);
        jouerUnCoup(j4);
        jouerUnCoup(j2);
        
        
    }
    public Carreau lancerDesAvancer(Joueur j){
         ihm.afficherDebutTour(j);
          
        
                //System.out.println(j.getPositionCourante().getNumero());
                //j.getPositionCourante().getNumero();
                    j.setD1(2);
                    j.setD2(4);
                ihm.afficherDe(j.getD1(),j.getD2());
                if(j.getPositionCourante().getNumero()-1 + j.getD1() + j.getD2() >= 40){
                    j.passageDepart();
                    ihm.passageDepart(j);
                    j.setCarreau(monopoly.getCarreaux().get(  (j.getPositionCourante().getNumero()-1 + j.getD1()+ j.getD2()) - 40    ));
                    //System.out.println("pos: "+j.getPositionCourante().getNumero());
                    //System.out.println("cash :" + j.getCash());
                    
                }
                else {
                    j.setCarreau(monopoly.getCarreaux().get(j.getPositionCourante().getNumero()-1 + j.getD1() + j.getD2()));
                    //System.out.println("pos: "+j.getPositionCourante().getNumero());
                }
                return j.getPositionCourante();
                
                
            
        
        
    }
    public void jouerUnCoup(Joueur j){
        Carreau c = lancerDesAvancer(j);
        //si le joueur arrive sur un carreau achetable
        if(c instanceof CarreauAchetable){
            Evenement e = ((CarreauAchetable) c).action(j);
            //reponse = false n'a pas voulu acheter
            //reponse = true a voulu acheter
            switch (e.getType()) {
                case 1:
                    boolean reponse = ihm.afficherPropostion(e);
                    if (reponse){
                        ((CarreauAchetable) c).setProprio(j);
                        j.payerLoyer(((CarreauAchetable) c).getPrixAchat());
                        //ajout de la propriete dans la bonne liste
                        if(c instanceof Gare){
                            j.ajouterGare((Gare) c);
                        }
                        else if(c instanceof Compagnie){
                            j.ajouterCompagnie((Compagnie) c);
                        }
                        else if(c instanceof ProprieteAConstruire){
                            j.ajouterPropriete((ProprieteAConstruire) c);
                        }
                        ihm.afficherAchat(e);
                        //System.out.println("Argent joueur:"+ j.getCash());//test
                        //System.out.println(c.getNom() +":"+((CarreauAchetable) c).getProprietaire().getName());//test
                    }   break;
                case 2:
                    //deduction du loyer
                    if(c instanceof Compagnie){ //calcul du loyer different pour compagnie
                        if(j.getCash()> ((CarreauAchetable) c).calculLoyer(j.getD1(),j.getD2())){ //si le joueur peux payer

                            j.payerLoyer(((CarreauAchetable) c).calculLoyer(j.getD1(),j.getD2())); //le joueur paye
                            ((CarreauAchetable) c).getProprietaire().recevoirLoyer(((CarreauAchetable) c).calculLoyer(j.getD1(),j.getD2())); //le propriétaire recoit le loyer
                        }
                        else{
                            ((CarreauAchetable) c).getProprietaire().recevoirLoyer(j.getCash()); //le propriétaire recoit l'argent restant du joueur
                            e.setLoyerCase(j.getCash());
                            j.payerLoyer(((CarreauAchetable) c).calculLoyer(j.getD1(),j.getD2()));
                        }
                    }
                    else{
                        if(j.getCash()> ((CarreauAchetable) c).calculLoyer()){ //si le joueur peux payer

                            j.payerLoyer(((CarreauAchetable) c).calculLoyer()); //le joueur paye
                            ((CarreauAchetable) c).getProprietaire().recevoirLoyer(((CarreauAchetable) c).calculLoyer()); //le propriétaire recoit le loyer
                        }
                        else{
                            ((CarreauAchetable) c).getProprietaire().recevoirLoyer(j.getCash()); //le propriétaire recoit l'argent restant du joueur
                            e.setLoyerCase(j.getCash());
                          
                            j.payerLoyer(((CarreauAchetable) c).calculLoyer());
                        }
                    }
                    ihm.afficherDebit(e);
                    break;
                case 3:
                    //j == proprio
                    ihm.afficherJproprio(e);
                    break;
                case 4:
                    ihm.afficherAchatImp(e);
                default:
                    break;
            }
            
        }
        //s'il arrive sur un autre carreau (a gerer plus tard)
        else{
            ihm.autreCarreau();
        }
    }
    
    
    private int roll() {
        return (int) (Math.random() * (7 - 1)) + 1;
    }
    
    
    
  
}