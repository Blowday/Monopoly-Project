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
        //rajouter une boucle pour gerer la continuité du jeu (basée sur l'attribut "perdu" des joueurs =>compter les joueurs "vivants")
        
        for(Joueur j : monopoly.getJoueurs()) {
           if(!j.getPerdu()){ 
            do {
                jouerUnCoup(j);
                if(j.getCash() < 0){
                    this.setD1(1);//on assure la sortie de la boucle
                    this.setD2(0);
                    j.perdu();//retire droit de proprio et inique que le joueur a perdu
                }
            }while(d1 == d2);
           } 
        }
        
    }
    public Carreau lancerDesAvancer(Joueur j){
         ihm.afficherDebutTour(j);
          
        
                //System.out.println(j.getPositionCourante().getNumero());
                //j.getPositionCourante().getNumero();
                this.setD1(roll());
                this.setD2(roll());
                ihm.afficherDe(d1,d2);
                if(j.getPositionCourante().getNumero()-1 + d1 + d2 >= 40){
                    j.passageDepart();
                    j.setCarreau(monopoly.getCarreaux().get(  (j.getPositionCourante().getNumero()-1 + d1 + d2) - 40    ));
                    System.out.println("pos: "+j.getPositionCourante().getNumero());
                    System.out.println("cash :" + j.getCash());
                    
                }
                else {
                    j.setCarreau(monopoly.getCarreaux().get(j.getPositionCourante().getNumero()-1 + d1 + d2));
                    System.out.println("pos: "+j.getPositionCourante().getNumero());
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
                        System.out.println("Argent joueur:"+ j.getCash());//test
                        System.out.println(c.getNom() +":"+((CarreauAchetable) c).getProprietaire().getName());//test
                    }   break;
                case 2:
                    //deduction du loyer
                    if(j.getCash()> ((CarreauAchetable) c).calculLoyer()){ //si le joueur peux payer
                        
                        j.payerLoyer(((CarreauAchetable) c).calculLoyer()); //le joueur paye
                        ((CarreauAchetable) c).getProprietaire().recevoirLoyer(((CarreauAchetable) c).calculLoyer()); //le propriétaire recoit le loyer
                    }
                    else{
                        ((CarreauAchetable) c).getProprietaire().recevoirLoyer(j.getCash()); //le propriétaire recoit l'argent restant du joueur
                        j.payerLoyer(((CarreauAchetable) c).calculLoyer());
                    }   ihm.afficherDebit(e);
                    break;
                case 3:
                    //j == proprio
                    ihm.afficherJproprio(e);
                    break;
                default:
                    break;
            }
            
        }
        //s'il arrive sur un autre carreau (a gerer plus tard)
        else{
            ihm.autreCarreau();
        }
    }
    
    public void setD1(int d){
        this.d1 = d;
    }
    public void setD2(int d){
        this.d2 = d;
    }
    private int roll() {
        return (int) (Math.random() * (7 - 1)) + 1;
    }
    
    
    
  
}