package Jeu;

import Ui.IHM;
import Data.*;




public class Controleur {
    
        
        //MAIN MOTEUR DE JEU 
        public static void main(String[] args) {
            IHM ihm = new IHM();
            
            
            //Inscription des joueurs
            
            Monopoly monopoly = new Monopoly(ihm.inscrireJoueur());
            
            
            for (Joueur temp : monopoly.getJoueurs()) {
                temp.afficher();
            }
            
            
            //création de plateau
                //monopoly.créerPlateau
                
            //Ajouter joueurs inscrits sur case départ
                
            //Lancer la partie !
            
            
            
            
            
            
            
            
            
            

            
        }
    
    
	

	/**
	 * 
	 * @param j
	 */
	public static void jouerUnCoup(Joueur j) {
		// TODO - implement Controleur.jouerUnCoup
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param j
	 */
	private static Carreau lancerDésAvancer(Joueur j) {
		// TODO - implement Controleur.lancerDésAvancer
		throw new UnsupportedOperationException();
	}

	public static int roll() {
		// TODO - implement Controleur.roll
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param j
	 * @param d1
	 * @param d2
	 */
	public static void avancer(Joueur j, int d1, int d2) {
		// TODO - implement Controleur.avancer
		throw new UnsupportedOperationException();
	}
        
}