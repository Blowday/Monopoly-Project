
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class AccepterClients implements Runnable {

    private ServerSocket socketserver;
    private Socket socket;
    private int nbrclient = 1;
    private boolean notdemarre = true;

    public AccepterClients(ServerSocket s) {
        socketserver = s;
    }

    @Override
    public void run() {
        try {
            while (nbrclient<=6) {
                socket = socketserver.accept(); // Un client se connecte on l'accepte
                System.out.println("Le client numéro " + nbrclient + " est connecté !");
                nbrclient++;
                socket.close();
            }
        } catch (IOException e) {
        }
    }
    
    public void demarrerPartie(){
        notdemarre=false;
    }

}
