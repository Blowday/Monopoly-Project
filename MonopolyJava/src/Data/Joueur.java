package Data;

import java.util.*;


public class Joueur {

	private ArrayList<Gare> mesGares;
	private Carreau positionCourante;
	private ArrayList<Compagnie> mesCompagnies;
	private ArrayList<ProprieteAConstruire> mesProprietes;
	private String nomJoueur;
	private int cash = 1500;

        
        public Joueur(String s) {
            setNom(s);
            mesProprietes = new ArrayList<>();
            mesGares = new ArrayList<>();
            mesCompagnies = new ArrayList<>();
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

	public void ajouterGare(Gare g) {
		this.mesGares.add(g);
            
	}
        public void ajouterCompagnie(Compagnie comp) {
		this.mesCompagnies.add(comp);
            
	}
        public void ajouterPropriete(ProprieteAConstruire p){
                this.mesProprietes.add(p);
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
        public void setCash(int cash){
            this.cash = cash;
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