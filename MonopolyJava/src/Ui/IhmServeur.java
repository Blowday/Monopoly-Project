/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Serveur;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton Demarrer_srv;
    private IhmGraph ihmGraph;
    private Serveur serveur;
    
    
    
    
    
    public IhmServeur(IhmGraph ihmGraph){
        this.ihmGraph = ihmGraph;
        
        windowServeur = new JFrame("IHM serveur");
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
            lport = new JLabel("port :");
            panel_serveur.add(lport,c);
                    
            c.gridx=2;
            c.gridy=1;
            port = new JTextField(15);
            panel_serveur.add(port,c);
            
        
            
            
            //bouton lancer
            c.gridx=1;
            c.gridy=2;
            Demarrer_srv = new JButton ("Lancer");
            panel_serveur.add(Demarrer_srv,c);
    
            Demarrer_srv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if ("".equals(port.getText())){
                        Serveur serveur = new Serveur(0);
                    } else {
                        Serveur serveur = new Serveur(Integer.valueOf(port.getText()));
                    }
                    
                }
             });
            
        windowServeur.add(panel_serveur);
        windowServeur.setVisible(true);
}
}
