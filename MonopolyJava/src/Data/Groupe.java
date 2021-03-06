package Data;

import java.util.HashSet;

public class Groupe{

    //Attributs
    private CouleurPropriete couleur;
    private HashSet<ProprieteAConstruire> proprietes;

    //Constructeurs
    public Groupe(CouleurPropriete couleur) {
        this.couleur = couleur;
        proprietes = new HashSet<>();
    }

    //Méthodes
    public void addPropriete(ProprieteAConstruire pac) {
        proprietes.add(pac);
    }

    public CouleurPropriete getCouleur() {
        return couleur;
    }
    
    public HashSet<ProprieteAConstruire> getProprieteAConstruires(){
        return proprietes;
    }
}