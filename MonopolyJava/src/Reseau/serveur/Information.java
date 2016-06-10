/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reseau.serveur;

/**
 *
 * @author mugnijea
 */

import java.rmi.*;

public interface Information extends Remote {

    public String getInformation() throws RemoteException;

}
