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
public class CarteReparation extends CartePaiement {
    
    //Utile seulement en cas de carte réparation maisons et hotels
    private int montant2;
    
    
    public CarteReparation(TypeCarte t, String s, int m, int m2) {
        super(t,s,m);
        this.montant2 = m2;
        
    }
    
    
    
}
