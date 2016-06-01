package Data;

public class ProprieteAConstruire extends CarreauAchetable {

    //Attributs
    private Joueur proprietaire;
    private Groupe groupe;
    private int prixLoyer1;
    private int prixLoyer2;
    private int prixLoyer3;
    private int prixLoyer4;
    private int prixLoyer5;
    private int prixMaison;
    private int prixHotel;

    //Constructeurs
    public ProprieteAConstruire(int num, String s, Groupe groupe, int pA, int pL, int pL1, int pL2, int pL3, int pL4, int pL5, int pM, int pH) {
        super(num, s, pA, pL);
        //= CouleurPropriete.valueOf(groupe);
        this.groupe = groupe;
        this.prixLoyer1 = pL1;
        this.prixLoyer2 = pL2;
        this.prixLoyer3 = pL3;
        this.prixLoyer4 = pL4;
        this.prixLoyer5 = pL5;
        this.prixMaison = pM;
        this.prixHotel = pH;
    }

    //Méthodes
    public int calculLoyer() {
        //a completer avec la gestion des maisons/hotel
        return this.getPrixLoyer();

    }

    @Override
    public int calculLoyer(int d1, int d2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
