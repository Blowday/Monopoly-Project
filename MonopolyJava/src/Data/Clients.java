package Data;


import java.io.IOException;

import java.net.*;



public class Clients {
    Socket socket;
    int port;
    String adresse;
    String nomJoueur;
    
    public Clients(int port, String adresse, String nomJoueur){
        
        this.port=port;
        this.adresse=adresse;
        this.nomJoueur=nomJoueur;
        if ("".equals(adresse)){
            adresse="localhost";
        }
        if (port==0){
            port=11111;
        }
        try {
            socket = new Socket(adresse, port);
            socket.close();
        } catch (IOException e) {
            System.err.println("probleme niveau client");
        }

    }

}
