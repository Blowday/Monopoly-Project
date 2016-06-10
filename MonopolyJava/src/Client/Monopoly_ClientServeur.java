/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author yvesm
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Monopoly_ClientServeur implements Runnable {

    private Socket socket;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private Scanner sc;
    private Thread t3, t4;

    public Monopoly_ClientServeur(Socket s) {
        socket = s;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            sc = new Scanner(System.in);

            Thread t4 = new Thread(new Emission(out));
            t4.start();
            Thread t3 = new Thread(new Reception(in));
            t3.start();

        } catch (IOException e) {
            System.err.println("Le serveur distant s'est déconnecté !");
        }
    }

}
