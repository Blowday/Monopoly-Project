/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author perrinan
 */
public class IhmInfoTour extends JPanel {
    
    private IhmGraph ihmGraph;
    private JTextArea infos;
   
    private GridBagConstraints c;
    
    public IhmInfoTour(IhmGraph ihmGraph){
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        this.ihmGraph = ihmGraph;
        
        infos = new JTextArea("");
        
        
        
        c.gridx = 1;
        c.gridy = 1;
        infos.setPreferredSize(new Dimension(350,50));
        infos.setMinimumSize(new Dimension(350,50));
        infos.setMaximumSize(new Dimension(350,50));
        this.add(infos,c);        
        
    }
    //methodes
    public void activerAchat(){
        this.getInfos().setText(
                        "Vous êtes arrivé sur la case: "+ ihmGraph.getControleur().getjCourant().getPositionCourante().getNom()+"\n"
                        +"Cette case n'a pas de propriétaire \n"+ihmGraph.getControleur().getjCourant().getCash());
               ihmGraph.getAcheter().setEnabled(true);
               ihmGraph.getRefuser().setEnabled(true);
               this.updateUI();
               //ihmGraph.getListeJoueurs().repaint();
    }
    public void clearInfos(){
        this.getInfos().setText(" ");
               
               this.updateUI();
               //ihmGraph.getListeJoueurs().repaint();
    }
    
    //getters/setters
   
    
    public JTextArea getInfos(){
        return infos;
    }
}
