package Data;

public class Gare extends CarreauAchetable {

	
        
        public Gare(int num, String s, int pA) {
            super(num, s, pA, 25);
        }
        
        
	/**
	 * 
	 * @param loyer
	 * @param nb
         */
          
	public int calculLoyer(){
		return this.getProprietaire().getNbGares()*this.getPrixLoyer();
	}

    @Override
    public int calculLoyer(int d1, int d2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
       

}