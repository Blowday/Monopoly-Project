package Data;

import java.util.*;


public class Joueur {

	Collection<Gare> gares;
	private Carreau positionCourante;
	private Collection<Compagnie> mesCompagnies;
	private Collection<ProprieteAConstruire> mesProprietes;
	private String nomJoueur;
	private int cash = 1500;

        
        public Joueur(String s) {
            setNom(s);
        }
        
        
        
	/**
	 * 
	 * @param l
	 */
	public void payerLoyer(int l) {
		// TODO - implement Joueur.payerLoyer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param l
	 */
	public void recevoirLoyer(int l) {
		// TODO - implement Joueur.recevoirLoyer
		throw new UnsupportedOperationException();
	}

	

	/**
	 * 
	 * @param prix
	 */
	public void payer(int prix) {
		cash -= prix;
	}

	public void ajouterGare() {
		// TODO - implement Joueur.ajouterGare
		throw new UnsupportedOperationException();
	}

	public int getNbGares() {
		// TODO - implement Joueur.getNbGares
		throw new UnsupportedOperationException();
	}

	public Carreau getPositionCourante() {
            return positionCourante;
	}
        
        public void setCarreau(Carreau c) {
            positionCourante = c;
        }
        public int getCash() {
            return cash;
        }
        
        public String getName() {
            return nomJoueur;
        }
        
        public void passageDepart() {
            this.cash += 200;
        }
     
        
        
        
        public void afficher() {
            System.out.println("salut je suis a la case : " + this.getPositionCourante().getNumero());
        }
        
        
        private void setNom(String s) {
            this.nomJoueur = s;
        }
        
        
        
        
        

}