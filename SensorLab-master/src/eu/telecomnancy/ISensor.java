/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

/**
 *
 * @author charoy
 */
public interface ISensor {
    public double getValue() throws SensorNotActivated;
    public void onOff();
    public boolean getStatus();
}
