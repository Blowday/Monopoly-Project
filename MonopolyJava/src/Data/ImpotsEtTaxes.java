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
public class ImpotsEtTaxes extends AutreCarreau{
    //Attributs
        private int montant;

    //Constructeur
        public ImpotsEtTaxes(int num, String s, int prix) {
            super(num, s);
            this.montant = prix;
        }
        
    //Méthodes
    
        public int getMontant() {
            return montant;
        }
    
}
