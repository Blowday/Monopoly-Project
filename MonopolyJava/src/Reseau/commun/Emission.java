/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reseau.commun;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author wyklandd
 */
public class Emission implements Runnable{

    private PrintWriter out;
    private String message = null;
    private Scanner sc = null;

    public Emission(PrintWriter out) {
        this.out = out;
    }

    @Override
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
