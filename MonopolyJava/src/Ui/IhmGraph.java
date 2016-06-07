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
    
    private JPanel jeu;
    private JPanel plateau;
    private JPanel listeJoueurs;
    
    public IhmGraph(Controleur controleur){
        super("Monopoly");
        
        
        JPanel jeu = new JPanel(new BorderLayout());
          //liste des joueurs
        JPanel listeJoueurs = new JPanel(new GridBagLayout());

        //partie plateau a remplir
        IhmPlateau plateau = new IhmPlateau();
        
        this.add(plateau);
        
        
        //paint(controleur.getMonopoly().getCarreaux());//generation du plateau
    
    }
    
    public void notifier(Evenement e){
    //liste des evènements à gerer
    
       
        switch(e.getType()){
            
            case 1: //1--inscription des joueurs
                this.afficherMenuInscription(); //renvoie une arrayList de joueurs
        }
    }

    
    private void afficherMenuInscription() {//menu d'inscription des joueurs
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*private void paint(HashMap<Integer,Carreau> m) { //Generation du plateau de jeu

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridheight = 0;
        gbc.gridwidth = 0;
        
        int cote = 1;
        for(int i = 0; i < 10; i++){ //generation du premier côté
            gbc.gridwidth = i;
            gbc.gridheight = 0;
            if(m.get(i) instanceof CarreauAchetable){
                IhmPropriete carreau= new IhmPropriete(m.get(i)), cote);
            }
        } 
    }*/
    
    public void afficherPlateau() {
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(1500, 940);
        setVisible(true);                        
    }
    
}
