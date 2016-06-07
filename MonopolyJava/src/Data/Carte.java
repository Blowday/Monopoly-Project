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
public abstract class Carte {
    //Type de la carte (chance ou communauté)
    private TypeCarte type;
    
    //String de texte de la carte
    private String string;
    
    public Carte(TypeCarte t, String s) {
        this.type = t;
        this.string = s;
    }
}
