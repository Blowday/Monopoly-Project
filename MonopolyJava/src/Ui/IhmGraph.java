/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Carreau;
import Data.CarreauAchetable;
import Data.Evenement;
import Data.Joueur;
import Jeu.Controleur;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author perrinan
 */
public class IhmGraph extends JFrame implements Observateur {
    
    private IhmMenu ihmMenu;
    private IhmInscription ihmInscription;
    
    private IhmPlateau plateau;
    private JPanel listeJoueurs;
    private IhmDe de1;
    private IhmDe de2;
    
    private Controleur controleur;

    public IhmGraph(Controleur controleur){
        super("Monopoly");
        this.setLayout(new BorderLayout());

        
        this.controleur = controleur;
        controleur.setObservateur(this);
        
        this.ihmMenu = new IhmMenu(this);

        
        this.ihmInscription = new IhmInscription(ihmMenu,this);

        
        JPanel jeu = new JPanel(new BorderLayout());
          //liste des joueurs
        JPanel listeJoueurs = new JPanel(new GridBagLayout());

        //partie plateau a remplir
        IhmPlateau plateau = new IhmPlateau();
        
        this.add(plateau, BorderLayout.CENTER);
        

        
        de1 = new IhmDe();
        de2 = new IhmDe();
        this.add(de1, BorderLayout.EAST);
        this.add(de2, BorderLayout.EAST);
        //this.add(de2);
        
    }

    public Controleur getControleur() {
        return controleur;
    }
    public void setJoueurs(ArrayList<Joueur> jTemp){
        controleur.setJoueur(jTemp);
    }
    
    public void notifier(Evenement e){
    //liste des evènements à gerer
    
       
        switch(e.getType()){
            
            case 1: //1--initialisation du jeu(Afficher menu et lancer le jeu)
                ihmMenu.afficherMenu();
                //controleur.inscrireJoueur(ihmInscription.inscrireJoueur()); //devra renvoyer une arrayList de joueurs
                //this.afficherJeu();
                //de1.animation(5);
                //de2.animation(5);
                break;
            case 2:
                ihmInscription.inscrireJoueur();
                break;
            
        }
    }


    
    public void afficherJeu() {
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(1350, 940);
        setVisible(true); 
    }

    public void menuInscription(){
        controleur.inscrireJoueur();
    }

    public void lancerPartie() {
        controleur.lancerPartie();
    }
    
}
