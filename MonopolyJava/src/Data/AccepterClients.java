/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author wyklandd
 */
public class AccepterClients implements Runnable {

    private ServerSocket socketserver = null;
    private Socket socket = null;

    public Thread t1;

    public AccepterClients(ServerSocket ss) {
        socketserver = ss;
    }

    @Override
    public void run() {
        try {
            while (true) {
                socket = socketserver.accept();
                System.out.println("Une personne cherche à se connecter");
//                t1 = new Thread(new Inscription(socket));
//                t1.start();
            }
        } catch (IOException e) {
            System.err.println("Une erreur est survenue côté serveur");
        }
    }

}
