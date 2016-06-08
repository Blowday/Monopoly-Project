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
public class CarreauTirageCarte extends AutreCarreau {
    
    private TypeCarte type;
    
    public CarreauTirageCarte(int num, String s, TypeCarte t) {
        super(num,s);
        this.type = t;
    }
    
    public TypeCarte getType() {
        return type;
    }
    
}
