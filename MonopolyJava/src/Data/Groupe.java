package Data;

import java.util.HashSet;

public class Groupe {

	private CouleurPropriete couleur;
        private HashSet<ProprieteAConstruire> proprietes;
        
        public Groupe(CouleurPropriete couleur){
            this.couleur=couleur;
             proprietes = new HashSet<>();
        }

        public void addPropriete(ProprieteAConstruire pac){
            proprietes.add(pac);
        }
        
        public String getCouleur(){
            return couleur.toString();
        }
}