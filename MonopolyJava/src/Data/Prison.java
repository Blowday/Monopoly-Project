/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author wyklandd
 */
public class Prison extends AutreCarreau{
    //Attributs
    private ArrayList<Joueur> joueursEnPrison;
            
    //Constructeur
    public Prison(int num, String s) {
        super(num,s);
        joueursEnPrison = new ArrayList<Joueur>();
    }
    
    //Méthodes
    public ArrayList<Joueur> getJoueursEnPrison() {
        return joueursEnPrison;
    }
    
    public void addJoueurEnPrison(Joueur j) {
        joueursEnPrison.add(j);
    }
    
    public void removeJoueurDePrison(Joueur j) {
        if(joueursEnPrison.contains(j)) {
            joueursEnPrison.remove(j);
        }
    }
    
}
