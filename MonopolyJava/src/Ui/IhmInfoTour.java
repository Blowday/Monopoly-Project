/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author perrinan
 */
public class IhmInfoTour extends JPanel {
    
    private IhmGraph ihmGraph;
    private JTextArea infos;
    private JButton acheter,refuser;
    
    public IhmInfoTour(IhmGraph ihmGraph){
        this.ihmGraph = ihmGraph;
        
        infos = new JTextArea("");
        acheter = new JButton("Acheter");
        refuser = new JButton("Refuser");
        acheter.setEnabled(false);
        refuser.setEnabled(false);
        
        
        acheter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ihmGraph.getListeJoueurs().initListeJoueur(ihmGraph.getControleur().getMonopoly().getJoueurs());
                ihmGraph.getListeJoueurs().updateUI();
                //ihmGraph.getListeJoueurs().repaint();
                acheter.setEnabled(false);
                refuser.setEnabled(false);
                ihmGraph.getFin_du_tour().setEnabled(true);
            }
        });
        refuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ihmGraph.getControleur().setReponse(false);
                acheter.setEnabled(false);
                refuser.setEnabled(false);
                 ihmGraph.getFin_du_tour().setEnabled(true);
            }
        });
        this.add(acheter);
        this.add(refuser);
        this.add(infos);
        
    }
    //methodes
    public void activerAchat(){
        this.getInfos().setText(
                        "Vous êtes arrivé sur la case: "+ ihmGraph.getControleur().getjCourant().getPositionCourante().getNom()+"\n"
                        +"Cette case n'a pas de propriétaire \n"+ihmGraph.getControleur().getjCourant().getCash());
               this.getAcheter().setEnabled(true);
               this.getRefuser().setEnabled(true);
               this.updateUI();
               //ihmGraph.getListeJoueurs().repaint();
    }
    public void clearInfos(){
        this.getInfos().setText("");
               
               this.updateUI();
               //ihmGraph.getListeJoueurs().repaint();
    }
    
    //getters/setters
    public JButton getAcheter() {
        return acheter;
    }

    public JButton getRefuser() {
        return refuser;
    }
    
    public JTextArea getInfos(){
        return infos;
    }
}
