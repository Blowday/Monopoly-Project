/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.IOException;
import java.net.*;

public class Client {
    
    private int port;
    private InetAddress adresse;
    private String nomJoueur;
    private Joueur joueur;
    private Socket socket;
    
    public Client(int port, InetAddress adresse, String nomJoueur){
        port=this.port;
        adresse=this.adresse;
        this.nomJoueur=nomJoueur;
        joueur=new Joueur(nomJoueur);
        try {
            socket = new Socket("localhost", 2009);
        } catch (IOException e) {
            System.err.println("Erreur côté serveur (IOException)");
        }
    }
}
