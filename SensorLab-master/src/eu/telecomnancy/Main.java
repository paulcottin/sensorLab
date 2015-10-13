/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.RemoteException;

/**
 *
 * @author charoy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	ISensor s = new RandomSensor();
    	Server server = new Server(s);
        
        Client c = new Client();
        try {
			c.menu();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
