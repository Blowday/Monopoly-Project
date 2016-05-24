package Data;

public abstract class CarreauAchetable extends Carreau {

    private int prixAchat;
    private int prixLoyer;
    private Joueur proprietaire;

    
    public CarreauAchetable(int num, String s, int pA, int pL) {
        super(num, s);
        setPrixAchat(pA);
        setPrixLoyer(pL);
        proprietaire = null;
    }
    
    
    public int getPrixAchat() {
        return prixAchat;
    }
    
    public int getPrixLoyer() {
        return prixLoyer;
    }
    
    
    
    private void setPrixAchat(int p) {
        this.prixAchat = p;
    }
    
    private void setPrixLoyer(int p) {
        this.prixLoyer = p;
    }
    
    public void setProprio(Joueur j) {
		// TODO - implement Gare.setProprio
		throw new UnsupportedOperationException();
	}
    
    public Joueur getProprietaire() {
		return this.proprietaire;
	}

}