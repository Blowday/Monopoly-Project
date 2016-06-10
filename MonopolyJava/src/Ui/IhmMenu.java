/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Data.Joueur;
import static Ui.IHM.window1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dandelr
 */
public class IhmMenu {
    

    private static JFrame window1;
    private JPanel panel_accueil, panel_multi;
    
    private IhmGraph ihmGraph;
    
    private ArrayList<Joueur> jtemp;
    private ImageIcon icon;
    private IhmClient ihmClient;
    private IhmServeur ihmServeur;

    
    public IhmMenu(IhmGraph ihmGraph){
            this.ihmGraph = ihmGraph;

        
            
            panel_accueil = new JPanel();
            
            
            panel_accueil.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
      
            
            panel_multi = new JPanel();
            panel_accueil.setLayout(new GridBagLayout());
            GridBagConstraints c2 = new GridBagConstraints();
            
            window1 = new JFrame("Monopoly");
            window1.setSize(900, 700);
            window1.setLocationRelativeTo(null);
                 
            
            c.gridx=1;
            c.gridy=1;
            //image
            JLabel image = new JLabel(new ImageIcon("image_debut.png"));
            panel_accueil.add(image,c);
            
            //espace entre image et boutons
            c.gridx=1;
            c.gridy=2;
            c.ipady=80;
            panel_accueil.add(new JLabel("  "),c);
            
            
            //jouer
            c.gridx=1;
            c.gridy=3;
            c.ipadx=400;
            c.ipady=50;
            JButton jouer = new JButton ("Jouer");
            jouer.setBackground(Color.GREEN);
            //taille
            Font font1 = new Font("Arial",Font.BOLD,100);
            jouer.setFont(font1);
           
            panel_accueil.add(jouer,c);
            
            
            
            
            //partie multi
            c2.gridx=1;
            c2.gridy=1;
            JButton multi = new JButton ("Jouer en multijoueur");
            panel_multi.add(multi,c2);
            
            c2.gridx=2;
            c2.gridy=1;
            JButton serveur = new JButton ("Lancer serveur");
            panel_multi.add(serveur,c2);
            panel_multi.setOpaque(false);
            
            c.gridx=1;
            c.gridy=4;
            panel_accueil.add(panel_multi,c);
            
            //espace entre les boutons
            c.gridx=1;
            c.gridy=5;
            c.ipady=0;
            panel_accueil.add(new JLabel("  "),c);
            
            //quitter
            c.gridx=1;
            c.gridy=6;
            c.ipadx=200;
            c.ipady=25;
            JButton quitter = new JButton ("Quitter");
            quitter.setBackground(Color.RED);
            //taille
            Font font2 = new Font("Arial",Font.BOLD,70);
            quitter.setFont(font2);        
            
            
            panel_accueil.add(quitter,c);
            
            
            //multijoueur
            multi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    ihmClient = new IhmClient(ihmGraph);
                }
             });
            
            serveur.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    ihmServeur = new IhmServeur(ihmGraph);
                }
             });
           
            //partie local
            jouer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                    ihmGraph.menuInscription();
                    window1.setVisible(false);
                    
                }
             });
            
            
            quitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    int reponse = JOptionPane.showConfirmDialog(window1,
                        "Voulez-vous quitter le Monopoly",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                        if(reponse == JOptionPane.YES_OPTION ){
                            System.exit(0);
                        }
            }
             });  
            
            
            
            //message de validation quand on appuie sur la croix pour fermer
            window1.addWindowListener( new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    
                    int reponse = JOptionPane.showConfirmDialog(window1,
                    "Voulez-vous quitter le Monopoly",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                    if(reponse == JOptionPane.YES_OPTION ){
                        window1.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                    }
                    if(reponse == JOptionPane.NO_OPTION ){
                            window1.setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
                    }
		}
            });
            
            //fond
            //window1.add(new JLabel(new ImageIcon("dollar.jpg")));
            //window1.pack();
            //window1.add(fond,BorderLayout.CENTER);
            
            //fond
            try {
                JPanel panel = setBackgroundImage(window1, new File("dollar.jpg"));
            } catch (IOException e){
                
            }
            
            panel_accueil.setOpaque(false);
            window1.add(panel_accueil);
            
            //icon
            icon = new ImageIcon("policier.gif");
            window1.setIconImage(icon.getImage());
            
            
            
            
            

    }
    
    
    
    public static JPanel setBackgroundImage(JFrame frame, final File img) throws IOException{
    JPanel panel = new JPanel()
	{
		private static final long serialVersionUID = 1;
		
                
		private BufferedImage buf= ImageIO.read(img);
                
		
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(buf, 0,0, null);
		}
	};
	
	frame.setContentPane(panel);
	
	return panel;
}

    public ArrayList<Joueur> afficherMenu() {
        window1.setVisible(true);
        return jtemp;
    }

    void setIhmgraph(IhmGraph ihmGraph) {
        this.ihmGraph = ihmGraph;
    }
    
}
