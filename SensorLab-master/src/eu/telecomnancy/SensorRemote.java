package eu.telecomnancy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SensorRemote extends Remote {

	public double getValue() throws SensorNotActivated, RemoteException;
    public void onOff() throws RemoteException;
    public boolean getStatus() throws RemoteException;
}
