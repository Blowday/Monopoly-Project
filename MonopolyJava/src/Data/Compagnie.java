package Data;

public class Compagnie extends CarreauAchetable {

    //Attributs
    private Joueur proprietaire;
    
    //Constructeurs
    public Compagnie(int num, String s, int pA) {
        super(num, s, pA, 0);
    }
    
    //Méthodes
    @Override
    public int calculLoyer(int d1, int d2){
        if(this.getProprietaire().getNbCompagnie() ==2){
            return d1*d2*10;
        }
        else{
            return d1*d2*4;
        }
    }

}