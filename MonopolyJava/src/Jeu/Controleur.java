package Jeu;
import Ui.IHM;
import Data.*;
import Ui.IhmGraph;
import Ui.Observateur;
import java.util.ArrayList;



public class Controleur {
    
    //Attributs
    private IHM ihm;
    private Monopoly monopoly;
    
    private Observateur ihmGraph;
    
    private Joueur jCourant;
    private int numJoueur=-1;
    
    private boolean reponse;
    
    
    public void setObservateur(Observateur ob){
        this.ihmGraph = ob;
    }
    
    //Constructeurs
    public Controleur(){
       
        ihm = new IHM(this);
        
        ihmGraph = new IhmGraph(this);
        monopoly = new Monopoly();
        this.menu();
        
        
        //ihmGraph.notifier(new Evenement(1));
        //while( c != 3) { 
            //c = ihm.afficherMenu();
           
            //if (c == 1) {
                //this.inscrireJoueur();
           //}
            //else if (c == 2) {
                //if (monopoly.getJoueurs().size()>=2 && monopoly.getJoueurs().size()<=6) {

                //}
    //else {
                   // ihm.nbJoueursMauvais();
                //}
                
            //}
       // }
         
    }
    
    //Méthodes
    public void menu(){
        ihmGraph.notifier(new Evenement(1)); //le controleur demande l'affichage du menu de demarrage
    }
    
    public void inscrireJoueur() {
        //monopoly.inscrireJoueur(ihm.inscrireJoueur());  partie texte
        ihmGraph.notifier(new Evenement(2));
   
    }
    
    public void setJoueur(ArrayList<Joueur> jtemp) {
        //monopoly.inscrireJoueur(ihm.inscrireJoueur());  partie texte
        monopoly.inscrireJoueur(jtemp);
    }
    
    
    public void lancerPartie() {//met le premier joueur et affiche le plateau de jeu


        
        joueurSuivant();
        ihmGraph.notifier(new Evenement(3));
        /*int joueursVivants;
        
        joueursVivants=0;
        for(Joueur j: monopoly.getJoueurs()){
                
            if(!j.getPerdu()){
                joueursVivants++;
            }
           
        }
        
        if(joueursVivants > 1){
            joueurSuivant();
            
        }
        else{ 
            //ihmgraph.notifier(new Evenement()) notification de fin de 
        }
       /*
            
            for(Joueur j : monopoly.getJoueurs()) {
            
                if(!j.getPerdu()){
                    jCourant = j;
                    do {    
                        ihm.lancerDes(j);
                        jouerUnCoup(j);
                            if(j.getCash() < 0){
                                j.setD1(1);//on assure la sortie de la boucle
                                j.setD2(0);
                                j.perdu();
                                ihm.joueurPerdu(j);//retire droit de proprio et indique que le joueur a perdu
                            }
                    }while(j.getD1() == j.getD2());
                }
            }
            
        }while(joueursVivants > 1);
        ihm.partiePerdue();*/
        
        
        //this.joueurSuivant();
        
        
    }
    public void lancerDes(Joueur j){
        j.setD1(roll());
        j.setD2(roll());
    }

    
    public Carreau lancerDesAvancer(Joueur j){ //ne lance plus les dés
         //ihm.afficherDebutTour(j);
          
        
                //System.out.println(j.getPositionCourante().getNumero());
                //j.getPositionCourante().getNumero();
                
                ihm.afficherDe(j.getD1(),j.getD2()); //a enlever
                

                
                //En cas de double, on sort le joueur de prison (inutile si le jouer était déjà libre)
                if (j.getD1() == j.getD2()) {
                    j.setPrison(false);
                }
                //si au troisième tour toujours pas de double, le joueur paie et peut partir
                if(j.enPrison() && j.getCompteurPrison() == 2) {
                    j.setPrison(false);
                    j.payer(50);
                }
                
                //Un joueur en prison n'avance pas
                if(!j.enPrison()) {
                
                    //si on passe par la case départ
                    if(j.getPositionCourante().getNumero()-1 + j.getD1()+j.getD2() >= 40){
                        passageDepart(j);
                        ihm.passageDepart(j);
                        j.setCarreau(monopoly.getCarreaux().get(  (j.getPositionCourante().getNumero()-1 + j.getD1()+ j.getD2()) - 40 ));
                        //System.out.println("pos: "+j.getPositionCourante().getNumero());
                        //System.out.println("cash :" + j.getCash());

                    }
                    //coup normal
                    else {
                        j.setCarreau(monopoly.getCarreaux().get(j.getPositionCourante().getNumero()-1 + j.getD1() + j.getD2()));
                        //System.out.println("pos: "+j.getPositionCourante().getNumero());
                    }
                }
                //On compte le nombre de tour que le joueur passe en prison
                else if(j.enPrison()) {
                    j.setCompteurPrison(j.getCompteurPrison()+1);
                }
                return j.getPositionCourante();
    }
    
    public void jouerUnCoup(Joueur j) {
        ihm.afficherDebutTour(j); // a enlever
        Carreau c = lancerDesAvancer(j);
        jouerUnCoup(j,c);
    }
    
    
    public void jouerUnCoup(Joueur j, Carreau c){
        
        //si le joueur arrive sur un carreau achetable
        if(c instanceof CarreauAchetable){
            Evenement e = ((CarreauAchetable) c).action(j);
            
            
            switch (e.getType()) {
                case 1:
                    //boolean reponse = ihm.afficherProposition(e); a enlever ihmtext
                    ihmGraph.notifier(new Evenement(4)); //arrivee sur carreau achetable
                    
                    break;
                case 2:
                    //deduction du loyer
                        
                        if(j.getCash()> ((CarreauAchetable) c).calculLoyer(j.getD1(),j.getD2())){ //si le joueur peux payer

                            j.payer(((CarreauAchetable) c).calculLoyer(j.getD1(),j.getD2())); //le joueur paye
                            ((CarreauAchetable) c).getProprietaire().recevoirLoyer(((CarreauAchetable) c).calculLoyer(j.getD1(),j.getD2())); //le propriétaire recoit le loyer
                        }
                        else{
                            ((CarreauAchetable) c).getProprietaire().recevoirLoyer(j.getCash()); //le propriétaire recoit l'argent restant du joueur
                            e.setLoyerCase(j.getCash());
                            j.payer(((CarreauAchetable) c).calculLoyer(j.getD1(),j.getD2()));
                        }
                    ihmGraph.notifier(new Evenement(5));
                    ihm.afficherDebit(e); //a enlever
                    break;
                case 3:
                    //j == proprio
                    ihm.afficherJproprio(e); //a enlever
                    ihmGraph.notifier(new Evenement(6));
                    break;
                case 4:
                    ihm.afficherAchatImp(e); //a enlever
                    ihmGraph.notifier(new Evenement(7));
                default:
                    break;
            }
            
        }
        else if(c instanceof ImpotsEtTaxes){
            //Si on tombe sur la case Impots ou sur la case Taxes, le joueur paie le montant indiqué
            j.payer(((ImpotsEtTaxes) c).getMontant());
            
            //COMMUNICATION AVEC IHM
            Evenement e = new Evenement(c.getNom());
            ihm.afficherPassage(e);
            System.out.println("Vous avez payé des impots ou des taxes");      //a enlever
            ihmGraph.notifier(new Evenement(8));
                    
        }
        else if(c instanceof AllerEnPrison){
            //Si le joueur tombe sur cette case, il va en Prison
            j.setPrison(true);
            j.setCompteurPrison(0);
            ((Prison)monopoly.getCarreaux().get(10)).addJoueurEnPrison(j);
            j.setCarreau((Prison)monopoly.getCarreaux().get(10));
            
            
            //COMMUNICATION AVEC IHM
            Evenement e = new Evenement(c.getNom());
            ihm.afficherPassage(e);
            System.out.println("Vous êtes en prison");
            ihmGraph.notifier(new Evenement(9));
        }
        else if(c instanceof CarreauTirageCarte) {
            
            this.jouerUneCarte(j, ((CarreauTirageCarte) c).getType());
            // ihmGraph.notifier(new Evenement(10));
            
        }
        else {
            Evenement e = new Evenement(c.getNom());
            ihm.afficherPassage(e);
            ihmGraph.notifier(new Evenement(11));
        }
    }
    
    
    private int roll() {
        return (int) (Math.random() * (7 - 1)) + 1;
    }
    
    private void passageDepart(Joueur j) {
        j.gain(((Depart)monopoly.getCarreaux().get(0)).getGainDepart());
    }


    private void jouerUneCarte(Joueur j, TypeCarte type) {
        Carte carte = monopoly.tirerUneCarte(type);
        
        ihmGraph.notifier(new Evenement(10)); //communication du texte de la carte
        
        if(carte instanceof CarteAnniversaire) {
            //On retire à tous les joueurs 10 (même au joueur actuel car il récupère sa somme juste après)
            for(Joueur temp : monopoly.getJoueurs()) {
                temp.payer(10);
            }
            //On paie le joueur
            j.recevoirLoyer(monopoly.getJoueurs().size() * 10);
        }
        else if(carte instanceof CarteSortiePrison) {
            j.getCartesSortiePrison().add((CarteSortiePrison) carte);
        }
        else if(carte instanceof CarteReparation) {
            // On gère ici la carte reparation
            int nbMaisons = 0;
            int nbHotels = 0;
            for (ProprieteAConstruire pac : j.getProprieteAConstruires()){
                nbMaisons+=pac.getNbMaisons();
                nbHotels+=pac.getNbHotels();
            }
            j.payer(((CarteReparation) carte).getMontant()*nbMaisons+((CarteReparation) carte).getMontant2()*nbHotels);
            
        }
        else if(carte instanceof CarteAllerEnPrison) {
            j.setPrison(true);
            j.setCompteurPrison(0);
            ((Prison)monopoly.getCarreaux().get(10)).addJoueurEnPrison(j);
            j.setCarreau((Prison)monopoly.getCarreaux().get(10));
            
            System.out.println("Vous êtes en prison");
            
        }
        else if(carte instanceof CarteDeplacement) {
            
            int d = ((CarteDeplacement)carte).getDeplacement();
            
            if(d>=0) {
                if(j.getPositionCourante().getNumero()-1 > d) {
                    passageDepart(j);
                }
                j.setCarreau(monopoly.getCarreaux().get(d));
            }
            else {
                j.setCarreau(monopoly.getCarreaux().get(j.getPositionCourante().getNumero()-1 +d));
            }
            jouerUnCoup(j, monopoly.getCarreaux().get(d));
        }
        else {
            ((CartePaiement)carte).action(j);
        }
        if(!(carte instanceof CarteSortiePrison)) {
            monopoly.remettreCarte(carte);
        }

    }

    public void setReponse(Boolean b){
        reponse = b;
    }
    
    public Monopoly getMonopoly() {
        return monopoly;
    }
    public Joueur getjCourant() {
        return jCourant;
    }

    public void joueurSuivant(){

        numJoueur += 1; 
        if(numJoueur == monopoly.getJoueurs().size()){
            numJoueur = 0;
        }
        jCourant = monopoly.getJoueurs().get(numJoueur);
        
       
    }
    
    
    public boolean possibiliteConstruireMaison(Joueur j, ProprieteAConstruire c) {
        boolean groupePossede = j.possedeLeGroupe(c);
        if(groupePossede) {
            if(c.getNbHotels() == 0 && c.getNbMaisons() < 4 && monopoly.getNbMaisonDispo()>0) {
                if(j.getCash() >= c.getPrixMaison()) {
                    boolean test = true;
                    for(ProprieteAConstruire temp : c.getGroupe().getProprieteAConstruires()) {
                        if( (c.getNbMaisons() - temp.getNbMaisons()) >0 ) {
                            test = false;
                        }
                    }
                    return test;
                }
                else {
                    return false;
                }                
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
        
    }
    
    public boolean possibiliteConstruireHotel(Joueur j, ProprieteAConstruire c) {
        boolean groupePossede = j.possedeLeGroupe(c);
        if(groupePossede) {
            if(c.getNbHotels() == 0 && c.getNbMaisons() == 4 && monopoly.getNbHotelDispo()>0) {
                if(j.getCash() >= c.getPrixHotel()) {
                    boolean test = true;
                    for(ProprieteAConstruire temp : c.getGroupe().getProprieteAConstruires()) {
                        if( temp.getNbHotels() == 0 && (c.getNbMaisons() - temp.getNbMaisons()) >0 ) {
                            test = false;
                        }
                    }
                    return test;
                }
                else {
                    return false;
                }                
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    public void construireUneMaison(Joueur j, ProprieteAConstruire c) {
        
        j.setCash(j.getCash()-c.getPrixMaison());
        
        c.setNbMaisons(c.getNbMaisons()+1);
        
        monopoly.setNbMaisonDispo(monopoly.getNbMaisonDispo()-1);
  
    }
    
    public void construireUnHotel(Joueur j, ProprieteAConstruire c) {
        
        j.setCash(j.getCash()-c.getPrixHotel());
        
        c.setNbHotels(1);
        
        c.setNbMaisons(0);
        
        monopoly.setNbHotelDispo(monopoly.getNbHotelDispo()-1);
        
        monopoly.setNbMaisonDispo(monopoly.getNbMaisonDispo()+4);

    }
    
    public void rendreMaisonHotel(Joueur j) {
        int compteurMaison = 0;
        int compteurHotel = 0;
        for(ProprieteAConstruire temp : j.getProprieteAConstruires()) {
            compteurMaison += temp.getNbMaisons();
            compteurHotel += temp.getNbHotels();
            temp.setNbMaisons(0);
            temp.setNbHotels(0);
        }
        monopoly.setNbMaisonDispo(monopoly.getNbMaisonDispo() + compteurMaison);
        monopoly.setNbHotelDispo(monopoly.getNbHotelDispo() + compteurHotel);
    }
    
    
  
    public void acheterCarreau(Joueur j,CarreauAchetable c){
        //boolean reponse = ihm.afficherProposition(e); a enlever ihmtext
                   
                    //reponse = false n'a pas voulu acheter
                    //reponse = true a voulu acheter
                    
                        ((CarreauAchetable) c).setProprio(j);
                        j.payer(((CarreauAchetable) c).getPrixAchat());
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
                        
    }
}
