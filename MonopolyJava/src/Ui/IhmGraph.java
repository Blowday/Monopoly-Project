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
    private JPanel panel_joueur,panel_joueur1,panel_joueur2,panel_joueur3,panel_joueur4,panel_joueur5,panel_joueur6;
    
    
    public IhmGraph(Controleur controleur){
        super("Monopoly");
        this.setLayout(new BorderLayout());
        
        this.controleur = controleur;
        controleur.setObservateur(this);
        
        JPanel jeu = new JPanel(new BorderLayout());
          //liste des joueurs
        JPanel listeJoueurs = new JPanel(new GridBagLayout());

        //partie plateau a remplir
        IhmPlateau plateau = new IhmPlateau();
        
        this.add(plateau, BorderLayout.CENTER);
        
        ihmMenu = new IhmMenu();
        
        de1 = new IhmDe();
        de2 = new IhmDe();
        this.add(de1, BorderLayout.EAST);
        this.add(de2, BorderLayout.EAST);
        //this.add(de2);
        
        initListeJoueur(/*controleur.getJoueurs()*/);
    }
    
    public void notifier(Evenement e){
    //liste des evènements à gerer
    
       
        switch(e.getType()){
            
            case 1: //1--Afficher menu
                ihmMenu.afficherMenu(); //devra renvoyer une arrayList de joueurs
                this.afficherJeu();
                de1.animation(5);
                de2.animation(5);
        
        }
    }


    
    public void afficherJeu() {
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setSize(1350, 940);
        setVisible(true); 
        
    }
    
    public void initListeJoueur(/*ArrayList<Joueur> joueurs*/){

            panel_joueur = new JPanel();
            panel_joueur.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            panel_joueur1 = new JPanel();
            panel_joueur1.setLayout(new GridBagLayout());
            panel_joueur2 = new JPanel();
            panel_joueur2.setLayout(new GridBagLayout());
            panel_joueur3 = new JPanel();
            panel_joueur3.setLayout(new GridBagLayout());;
            panel_joueur4 = new JPanel();
            panel_joueur4.setLayout(new GridBagLayout());
            panel_joueur5 = new JPanel();
            panel_joueur5.setLayout(new GridBagLayout());
            panel_joueur6 = new JPanel(); 
            panel_joueur6.setLayout(new GridBagLayout());
            
            HashMap<Integer,JPanel> listPanel = new HashMap();
            listPanel.put(0, panel_joueur1);
            listPanel.put(1, panel_joueur2);
            listPanel.put(2, panel_joueur3);
            listPanel.put(3, panel_joueur4);
            listPanel.put(4, panel_joueur5);
            listPanel.put(5, panel_joueur6);
            
            
            /*for (int i=0; i<5*2 ; i=i+2){
                c.gridx=1;
                c.gridy=i+1;
                listPanel.get(i/2).add(new JLabel("nom joueur"+((i+1)/2))); 
                listPanel.get(i/2).setBorder(BorderFactory.createTitledBorder(""));
                panel_joueur.add(listPanel.get(i),c);
                this.add(panel_joueur,BorderLayout.WEST);
                
                
                c.gridx=1;
                c.gridy=i+2;
                c.ipady=5;
                panel_joueur.add(new JLabel("  "),c);
                        
                this.add(panel_joueur,BorderLayout.WEST);
                
            }*/
            
            
            
            for (int i=0; i<5 /*controleur.getJoueurs().size()*/ ; i++){
                c.gridx=1;
                c.gridy=i+1;
                listPanel.get(i).add(new JLabel("nom joueur"+(i+1))); 
                listPanel.get(i).setBorder(BorderFactory.createTitledBorder(""));
                panel_joueur.add(listPanel.get(i),c);
                this.add(panel_joueur,BorderLayout.WEST);
                
            }
                
               
    }
    
}
