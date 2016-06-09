                  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author perrinan
 */
public class IhmDe extends JPanel{

    //private int d;
    private JLabel de;
    private ArrayList<ImageIcon> faceDes;


    public IhmDe(){ 
        faceDes = new ArrayList();
        faceDes.add(new ImageIcon("de1.gif"));
        faceDes.add(new ImageIcon("de2.gif"));
        faceDes.add(new ImageIcon("de3.gif"));
        faceDes.add(new ImageIcon("de4.gif"));
        faceDes.add(new ImageIcon("de5.gif"));
        faceDes.add(new ImageIcon("de6.gif"));
        
        de = new JLabel();
        de.setIcon(faceDes.get(deAleatoire()-1));
        //repaint();
        
        
        this.add(de);

        //System.out.println("Dé 1 : " + d);

    }

    private int deAleatoire() {
        return (int) (Math.random() * (7 - 1)) + 1;
    }
    
    @Override
    public void paint(Graphics g){
        de.setIcon(faceDes.get(deAleatoire()-1));
    }
    
    public void animation(int dFinal){
        /*this.removeAll();
        this.updateUI();
        //this.removeAll();
        
        
        /*
        de1.setIcon(icon);
        for (int i = 0; i < 20; i++) {
            d = deAleatoire();
            
       
            switch (d) {
                case 1:
                    de = de1;
                    break;
                case 2:
                    de = de2;
                    break;
                case 3:
                    de = de3;
                    break;
                case 4:
                    de = de4;
                    break;
                case 5:
                    de = de5;
                    break;
                case 6:
                    de = de6;
                    break;
                   
            }
            this.add(de);
            this.updateUI();
            try {

                Thread.sleep(i*10);
            } catch (InterruptedException ex) {
            }
   
            this.remove(de);
            this.updateUI();
           }  */ 
       for (int i = 0; i < 20; i++) {
           //repaint();
           de.setIcon(faceDes.get(deAleatoire()-1));
          /* try {
                Thread.sleep(i*10);
            } catch (InterruptedException ex) {
            }*/
           
       }
            

       de.setIcon(faceDes.get(dFinal-1));
       this.updateUI();
       
       //repaint();

        
  
    }
}
