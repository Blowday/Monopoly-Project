package Data;

public class AutreCarreau extends Carreau {
    
    private int prixLoyer;
    
    public AutreCarreau(int num, String s) {
        super(num, s);
    }
    
    public AutreCarreau(int num, String s, int prixLoyer) {
        this(num, s);
        this.prixLoyer = prixLoyer;
    }
    
    
    
    
}