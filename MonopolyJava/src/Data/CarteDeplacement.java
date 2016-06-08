/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author wyklandd
 */
public class CarteDeplacement extends Carte {
    
    //Valeur de déplacement (numéro de la case ou doit se déplacer le joueur par défaut, nombre de case à reculer si nombre négatif
    private int deplacement;
    
    public CarteDeplacement(TypeCarte t, String s, int d) {
        super(t, s);
        this.deplacement = d;
    }
    
    public int getDeplacement() {
        return deplacement;
    }
    
}
