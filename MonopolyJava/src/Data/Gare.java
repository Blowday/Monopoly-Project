package Data;

public class Gare extends CarreauAchetable {

    //Constructeurs
    public Gare(int num, String s, int pA) {
        super(num, s, pA, 25);
    }

    //Méthodes
    /**
     *
     * @param loyer
     * @param nb
     */
    @Override
    public int calculLoyer(int d1, int d2) {
        return this.getProprietaire().getNbGares() * this.getPrixLoyer();
    }

}
