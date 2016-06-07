package Data;

public class ProprieteAConstruire extends CarreauAchetable {

    //Attributs
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
        groupe.addPropriete(this);
    }

    //Méthodes
    @Override
    public int calculLoyer(int d1, int d2) {
        int nbPACJoueur = 0;
        for (ProprieteAConstruire p : getProprietaire().getProprieteAConstruires()){         //Compte le nombre de propriétés à construire du joueur appartenant au groupe de la propriété actuelle
            if (p.getGroupe()==this.getGroupe()){
                nbPACJoueur+=1;
            }
        }
        int nbPACGroupe = groupe.getProprieteAConstruires().size();                     //Compte le nombre de propriétés à construire dans le groupe de la propriété actuelle
        if (nbPACJoueur==nbPACGroupe){                                                  //Si joueur possède toutes les propriétés du groupe
            return 2*this.getPrixLoyer();                                                                         //le loyer est doublé
        } else {
            return this.getPrixLoyer();                                                 //Sinon le loyer est simple
        }
        //a completer avec la gestion des maisons/hotel
    }
    
    public Groupe getGroupe(){
        return groupe;
    }

}
