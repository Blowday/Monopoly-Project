package Ui;

import Jeu.*;
import Data.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.border.BevelBorder;

public class IHM {
    
    //Attributs
    private Controleur controleur;
    public static JFrame window1,window2;
	private JPanel panel_accueil,panel_principal,panel_joueur,retour_Demarrer;
    //Constructeurs
    public IHM(Controleur c) {
        setControleur(c);
    }

    //Méthodes
    public int afficherMenu() {
        int s;
        
           
            panel_accueil = new JPanel();
            panel_accueil.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
      
            
            
            window1 = new JFrame("Monopoly");
            window1.setSize(900, 700);
            //window1.setContentPane(new JLabel(new ImageIcon("fond.png").getImage()));
     
            
            // Définit la taille de la fenêtre en pixels
            c.gridx=1;
            c.gridy=1;
            
            //image
            JLabel image = new JLabel(new ImageIcon("image_debut.png"));
            panel_accueil.add(image,c);
            
            //espace entre les boutons
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
            
            
            //espace entre les boutons
            c.gridx=1;
            c.gridy=4;
            c.ipady=15;
            panel_accueil.add(new JLabel("  "),c);
            
            
            
            //quitter
            c.gridx=1;
            c.gridy=5;
            c.ipadx=200;
            c.ipady=25;
            JButton quitter = new JButton ("Quitter");
            quitter.setBackground(Color.RED);
            //taille
            Font font2 = new Font("Arial",Font.BOLD,70);
            quitter.setFont(font2);        
            
            
            panel_accueil.add(quitter,c);
            window1.add(panel_accueil);
            
           
            
            jouer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    inscrireJoueur();
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
            window1.setVisible(true);
            
            
            
            
            
            
            
        Scanner sc = new Scanner(System.in);
        System.out.println("            .---.\n"
                + "            |#__|\n"
                + "           =;===;=\n"
                + "           / - - \\\n"
                + "          ( _'.'_ )\n"
                + "         .-`-'^'-`-.\n"
                + "        |   `>o<'   |\n"
                + "        /     :     \\\n"
                + "       /  /\\  :  /\\  \\\n"
                + "     .-'-/ / .-. \\ \\-'-.\n"
                + "      |_/ /-'   '-\\ \\_|\n"
                + "         /|   |   |\\\n"
                + "        (_|  /^\\  |_)\n"
                + "          |  | |  |\n"
                + "          |  | |  |\n"
                + "        '==='= ='==='");
        System.out.println("__________________________________");
        System.out.println("Monopoly : Que voulez vous faire ? ");
        System.out.println("1 : Inscrire joueur");
        System.out.println("2 : Lancer partie");
        System.out.println("3 : Quitter");

        s = sc.nextInt();
        return s;

    }
      
    public void afficherDebutTour(Joueur j) {

        System.out.println("Le joueur " + j.getName() + " lance les dés : ");
    }

    public void afficherDe(int d1, int d2) {
        System.out.println("Dé 1 : " + d1);
        System.out.println("Dé 2 : " + d2);
    }

    public ArrayList<Joueur> inscrireJoueur() {
        ArrayList<Joueur> jTemp = new ArrayList<>();  
        
 
        window2 = new JFrame("Inscrire joueur");
        window2.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);     
        window2.setSize(900, 700);
        
        
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
            
                    //joueur 1
                    c1.gridx=1;
                    c1.gridy=1;
                    JLabel ljoueur1 = new JLabel("joueur 1:");
                    panel_joueur.add(ljoueur1,c1);
                    
                    c1.gridx=2;
                    c1.gridy=1;
                    TextField joueur1 = new TextField(20);
                    panel_joueur.add(joueur1,c1);
        
                    //joueur 2        
                    c1.gridx=1;
                    c1.gridy=2;
                    JLabel ljoueur2 = new JLabel("joueur 2:");
                    panel_joueur.add(ljoueur2,c1);
                    
                    c1.gridx=2;
                    c1.gridy=2;
                    TextField joueur2 = new TextField(20);
                    panel_joueur.add(joueur2,c1);
                    
                    //joueur 3                   
                    c1.gridx=1;
                    c1.gridy=3;
                    JLabel ljoueur3 = new JLabel("joueur 3:");
                    panel_joueur.add(ljoueur3,c1);
                    
                    c1.gridx=2;
                    c1.gridy=3;
                    TextField joueur3 = new TextField(20);
                    panel_joueur.add(joueur3,c1);
                    
                    //joueur 4
                    c1.gridx=1;
                    c1.gridy=4;
                    JLabel ljoueur4 = new JLabel("joueur 4:");
                    panel_joueur.add(ljoueur4,c1);
                    
                    c1.gridx=2;
                    c1.gridy=4;
                    TextField joueur4 = new TextField(20);
                    panel_joueur.add(joueur4,c1);
                    
                    //joueur 5
                    c1.gridx=1;
                    c1.gridy=5;
                    JLabel ljoueur5 = new JLabel("joueur 5:");
                    panel_joueur.add(ljoueur5,c1);
                    
                    c1.gridx=2;
                    c1.gridy=5;
                    TextField joueur5 = new TextField(20);
                    panel_joueur.add(joueur5,c1);
                    
                    //joueur 6
                    c1.gridx=1;
                    c1.gridy=6;
                    JLabel ljoueur6 = new JLabel("joueur 6:");
                    panel_joueur.add(ljoueur6,c1);
                    
                    c1.gridx=2;
                    c1.gridy=6;
                    TextField joueur6 = new TextField(20);
                    panel_joueur.add(joueur6,c1);
                    
                    
                    //Bordure : Rentrer Joueur
                    panel_joueur.setBorder(BorderFactory.createTitledBorder("Rentrer les joueurs :"));
                    
            //****Bouton****
                    
             //retour
            c2.gridx=1;
            c2.gridy=1;
            c2.ipadx=50;
            JButton retour = new JButton ("retour");
            retour_Demarrer.add(retour,c2);      
            
            //espace entre retour et demarer
            c2.gridx=2;
            c2.gridy=1;
            c2.ipadx=300;
            retour_Demarrer.add(new JLabel("  "),c2);        
                    
                    
            //demarer        
            c2.gridx=3;
            c2.gridy=1;
            c2.ipadx=50;
            JButton demarrer = new JButton ("demarrer");
            retour_Demarrer.add(demarrer,c2);        
                    
            
            //****assemblage****
            
            //image
            c0.gridx=1;
            c0.gridy=1;
            JLabel image = new JLabel(new ImageIcon("image_debut.png"));
            panel_principal.add(image,c0);
            
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
            panel_accueil.add(new JLabel("  "),c0);
            
            //bouton
            c0.gridx=1;
            c0.gridy=5;
            panel_principal.add(retour_Demarrer,c0);
            
        window2.add(panel_principal);
        
        
        
        //boutton retour
        retour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    window2.setVisible(false);
                    afficherMenu();
                    
                }
             });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        window2.setVisible(true);            
                    

        
        
        
  /*      String s;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom de joueur: ");
        String n = sc.nextLine();

        jTemp.add(new Joueur(n));

        do {

            System.out.println("Nom de joueur: ");
            n = sc.nextLine();
            jTemp.add(new Joueur(n));

            System.out.println("Nouveau joueur? (o/n)");
            s = sc.nextLine();

        } while (s.equals("o") && jTemp.size() < 6);
*/
        return jTemp;

    }

    private void setControleur(Controleur c) {
        this.controleur = c;
    }

    public boolean afficherProposition(Evenement e) { //fenetre de proposition d'achat
        Scanner sc = new Scanner(System.in);

        System.out.println("Vous êtes arrivé sur la case " + e.getNomCase());
        System.out.println("Cette case n'a pas de propriétaire et coute " + e.getPrixAchatCase());

        System.out.println("Voulez vous l'acheter? (o/n)");
        String r = sc.nextLine();

        if (!"o".equals(r) && !"n".equals(r)) {
            do {
                System.out.println("Entrer une reponse valide: o/n");
                r = sc.nextLine();
            } while (!"o".equals(r) && !"n".equals(r));
        }
        return "o".equals(r);
    }

    public void afficherPassage(Evenement e) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Vous êtes arrivé sur la case " + e.getNomCase());
    }
    
    public void afficherDebit(Evenement e) { //fenetre de notification de débit
        afficherPassage(e);
        System.out.println("Cette case appartient à " + e.getProprio().getName());
        System.out.println("Vous avez payé " + e.getLoyerCase() + " vous avez maintenant " + e.getJoueur().getCash());
        System.out.println("Le propriétaire " + e.getProprio().getName() + " a maintenant " + e.getProprio().getCash());
    }

    public void afficherJproprio(Evenement e) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Vous êtes arrivé sur la case " + e.getNomCase() + " vous en êtes le propriétaire");
    }

    public void autreCarreau() {
        System.out.println("Arrivée sur un autre carreau"); //à changer à l'iplémentation des autres carreaux
    }

    public void partiePerdue() {
        System.out.println("******************");
        System.out.println("*  Partie finie  *");
        System.out.println("******************");
    }

    public void nbJoueursMauvais() {
        System.out.println("Le nombre de joueurs n'est pas respecté ! (2 à 6 joueurs)");
    }

    public void lancerDes(Joueur j) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***************************************************************");
        System.out.print(j.getName() + ", lancez les dés: (enter)");
        sc.nextLine();
    }

    public void afficherAchat(Evenement e) {
        System.out.println("Vous avez acheté " + e.getNomCase() + " il vous reste " + e.getJoueur().getCash());
    }

    public void passageDepart(Joueur j) {
        System.out.println("Vous êtes passé par la case départ, vous avez: " + j.getCash());
    }

    public void afficherAchatImp(Evenement e) {
        System.out.println("Vous êtes arrivé sur la case " + e.getNomCase());
        System.out.println("Cette case n'a pas de porpriétaire et coute " + e.getPrixAchatCase());
        System.out.println("Vous n'avez pas assez d'argents pour l'acheter (" + e.getJoueur().getCash() + ")");
    }

    public void joueurPerdu(Joueur j) {
        System.out.println(j.getName() + " n'a plus assez d'argent pour continuer l'aventure");
    }
}
