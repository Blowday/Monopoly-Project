/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.CarreauAchetable;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dandelr
 */
public class IhmPropriete {
    private static JFrame windowPropriete;
    private JPanel panelPropriete,panelBatiment;
    private JLabel nomPropriete, nomProprietaire;
    private JLabel img_maison,img_hotel;
    private JButton achatMaison,retour;

    public IhmPropriete(CarreauAchetable carreau){
        
        windowPropriete = new JFrame("propriete");
        windowPropriete.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        windowPropriete.setSize(200, 300);
        windowPropriete.setLocationRelativeTo(null);
        
        panelPropriete = new JPanel();
        panelPropriete.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        panelBatiment = new JPanel();
        panelBatiment.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        
        //nomPropriete
        c.gridx=1;
        c.gridy=1;
        nomPropriete = new JLabel (carreau.getNom());
        panelPropriete.add(nomPropriete,c);
        
        //nomProprietaire
        c.gridx=1;
        c.gridy=2;
        nomProprietaire = new JLabel (carreau.getProprietaire().getName());
        panelPropriete.add(nomProprietaire,c);
        
        
        //espace entre nomProprietaire et le nombre de batiment
        c.gridx=1;
        c.gridy=3;
        c.ipady=25;
        panelPropriete.add(new JLabel("  "),c);
        
        //nombre de batiment
        int nb_maison=4;/*mettre le nombre de batiment sur cette case (renplacé le 4 par le nombre de maison (integer))*/
        
        
        
        if(nb_maison<5){
            for(int i=0; i<nb_maison; i++) {
                c2.gridx=i+1;
                c2.gridy=1;
                img_maison = new JLabel(new ImageIcon("maison.gif"));
                panelBatiment.add(img_maison,c2);}
            }else{
                c2.gridx=1;
                c2.gridy=1;
                img_hotel = new JLabel(new ImageIcon("hotel.gif"));
                panelBatiment.add(img_hotel,c2);
            }
        
        
        c.gridx=1;
        c.gridy=4;
        c.ipady=5;
        panelPropriete.add(panelBatiment,c);
        
        c.gridx=1;
        c.gridy=5;
        achatMaison = new JButton ("Acheter Maison");
        panelPropriete.add(achatMaison,c);
        
        c.gridx=1;
        c.gridy=6;
        retour = new JButton ("retour");
        panelPropriete.add(retour,c);
        
        windowPropriete.add(panelPropriete);
        windowPropriete.setVisible(true);
        
        
        
        
        retour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    windowPropriete.setVisible(false);
            }
        });
        
        
}
}
