/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reseau.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author wyklandd
 */
public class Client {
    private int port;
    private InetAddress adresse;
    private String nomJoueur;
    
    
    public Client(String nomJoueur){
        port = 22222;
        try{
        adresse=InetAddress.getLocalHost();}
        catch (UnknownHostException ex) {
            System.err.println("Le client ne possède pas d'adresse locale !");
        }
        this.nomJoueur=nomJoueur;
        Connexion();
    }

    public Client(int port, InetAddress adresse, String nomJoueur) {
        this.port = port;
        this.adresse = adresse;
        this.nomJoueur=nomJoueur;
        Connexion();
    }
    
    public void Connexion(){

        Socket socket;

        try {
            socket = new Socket(adresse, port);
            socket.close();

        } catch (UnknownHostException e) {
            System.err.println("Une erreur est survenue côté client (UnknownHostException)");
        } catch (IOException e) {
            System.err.println("Une erreur est survenue côté client (IOException)");
        }
    }
}
