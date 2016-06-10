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
public class IhmClient {
    private static JFrame windowClient;
    private JPanel panel_client;
    private JLabel ladresse,lport,lnom_joueur;
    private JTextField adresse,port,nom_joueur;
    private JButton lancer;
    private IhmGraph ihmGraph;
    
    
    
    
    
    public IhmClient(IhmGraph ihmGraph){
        this.ihmGraph=ihmGraph;
        
        windowClient = new JFrame("IHM client");
        windowClient.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        windowClient.setSize(300, 200);
        windowClient.setLocationRelativeTo(null);
        
        
        panel_client = new JPanel();
        panel_client.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.weighty= 1;
            
            
            //adresse
            c.gridx=1;
            c.gridy=1;
            ladresse = new JLabel("adresse :");
            panel_client.add(ladresse,c);
                    
            c.gridx=2;
            c.gridy=1;
            adresse = new JTextField(15);
            panel_client.add(adresse,c);
            
        
            //port        
            c.gridx=1;
            c.gridy=2;
            lport = new JLabel("port :");
            panel_client.add(lport,c);
                   
            c.gridx=2;
            c.gridy=2;
            port = new JTextField(15);
            panel_client.add(port,c);
                    
            //nom joueur                  
            c.gridx=1;
            c.gridy=3;
            lnom_joueur = new JLabel("nom joueur :");
            panel_client.add(lnom_joueur,c);
                   
            c.gridx=2;
            c.gridy=3;
            nom_joueur = new JTextField(15);
            panel_client.add(nom_joueur,c);
            
            //bouton lancer
            c.gridx=1;
            c.gridy=4;
            lancer = new JButton ("Lancer");
            panel_client.add(lancer,c);
            
        windowClient.add(panel_client);
        windowClient.setVisible(true);
    }
    
}
