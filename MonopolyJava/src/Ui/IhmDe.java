/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author perrinan
 */
public class IhmDe {
    int d;
    public int afficherDe() throws InterruptedException {
        for(int i=0; i<15; i++){
            deAleatoire();
            switch(d)
            {
                case 1:
                  JLabel de1 = new JLabel( new ImageIcon( "de1.gif"));
                case 2:
                  JLabel de2 = new JLabel( new ImageIcon( "de2.gif")); 
                case 3:
                  JLabel de3 = new JLabel( new ImageIcon( "de3.gif"));  
                case 4:
                  JLabel de4 = new JLabel( new ImageIcon( "de4.gif"));  
                case 5:
                  JLabel de5 = new JLabel( new ImageIcon( "de5.gif")); 
                case 6:
                  JLabel de6 = new JLabel( new ImageIcon( "de6.gif"));
       
            }
            Thread.sleep(200);
        }
            
        
        
        
    System.out.println("Dé 1 : " + d);
        return d;
    }
    
    private int deAleatoire() {
        return (int) (Math.random() * (7 - 1)) + 1;
    }
    
}
