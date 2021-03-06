package Data;

public abstract class CarreauAchetable extends Carreau {

    //Attributs
    private int prixAchat;
    private int prixLoyer;
    private Joueur proprietaire;

    //Constructeurs
    public CarreauAchetable(int num, String s, int pA, int pL) {
        super(num, s);
        setPrixAchat(pA);
        setPrixLoyer(pL);
        proprietaire = null;
    }
    
    //Méthodes
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
		this.proprietaire = j;
	}
    
    public Joueur getProprietaire() {
		return this.proprietaire;
	}
    
    
    /**
	 * 
	 * @param j
	 */
	public Evenement action(Joueur j) {
		
                
                //si la case n'a pas de proprietaire
		if(null == this.getProprietaire()){
                   return possibiliteAchat(j);
                }
                //si la case a un propriétaire
                else if(this.getProprietaire() != j){
                    return new Evenement(2,this.calculLoyer(j.getD1(),j.getD2()),j,this.getProprietaire(),this.getNom()); //fenetre informant du debit
                } else {
                    return new Evenement(3,this.getNom());
                }
                   
	}

	/**
	 * 
	 * @param j
	 */
	private Evenement possibiliteAchat(Joueur j) {

		 //si le joueur a assez d'argent
                    if(this.getPrixAchat() <= j.getCash()){
                        return new Evenement(1,this.getPrixAchat(),j,this.getNom());
                    }
                    //si le joueur n'a pas assez d'argent
                    else{
                        return new Evenement(4,this.getPrixAchat(),j,this.getNom());
                    }
	}
        
        public abstract int calculLoyer(int d1,int d2);
}