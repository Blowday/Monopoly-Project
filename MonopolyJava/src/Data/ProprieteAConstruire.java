package Data;

public class ProprieteAConstruire extends CarreauAchetable {

	private Joueur proprietaire;
        int prixLoyer1;
        int prixLoyer2;
        int prixLoyer3;
        int prixLoyer4;
        int prixLoyer5;
        int prixMaison;
        int prixHotel;
        
        public ProprieteAConstruire(int num, String s, String groupe, int pA, int pL, int pL1, int pL2, int pL3, int pL4, int pL5, int pM, int pH) {
            super(num, s, pA, pL);
            prixLoyer1 = pL1;
            prixLoyer2 = pL2;
            prixLoyer3 = pL3;
            prixLoyer4 = pL4;
            prixLoyer5 = pL5;
            prixMaison = pM;
            prixHotel = pH;
        }
        
        public int calculLoyer(){
            //a completer
            return 0;
        }

}