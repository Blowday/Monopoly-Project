package Data;

public class Gare extends CarreauAchetable {

	
        
        public Gare(int num, String s, int pA) {
            super(num, s, pA, 25);
        }
        
        
        
        
	/**
	 * 
	 * @param j
	 */
	public Evenement action(Joueur j) {
		
                
                //si la gare n'a pas de proprietaire
		if(null == this.getProprietaire()){
                   return possibiliteAchat(j);
                }
                //si la gare a un propriétaire
                else if(this.getProprietaire() != j){
                    
                    return new Evenement(2,this.calculLoyer(),j.getArgent(),this.getNom());
                }
                else{
                    return new Evenement(3,this.getNom());
                }
                   
	}

	/**
	 * 
	 * @param j
	 */
	private Evenement possibiliteAchat(Joueur j) {
		// TODO - implement Gare.acheterPropriete
		 //si le joueur a assez d'argent
                    if(this.getPrixAchat() <= j.getArgent()){
                        return new Evenement(1,this.getPrixAchat(),j.getArgent(),this.getNom());
                    }
                    //si le joueur n'a pas assez d'argent
                    else{
                        return new Evenement(2,this.getPrixAchat(),j.getArgent(),this.getNom());
                    }
	}



	/**
	 * 
	 * @param loyer
	 * @param nb
         */
          
	public int calculLoyer(){
		return this.getProprietaire().getNbGares()*this.getPrixLoyer();
	}
        
       

}