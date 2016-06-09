/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import static Ui.IhmMenu.setBackgroundImage;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author dandelr
 */
public class IhmInscription {
    private static JFrame window2;
    private JPanel panel_principal,panel_joueur,retour_Demarrer;
    private IhmMenu ihmMenu;
    private IhmGraph ihmGraph;
    
    private ArrayList<Joueur> jTemp;
    private ImageIcon icon;
    private JLabel image1,image2;
    
    
    JTextField joueur1,joueur2,joueur3,joueur4,joueur5,joueur6;
    JLabel ljoueur1,ljoueur2,ljoueur3,ljoueur4,ljoueur5,ljoueur6;
    
    
    
    public IhmInscription(IhmMenu ihmMenu, IhmGraph ihmGraph){
        this.ihmMenu=ihmMenu;
        this.ihmGraph = ihmGraph;
        this.jTemp = new ArrayList();
        window2 = new JFrame("Inscrire joueur");
          
        window2.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);     
        window2.setSize(900, 700);
        window2.setLocationRelativeTo(null);
        
        //icon
        icon = new ImageIcon("policier.gif");
        window2.setIconImage(icon.getImage());
        
        
        
        panel_principal  = new JPanel();
        panel_principal.setLayout(new GridBagLayout());
        GridBagConstraints c0 = new GridBagConstraints();
        
  
        panel_joueur = new JPanel();
        panel_joueur.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        
        retour_Demarrer = new JPanel();
        retour_Demarrer.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        
        
        
        
            //****joueur****
            
            c1.weighty= 1;
            
            
            //joueur 1
            c1.gridx=1;
            c1.gridy=1;
            ljoueur1 = new JLabel("joueur 1:");
            panel_joueur.add(ljoueur1,c1);
                    
            c1.gridx=2;
            c1.gridy=1;
            joueur1 = new JTextField(20);
            joueur1.setDocument(new JTextFieldLimit(10));
            panel_joueur.add(joueur1,c1);
            
        
            //joueur 2        
            c1.gridx=1;
            c1.gridy=2;
            ljoueur2 = new JLabel("joueur 2:");
            panel_joueur.add(ljoueur2,c1);
                   
            c1.gridx=2;
            c1.gridy=2;
            joueur2 = new JTextField(20);
            joueur2.setDocument(new JTextFieldLimit(10));
            panel_joueur.add(joueur2,c1);
                    
            //joueur 3                   
            c1.gridx=1;
            c1.gridy=3;
            ljoueur3 = new JLabel("joueur 3:");
            panel_joueur.add(ljoueur3,c1);
                   
            c1.gridx=2;
            c1.gridy=3;
            joueur3 = new JTextField(20);
            joueur3.setDocument(new JTextFieldLimit(10));
            panel_joueur.add(joueur3,c1);
                    
            //joueur 4
            c1.gridx=1;
            c1.gridy=4;
            ljoueur4 = new JLabel("joueur 4:");
            panel_joueur.add(ljoueur4,c1);
                    
            c1.gridx=2;
            c1.gridy=4;
            joueur4 = new JTextField(20);
            joueur4.setDocument(new JTextFieldLimit(10));
            panel_joueur.add(joueur4,c1);
                    
            //joueur 5
            c1.gridx=1;
            c1.gridy=5;
            ljoueur5 = new JLabel("joueur 5:");
            panel_joueur.add(ljoueur5,c1);
                    
            c1.gridx=2;
            c1.gridy=5;
            joueur5 = new JTextField(20);
            joueur5.setDocument(new JTextFieldLimit(10));
            panel_joueur.add(joueur5,c1);
                    
             //joueur 6
            c1.gridx=1;
            c1.gridy=6;
            ljoueur6 = new JLabel("joueur 6:");
            panel_joueur.add(ljoueur6,c1);
                   
            c1.gridx=2;
            c1.gridy=6;
            joueur6 = new JTextField(20);
            joueur6.setDocument(new JTextFieldLimit(10));
            panel_joueur.add(joueur6,c1);
                    
            panel_joueur.setOpaque(false);       
                    
                    
            //****Bouton****
                    
             //retour
            c2.gridx=1;
            c2.gridy=1;
            c2.ipadx=50;
            JButton retour = new JButton ("Retour");
            retour_Demarrer.add(retour,c2);      
            
            //espace entre retour et demarrer
            c2.gridx=2;
            c2.gridy=1;
            c2.ipadx=300;
            retour_Demarrer.add(new JLabel("  "),c2);        
                    
                    
            //demarrer        
            c2.gridx=3;
            c2.gridy=1;
            c2.ipadx=50;
            JButton demarrer = new JButton ("Démarrer");
            retour_Demarrer.add(demarrer,c2);        
                    
            retour_Demarrer.setOpaque(false);
            
            //****assemblage****
            
            //image
            c0.gridx=1;
            c0.gridy=1;
            image1 = new JLabel(new ImageIcon("image_debut.png"));
            panel_principal.add(image1,c0);
            
            
            
            //image 2
            //image2 = new JLabel(new ImageIcon("monopoly_man.jpg"));
            //window2.add(image2,BorderLayout.WEST);
            try {
                JPanel panel = setBackgroundImage(window2, new File("monopoly_man2.jpg"));
            } catch (IOException e){
                
            }
            
            //espace entre image et joueur
            c0.gridx=1;
            c0.gridy=2;
            c0.ipady=80;
            panel_principal.add(new JLabel("  "),c0);
            
            //joueur
            c0.gridx=1;
            c0.gridy=3;
            panel_principal.add(panel_joueur,c0);
            
            
            //espace entre joueur et bouton
            c0.gridx=1;
            c0.gridy=4;
            c0.ipady=80;
            panel_principal.add(new JLabel("  "),c0);
            
            //bouton
            c0.gridx=1;
            c0.gridy=5;
            panel_principal.add(retour_Demarrer,c0);
            
            
              //bouton retour
        retour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    window2.setVisible(false);
                    ihmMenu.afficherMenu();
                    
                }
             });
        
        demarrer.addActionListener(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                    
                    
                    
                        jTemp.clear();
               
                        if(!joueur1.getText().equals("")){
                            Joueur j = new Joueur(joueur1.getText());
                            jTemp.add(j);
                        }
                        if(!joueur2.getText().equals("")){
                            Joueur j = new Joueur(joueur2.getText());
                            jTemp.add(j);
                        }
                        if(!joueur3.getText().equals("")){
                            Joueur j = new Joueur(joueur3.getText());
                            jTemp.add(j);
                        }
                        if(!joueur4.getText().equals("")){
                            Joueur j = new Joueur(joueur4.getText());
                            jTemp.add(j);
                        }
                        if(!joueur5.getText().equals("")){
                            Joueur j = new Joueur(joueur5.getText());
                            jTemp.add(j);
                        }
                        if(!joueur6.getText().equals("")){
                            Joueur j = new Joueur(joueur6.getText());
                            jTemp.add(j);
                        }
                            
                        if(jTemp.size()<2){
                            JOptionPane.showMessageDialog(window2, "Il faut au moins deux joueurs!");
                        }
                        else{
                            window2.setVisible(false);
                            ihmGraph.setJoueurs(jTemp);
                            //ihmGraph.getListeJoueurs().repaint();
                            ihmGraph.getListeJoueurs().initListeJoueur(jTemp);
                            ihmGraph.lancerPartie();
                            
                            //ihmGraph.getListeJoueurs().updateUI();
                        }
                }
            });
        
        
        
         panel_principal.setOpaque(false);
         window2.add(panel_principal);
    }
    
    
    
    public void inscrireJoueur() {

       
        window2.setVisible(true);     
 
      
    }

    void inscrireJoueurEr() {
        window2.setVisible(true);
    }

//nombre de caractère maximale dans un JTextField   
public class JTextFieldLimit extends PlainDocument {
  private int limit;

  JTextFieldLimit(int limit) {
   super();
   this.limit = limit;
   }

  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null) return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}
}
