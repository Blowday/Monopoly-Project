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
public class CartePaiement extends Carte {
    

    //Il peut être positif ou négatif
    private int montant;
    
    
    public CartePaiement(TypeCarte t, String s, int m) {
        super(t, s);
        this.montant = m;
    }
    
}
