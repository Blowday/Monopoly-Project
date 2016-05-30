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
           4-Pas assez d'argent pour acheter
    */
    private int loyerCase;
    private int argentJoueur;
    private String nomCase;
    private int prixAchatCase;

    //Cas 1-2-4
    public Evenement(int typeFenetre, int loyerCase, int argentJoueur, String nomCase) {
        this.typeFenetre = typeFenetre;
        this.loyerCase = loyerCase;
        this.prixAchatCase = loyerCase; //pour le cas 4
        this.argentJoueur = argentJoueur;
        this.nomCase = nomCase;
    }
    //Cas 3
    public Evenement(int typeFenetre, String nomCase){
        this.typeFenetre = typeFenetre;
        this.nomCase = nomCase;
    }
    
    
    
}
