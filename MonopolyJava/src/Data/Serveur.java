package Data;

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

class AccepterClients implements Runnable {

    private ServerSocket socketserver;
    private Socket socket;
    private int nbrclient = 1;

    public AccepterClients(ServerSocket s) {
        socketserver = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
                socket = socketserver.accept(); // Un client se connecte on l'accepte
                System.out.println("Le client numéro " + nbrclient + " est connecté !");
                nbrclient++;
                socket.close();
            }
        } catch (IOException e) {
        }
    }

}
