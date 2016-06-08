package Data;

public class Gare extends CarreauAchetable {

    //Constructeurs
    public Gare(int num, String s, int pA) {
        super(num, s, pA, 25);
    }

    //Méthodes
    public int calculLoyer() {
        return this.getProprietaire().getNbGares() * this.getPrixLoyer();
    }

    @Override
    public int calculLoyer(int d1, int d2) {
        return calculLoyer();
    }

}
