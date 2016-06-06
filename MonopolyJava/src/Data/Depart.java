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
public class Depart extends AutreCarreau {
    private int Gain;
    
    public Depart(int num, String s, int prix) {
        super(num,s);
        this.Gain = prix;
    }
    
    public int getGainDepart() {
        return this.Gain;
    }
}
