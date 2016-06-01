package Data;

public class Compagnie extends CarreauAchetable {

    private Joueur proprietaire;
    
    public Compagnie(int num, String s, int pA) {
        super(num, s, pA, 0);
    }
    
    public int calculLoyer(){
        //a completer
        return 0;
    }
    
    public int calculLoyer(int d1, int d2){
        //a completer
        if(this.getProprietaire().getNbCompagnie() ==2){
            return d1*d2*10;
        }
        else{
            return d1*d2*4;
        }
    }

   
}