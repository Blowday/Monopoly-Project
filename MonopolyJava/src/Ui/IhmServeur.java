/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dandelr
 */
public class IhmServeur {
    private static JFrame windowServeur;
    private JPanel panel_serveur;
    private JLabel lport;
    private JTextField port;
    private JButton Demerrer_srv;
    
    
    
    
    
    
    public IhmServeur(){
        
        windowServeur = new JFrame("IHM client");
        windowServeur.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        windowServeur.setSize(300, 200);
        windowServeur.setLocationRelativeTo(null);
        
        
        panel_serveur = new JPanel();
        panel_serveur.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.weighty= 1;
            
            
            //adresse
            c.gridx=1;
            c.gridy=1;
            lport = new JLabel("adresse :");
            panel_serveur.add(lport,c);
                    
            c.gridx=2;
            c.gridy=1;
            port = new JTextField(15);
            panel_serveur.add(port,c);
            
        
            
            
            //bouton lancer
            c.gridx=1;
            c.gridy=2;
            Demerrer_srv = new JButton ("Lancer");
            panel_serveur.add(Demerrer_srv,c);
    
        windowServeur.add(panel_serveur);
        windowServeur.setVisible(true);
}
}
