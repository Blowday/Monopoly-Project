/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author perrinan
 */
public class Evenement {
    //classe permettant de gerer les fenetres d'evenement lors d'arrivée sur une case
    private int typeFenetre;
        /* 1-Fenetre d'achat possible
           2-Fenetre de loyer déduit
           3-Vous êtes le porpriétaire
    */
    private int loyerCase;
    private int argentJoueur;
    private String nomCase;

    public Evenement(int typeFenetre, int loyerCase, int argentJoueur, String nomCase) {
        this.typeFenetre = typeFenetre;
        this.loyerCase = loyerCase;
        this.argentJoueur = argentJoueur;
        this.nomCase = nomCase;
    }
    
    
}
