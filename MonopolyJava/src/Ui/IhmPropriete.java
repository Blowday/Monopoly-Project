/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;


import Data.CarreauAchetable;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author perrinan
 */
public class IhmPropriete extends JPanel {
    
    private JLabel nomcase;
    private JLabel prix;
    
    private JPanel couleur;
    

    IhmPropriete(CarreauAchetable c, int cote) {
        super();
        this.setLayout(new BorderLayout());
        nomcase.setText(c.getNom());
        prix.setText(Integer.toString(c.getPrixAchat()));
        couleur.setBackground(c.);
        
    }
    
}
