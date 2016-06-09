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
public class Server {
        ServerSocket socketserver  ;

        Socket socketduserveur ;

        public void Connexion(){
        try {
            socketserver = new ServerSocket(2009);
            socketduserveur = socketserver.accept(); 
            System.out.println("Robin se sent rekt !");
                socketserver.close();
                socketduserveur.close();
        }catch (IOException e) {

            e.printStackTrace();

        }
    }
}
