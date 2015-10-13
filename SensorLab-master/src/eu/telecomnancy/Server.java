package eu.telecomnancy;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements SensorRemote {
	
	ISensor sense;
	
	public Server(ISensor sensor) {
		super();
		sense=sensor;
		
		 if (System.getSecurityManager() == null) {
	            System.setSecurityManager(new SecurityManager());
	        }
	        try {
	            String name = "Server";
	            SensorRemote stub = (SensorRemote) UnicastRemoteObject.exportObject(this, 0);
	            Registry registry = LocateRegistry.getRegistry();
	            registry.rebind(name, stub);
	            System.out.println("ComputeEngine bound");
	        } catch (Exception e) {
	            System.err.println("Server exception:");
	            e.printStackTrace();
	        }
	}

	@Override
	public double getValue() throws SensorNotActivated{
		return sense.getValue();
	}

	@Override
	public void onOff() {
		sense.onOff();
	}

	@Override
	public boolean getStatus() {
		return sense.getStatus();
	}

	
}
