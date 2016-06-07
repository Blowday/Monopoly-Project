/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author perrinan
 */
public class IhmDe extends JPanel{

    int d;
    JLabel de;

    public IhmDe(){ //passer un des dés en paramètre
        
        
        JLabel de1 = new JLabel(new ImageIcon("de1.gif"));
        de=de1;
        
        this.add(de);

        System.out.println("Dé 1 : " + d);

    }

    private int deAleatoire() {
        return (int) (Math.random() * (7 - 1)) + 1;
    }
    
    public void animation(int dFinal){
        this.removeAll();
        this.updateUI();
        //this.removeAll();
        
        JLabel de1 = new JLabel(new ImageIcon("de1.gif"));
        JLabel de2 = new JLabel(new ImageIcon("de2.gif"));
        JLabel de3 = new JLabel(new ImageIcon("de3.gif"));
        JLabel de4 = new JLabel(new ImageIcon("de4.gif"));
        JLabel de5 = new JLabel(new ImageIcon("de5.gif"));
        JLabel de6 = new JLabel(new ImageIcon("de6.gif"));
        
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
                // Wait for 1 second.
                Thread.sleep(i*10);
            } catch (InterruptedException ex) {
            }
   
            this.remove(de);
            this.updateUI();
           }   
            System.out.println("boucle finie");
            
            

        switch (dFinal) {
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
        System.out.println("rajouté");
  
    }
}
