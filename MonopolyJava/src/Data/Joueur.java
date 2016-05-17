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

	public int getArgent() {
		// TODO - implement Joueur.getArgent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param prix
	 */
	public void payer(int prix) {
		// TODO - implement Joueur.payer
		throw new UnsupportedOperationException();
	}

	public void ajouterGare() {
		// TODO - implement Joueur.ajouterGare
		throw new UnsupportedOperationException();
	}

	public int getNbGares() {
		// TODO - implement Joueur.getNbGares
		throw new UnsupportedOperationException();
	}

	public int getPosC() {
            return positionCourante.getNumero();
	}
        
        public void setPosC(Carreau c) {
            positionCourante = c;
        }

	/**
	 * 
	 * @param p
	 * @param d1
	 * @param d2
	 * @param nbCases
	 */
	public void setNewPos(int p, int d1, int d2, int nbCases) {
                
                //se servir de setPosC une fois qu'on connait le carreau (peut être)
                
		// TODO - implement Joueur.setNewPos
		throw new UnsupportedOperationException();
                //robin
	}
        
        
        
        public void afficher() {
            System.out.println("salut je suis a la case : " + this.getPosC());
        }
        
        
        private void setNom(String s) {
            this.nomJoueur = s;
        }
        
        
        
        
        

}