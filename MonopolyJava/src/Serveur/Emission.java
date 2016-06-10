/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

/**
 *
 * @author yvesm
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Emission implements Runnable {

    private PrintWriter out;
    private String message = null;
    private Scanner sc = null;

    public Emission(PrintWriter out) {
        this.out = out;
    }

    public void run() {

        sc = new Scanner(System.in);

        while (true) {
            System.out.println("Votre message :");
            message = sc.nextLine();
            out.println(message);
            out.flush();
        }
    }
}
