package Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Monopoly {
            
        //Attributs
	private HashMap<Integer,Carreau> carreaux;
	private ArrayList<Joueur> joueurs;

        //Constructeur
        public Monopoly(ArrayList<Joueur> jTemp) {
            carreaux = new HashMap<>();
            creerPlateau();
            
            setJoueurs(jTemp);
            
        }
        
        
        
        //Méthode
        
        private void setJoueurs(ArrayList<Joueur> j) {
            joueurs = j;
            
            for (Joueur temp : joueurs) {
                temp.setPosC(carreaux.get(0));
            }
            
        }
        
        public ArrayList<Joueur> getJoueurs() {
            return joueurs;
        }
        
        private void creerPlateau() {
            carreaux.put(0, new AutreCarreau() );
            carreaux.put(1, new CarreauAchetable());
            carreaux.put(2, new CarreauAchetable());
        }
        
        
        
}