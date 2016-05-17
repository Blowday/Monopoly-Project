package Data;


public abstract class Carreau {

	private int numero;
	private String nomCarreau;

        public Carreau(String s) {
            setNom(s);
        }

        
        public int getNumero() {
            return numero;
        }
        
        public void afficher(){
            System.out.println(nomCarreau);
        }
        
        private void setNom(String s) {
            nomCarreau = s;
        }
        
}