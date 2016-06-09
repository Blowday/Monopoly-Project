/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author perrinan
 */
public class IhmListeJoueurs extends JPanel {
    private IhmGraph ihmGraph;

    
    public IhmListeJoueurs(IhmGraph ihmgraph){
        this.ihmGraph = ihmGraph;
        
        this.setLayout(new GridBagLayout());
    }
    
    public void initListeJoueur(ArrayList<Joueur> joueurs){

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        
        for(Joueur j: joueurs){
            JPanel joueur = new JPanel();
            joueur.setBorder(BorderFactory.createTitledBorder(""));
            joueur.add(new JLabel("<html>"+j.getName()+"<span>:</span>"+"<br>"+"<span>argent: </span>"+j.getCash()+"<span>$</span>"+"</html>")); 
                
            joueur.setBorder(BorderFactory.createTitledBorder(""));
            this.add(joueur,c);
            c.gridy++;
            
            c.ipady=10;
            this.add(new JLabel("  "),c);
            c.gridy++;
        }
     
    }
    /*public void paint(Graphics g){
        if(ihmGraph.getControleur().getMonopoly().getJoueurs() != null){
            this.initListeJoueur(ihmGraph.getControleur().getMonopoly().getJoueurs());
            
        }
    }*/
}
