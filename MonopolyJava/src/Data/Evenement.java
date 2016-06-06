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
//classe permettant de gerer les fenetres d'evenement lors d'arrivée sur une case
public class Evenement {
    //Attributs
    private int typeFenetre;
        /* 1-Fenetre d'achat possible
           2-Fenetre de loyer déduit
           3-Vous êtes le porpriétaire
           4-Pas assez d'argent pour acheter
    */
    private int loyerCase;
    private Joueur joueur;
    private String nomCase;
    private int prixAchatCase;
    private Joueur proprio;

    //Constructeurs
    //Cas 1-4
    public Evenement(int typeFenetre, int loyerCase, Joueur j, String nomCase) {
        this.typeFenetre = typeFenetre;
        this.loyerCase = loyerCase;
        this.prixAchatCase = loyerCase; //pour le cas 4
        this.joueur = j;
        this.nomCase = nomCase;
    }
    //Cas 2
    public Evenement(int typeFenetre, int loyerCase, Joueur j, Joueur Proprio, String nomCase) {
        this.typeFenetre = typeFenetre;
        this.loyerCase = loyerCase;
        this.prixAchatCase = loyerCase; //pour le cas 4
        this.joueur = j;
        this.nomCase = nomCase;
        this.proprio = Proprio;
    }
    
    //Cas 3
    public Evenement(int typeFenetre, String nomCase){
        this.typeFenetre = typeFenetre;
        this.nomCase = nomCase;
    }
    
    //Méthodes
    public int getType(){
        return typeFenetre;
    }

    public int getTypeFenetre() {
        return typeFenetre;
    }

    public int getLoyerCase() {
        return loyerCase;
    }

    public Joueur getJoueur(){
        return joueur;
    }

    public String getNomCase() {
        return nomCase;
    }

    public int getPrixAchatCase() {
        return prixAchatCase;
    }
    
    public Joueur getProprio(){
        return proprio;
    }
    public void setLoyerCase(int i){
        this.loyerCase =i;
    }
    
}
