/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;
import Data.Carreau;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IhmPlateau extends JPanel{

    private BufferedImage image;
    private HashMap<Integer, Carreau> carreaux;
    private JLabel plateau;

    public IhmPlateau() {
//       try {                
//          image = ImageIO.read(new File("plateau.jpg"));
//       } catch (IOException ex) {
//            // handle exception...
//       }
       
        JLabel plateau = new JLabel( new ImageIcon( "plateau.jpg"));
        this.add(plateau);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }
    
    public void mousePressed(MouseEvent e) {
        
    }
}