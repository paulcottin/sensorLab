/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charoy
 */
public class Client {
	
    SensorRemote sensor;
    Scanner c=new Scanner(System.in);
    
    public Client() {
        
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Server";
            Registry registry = LocateRegistry.getRegistry(0);
            sensor = (SensorRemote) registry.lookup(name);
        } catch (Exception e) {
            System.err.println("Client exception:");
            e.printStackTrace();
        }
    }
    
    public void menu() throws RemoteException {
        String rep="";
        while (!"q".equals(rep)) {
            try {
                rep= c.nextLine();
                switch (rep) {
                    case "o": {
                        sensor.onOff();
                        break;
                    }
                    case "s": {
                        System.out.println("status :"+sensor.getStatus());
                        break;
                    }
                    case "v": {
                        System.out.println("value :"+sensor.getValue());
                        break;
                    }
                    default : System.out.println("q: quitter - o: switch - s: status - v: value");
                }
            } catch (SensorNotActivated ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
//   Code pour JDK 1.6
//
//       public void menu6() {
//        String rep="";
//        while (!"q".equals(rep)) {
//            try {
//                rep= c.nextLine();
//                if ("o".equals(rep))
//                        sense.onOff();
//                else if ("s".equals(rep))
//                        System.out.println("status :"+sense.getStatus());
//                else if ("v".equals(rep))
//                        System.out.println("value :"+sense.getValue());
//                else System.out.println("q: quitter - o: switch - s: status - v: value");
//            } catch (SensorNotActivated ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
