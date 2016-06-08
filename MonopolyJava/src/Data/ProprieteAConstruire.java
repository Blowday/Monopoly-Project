package Data;

public class ProprieteAConstruire extends CarreauAchetable {

    //Attributs
    private Groupe groupe;
    private int nbMaisons;
    private int nbHotels;
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
        setNbHotels(0);
        setNbMaisons(0);
        groupe.addPropriete(this);
    }

    //Méthodes
    public int calculLoyer() {
        int nbPACJoueur = 0;
        if (nbMaisons==0 && nbHotels==0){                                                   //Si terrain nu
            for (ProprieteAConstruire p : getProprietaire().getProprieteAConstruires()){    //Compte le nombre de propriétés à construire du joueur appartenant au groupe de la propriété actuelle
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
        } else if (nbMaisons==1){
            return prixLoyer1;
        } else if (nbMaisons==2){
            return prixLoyer2;
        } else if (nbMaisons==3){
            return prixLoyer3;
        } else if (nbMaisons==4){
            return prixLoyer4;
        } else {
            return prixLoyer5;
        }
        //a completer avec la gestion des maisons/hotel
    }

    @Override
    public int calculLoyer(int d1, int d2) {
        return calculLoyer();
    }
    
    public Groupe getGroupe(){
        return groupe;
    }

    public int getNbMaisons() {
        return nbMaisons;
    }

    public void setNbMaisons(int nbMaisons) {
        this.nbMaisons = nbMaisons;
    }

    public int getNbHotels() {
        return nbHotels;
    }

    public void setNbHotels(int nbHotels) {
        this.nbHotels = nbHotels;
    }
    
    
}
