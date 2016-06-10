/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;


import Data.CarreauAchetable;
import Data.Evenement;
import Data.Joueur;
import Jeu.Controleur;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author perrinan
 */
public class IhmGraph extends JFrame implements Observateur {
    
    private IhmMenu ihmMenu;
    private IhmInscription ihmInscription;
    
    private IhmPlateau plateau;

    private IhmDe de1;
    private IhmDe de2;
    
    private Controleur controleur;
    private ImageIcon icon;
    
    //initListeJoueur
    private IhmListeJoueurs panel_joueur;
    //informationTour
    
    
    private JPanel panel_information,panel_de,panel_milieu,panel_batiment;
    private IhmInfoTour panel_tour;
    
    private JButton lancer_des,fin_du_tour;
    private JLabel nb_maison,nb_hotel;
    GridBagConstraints constraintGenerale;

    
    //*****************Constructeur************************
    public IhmGraph(Controleur controleur){
        super("Monopoly");
        this.setLayout(new GridBagLayout());
        constraintGenerale = new GridBagConstraints();
        
        this.controleur = controleur;
        controleur.setObservateur(this);
        
        this.ihmMenu = new IhmMenu(this);

        
        this.ihmInscription = new IhmInscription(ihmMenu,this);

        
        JPanel jeu = new JPanel(new BorderLayout());



       

        
        panel_joueur = new IhmListeJoueurs(this);
        
        
        constraintGenerale.gridx=1;
        constraintGenerale.gridy=1;
        this.add(panel_joueur,constraintGenerale);
         
        
        
        informationTour(); //intialisation du panel information tour
        music(); 
        plateau(); //intialisation du panel milieu (plateau + batiments)
        
         
    //icon
    icon = new ImageIcon("policier.gif");
    this.setIconImage(icon.getImage());
        
    }
    
    
    public IhmListeJoueurs getListeJoueurs(){
        return panel_joueur;
    }

    public Controleur getControleur() {
        return controleur;
    }
    public void setJoueurs(ArrayList<Joueur> jTemp){
        controleur.setJoueur(jTemp);
        
    }
    
    public void notifier(Evenement e){
    //liste des evènements à gerer
    
       
        switch(e.getType()){
            
            case 1: //1--initialisation du jeu(Afficher menu et lancer le jeu)
                ihmMenu.afficherMenu();
                //controleur.inscrireJoueur(ihmInscription.inscrireJoueur()); //devra renvoyer une arrayList de joueurs
                //this.afficherJeu();
                //de1.animation(5);
                //de2.animation(5);
                break;
            case 2:
                ihmInscription.inscrireJoueur();
                break;
            case 3:
                this.afficherJeu();
                break;
                
                //Gestion des evènements à l'arrivée sur un carreau
            case 4: //arrivee sur un carreau achetable
                System.err.println(controleur.getjCourant().getPositionCourante().getNom()); //a enlever
                fin_du_tour.setEnabled(false);
                panel_tour.activerAchat();
                controleur.acheterCarreau(controleur.getjCourant(), (CarreauAchetable) controleur.getjCourant().getPositionCourante());
               

       
                break;
            case 5: //notification de débit
                break;
            case 6://joueur propriétaire de la carte
                break;
            case 7://achat Impossible (griser le bouton achat)
                break;
            case 8://passage impots/taxe
                break;
            case 9://aller en prison
                break;
            case 10: //afficher texte de la carte tirée
                break;
            
        }
    }

    public JButton getFin_du_tour() {
        return fin_du_tour;
    }


    
    public void afficherJeu() {
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setLocationRelativeTo(null);
        setVisible(true); 
    }

    public void menuInscription(){
        controleur.inscrireJoueur();
    }

    public void lancerPartie() {
        controleur.lancerPartie();
    }
    
    
    
    
    
    
    public void informationTour(){
        panel_information = new JPanel();
        panel_information.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        panel_de = new JPanel();
        panel_de.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        
        panel_tour= new IhmInfoTour(this);
        panel_tour.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();
        


        //*****dés*****
        
        de1 = new IhmDe();
        de2 = new IhmDe();
        
        //de1
        c1.gridx=1;
        c1.gridy=1;
        panel_de.add(de1,c1);
        
        //espace entre de1 et de2
        c1.gridx=2;
        c1.gridy=1;
        c.ipadx=15;
        panel_de.add(new JLabel("  "),c1);
        
        //de2
        c1.gridx=3;
        c1.gridy=1;
        panel_de.add(de2,c1);
        
        //bouton lancer dés
        c1.gridx=1;
        c1.gridy=2;
        
        lancer_des = new JButton ("lancer les dés");
        panel_de.add(lancer_des,c1);
        
        panel_information.add(panel_de);
        
        //*****tour*****
        
        //info_tour
        c2.gridx=1;
        c2.gridy=1;
        panel_tour.add(new JLabel("info tour"));
        
        
        
        
    
        //mettre tous dans panel_information
        c.gridx=1;
        c.gridy=1;
        panel_information.add(panel_de,c);
        
        c.gridx=1;
        c.gridy=2;
        panel_information.add(panel_tour,c);
        
        //bouton fin du tour
        c.gridx=1;
        c.gridy=3;
        fin_du_tour = new JButton ("fin du tour");
        panel_information.add(fin_du_tour,c);
        
        
        
        constraintGenerale.gridx=3;
        constraintGenerale.gridy=1;
        this.add(panel_information,constraintGenerale);
    
    
    
    
        lancer_des.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            controleur.lancerDes(controleur.getjCourant());
            
            de1.animation(controleur.getjCourant().getD1());
            de2.animation(controleur.getjCourant().getD2());
            controleur.jouerUnCoup(controleur.getjCourant());
            
            if(controleur.getjCourant().getD1() != controleur.getjCourant().getD2()){
                lancer_des.setEnabled(false);
            }
            else{
                fin_du_tour.setEnabled(false);
            }
        }
        });  
        
        fin_du_tour.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){

            controleur.joueurSuivant();
            lancer_des.setEnabled(true);
            panel_tour.clearInfos();
        }
        });
        
    }
    
    private void plateau() {
        panel_milieu = new JPanel();
        panel_milieu.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        panel_batiment = new JPanel();
        panel_batiment.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        
        //plateau
        plateau = new IhmPlateau();
       
        //nombre de maison et d'immeuble
        //maison
        c1.gridx=1;
        c1.gridy=1;
        JLabel img_maison = new JLabel(new ImageIcon("maison.gif"));
        panel_batiment.add(img_maison,c1);
        
        c1.gridx=2;
        c1.gridy=1;
        nb_maison = new JLabel(": "+"**nombre de maison restant**");
        panel_batiment.add(nb_maison,c1);
        
        //espace entre maison et immeuble
        c.gridx=3;
        c.gridy=1;
        c.ipadx=150;
        panel_batiment.add(new JLabel("  "),c);
        
        
        //immeuble
        c1.gridx=4;
        c1.gridy=1;
        JLabel img_hotel = new JLabel(new ImageIcon("hotel.gif"));
        panel_batiment.add(img_hotel,c1);
        
        c1.gridx=5;
        c1.gridy=1;
        nb_hotel = new JLabel(": "+"**nombre d'hotel restant**");
        panel_batiment.add(nb_hotel,c1);
        
       
        plateau.setSize(900, 900);
        //assemblage
        c.gridx=1;
        c.gridy=1;
        panel_milieu.add(plateau,c);
        
        c.gridx=1;
        c.gridy=2;
        panel_milieu.add(panel_batiment,c);
        
        
        constraintGenerale.gridx=2;
        constraintGenerale.gridy=1;
        this.add(panel_milieu,constraintGenerale);   
        
    }
    
     public static void music() 
    {       
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
            InputStream test = new FileInputStream("music.wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
        }
        catch(IOException error)
        {
        }
        MGP.start(loop);
    }

}

    
