package Data;


public abstract class Carreau {

	private int numero;
	private String nomCarreau;

        public Carreau(int num, String s) {
            setNom(s);
            setNum(num);
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
        
        private void setNum(int num) {
            numero = num;
        }
        
}