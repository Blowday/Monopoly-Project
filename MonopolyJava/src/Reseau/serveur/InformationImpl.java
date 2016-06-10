/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reseau.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author yvesm
 */

public class InformationImpl extends UnicastRemoteObject implements Information {

    private static final long serialVersionUID = 2674880711467464646L;

    protected InformationImpl() throws RemoteException {

        super();

    }

    @Override
    public String getInformation() throws RemoteException {

        System.out.println("Invocation de la méthode getInformation()");

        return "bonjour";

    }
}
