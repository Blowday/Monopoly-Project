package Data;

public class Compagnie extends CarreauAchetable {

    private Joueur proprietaire;
    
    public Compagnie(int num, String s, int pA) {
        super(num, s, pA, 0);
    }

}