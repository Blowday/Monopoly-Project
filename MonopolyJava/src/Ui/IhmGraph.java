/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Carreau;
import Data.CarreauAchetable;
import Data.Evenement;
import Jeu.Controleur;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author perrinan
 */
public class IhmGraph extends JFrame implements Observateur {
    
    private IhmMenu ihmMenu;
    private IhmInscription ihmInscription;
    
    private JPanel jeu;
    private JPanel plateau;
    private JPanel listeJoueurs;
    
    private Controleur controleur;
    
    
    
    public IhmGraph(Controleur controleur){
        super("Monopoly");
        
        this.controleur = controleur;
        controleur.setObservateur(this);
        
        JPanel jeu = new JPanel(new BorderLayout());
          //liste des joueurs
        JPanel listeJoueurs = new JPanel(new GridBagLayout());

        //partie plateau a remplir
        IhmPlateau plateau = new IhmPlateau();
        
        this.add(plateau);
        
        ihmMenu = new IhmMenu();
        ihmInscription = new IhmInscription();
        
    
    }
    
    public void notifier(Evenement e){
    //liste des evènements à gerer
    
       
        switch(e.getType()){
            
            case 1: //1--Afficher menu
                ihmMenu.afficherMenu(); //devra renvoyer une arrayList de joueurs
                this.afficherJeu();
        }
    }


    
    public void afficherJeu() {
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setVisible(true);                        
    }
    
}
