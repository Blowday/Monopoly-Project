package Data;

import java.io.IOException;
import java.net.*;

public class Serveur {

    public static void main(String[] zero) {

        ServerSocket socket;
        try {
            socket = new ServerSocket(2009);
            Thread t = new Thread(new AccepterClients(socket));
            t.start();
            System.out.println("Mes employeurs sont prêts !");

        } catch (IOException e) {

            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

}
