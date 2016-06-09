/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;
import Data.Carreau;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IhmPlateau extends JPanel implements MouseListener{

    private BufferedImage image;
    private HashMap<Integer, Carreau> carreaux;
    private JLabel plateau;

    public IhmPlateau() {
//       try {                
//          image = ImageIO.read(new File("plateau.jpg"));
//       } catch (IOException ex) {
//            // handle exception...
//       }
       
        JLabel plateau = new JLabel( new ImageIcon( "plateau_monop_900*900.png"));
        this.add(plateau);
        addMouseListener(this);
    }

    
    
    @Override
    public void mousePressed(MouseEvent e) {
        int LONGUEUR_CASE = 118;
        int LARGEUR_CASE = 74;
        int NB_CASES = 40;
        
        //Obtenir les coordonnées (x,y) d'une case
        int a = e.getX()-LONGUEUR_CASE;
        int b = e.getY()-LONGUEUR_CASE;
        int x = 0;
        int y = 0;
        while (a>=0 && x<10){
            a-=LARGEUR_CASE;
            x+=1;
        }
        while (b>=0 && y<10){
            b-=LARGEUR_CASE;
            y+=1;
        }
        System.out.println(x+" "+y);
        
        //Convertir les coordonnées en numéros de case
        
        int num=0;
        if (y==0){                       //carreaux du haut du plateau
            num=x;
        } else if (y==10){               //carreaux du bas du plateau
            num=y*3-x;
        } else if (x==0){                //carreaux à gauche du plateau
            num=NB_CASES-y;
        } else if (x==10){               //carreaux à droite du plateau
            num=x+y;
        }
        //Commencer la numérotation à partir de la case départ
        num+=NB_CASES/2;
        if (num>=NB_CASES){
            num-=NB_CASES;
        }
        /*if (num==20 && (x!=0 || y!=0)){
            num=-1;
        }*/
        System.out.println(num);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Ne rien faire
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Ne rien faire
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Ne rien faire
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Ne rien faire
    }
}
