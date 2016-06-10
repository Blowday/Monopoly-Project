package Serveur;

import java.io.IOException;
import java.net.*;

public class Serveur {
    int port;
    public Serveur(int port){
        if (port==0){
            port=11111;
        }
        ServerSocket socket;
        try {
            socket = new ServerSocket(port);
            Thread t = new Thread(new AccepterClients(socket));
            t.start();
            System.out.println("Demarrage du serveur");

        } catch (IOException e) {
        }
    }
}
