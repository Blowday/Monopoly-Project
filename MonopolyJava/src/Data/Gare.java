package Data;

public class Gare extends CarreauAchetable {

	private Joueur proprietaire;

        
        public Gare(int num, String s, int pA) {
            super(num, s, pA, 25);
        }
        
        
        
        
	/**
	 * 
	 * @param j
	 */
	public int action(Joueur j) {
		// TODO - implement Gare.action
		throw new UnsupportedOperationException();
	}

	private int calculLoyer() {
		// TODO - implement Gare.calculLoyer
		throw new UnsupportedOperationException();
	}

	private Joueur getProprietaire() {
		return this.proprietaire;
	}

	/**
	 * 
	 * @param j
	 */
	private void acheterPropriete(Joueur j) {
		// TODO - implement Gare.acheterPropriete
		throw new UnsupportedOperationException();
	}

	public int getPrixAchat() {
		// TODO - implement Gare.getPrixAchat
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param j
	 */
	public void setProprio(Joueur j) {
		// TODO - implement Gare.setProprio
		throw new UnsupportedOperationException();
	}

	public int getLoyer() {
		// TODO - implement Gare.getLoyer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param loyer
	 * @param nb
	 */
	public int calculPrix(int loyer, int nb) {
		// TODO - implement Gare.calculPrix
		throw new UnsupportedOperationException();
	}

}