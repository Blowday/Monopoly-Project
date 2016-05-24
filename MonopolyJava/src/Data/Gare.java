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
        
       

}