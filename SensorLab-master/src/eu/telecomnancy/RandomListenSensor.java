/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author charoy
 */
public class RandomListenSensor implements ISensor {

    private boolean status = false; //false = off - true = on
    double start = 50;
    double end = 100;
    private ArrayList<SensorListener> listeners;

    @Override
    public double getValue() throws SensorNotActivated {
        if (status) {
            double random = new Random().nextDouble();
            return start + (random * (end - start));
        } else {
            throw new SensorNotActivated("random Sensor not activated");
        }
    }

    @Override
    public void onOff() {
        status = !status;
    }

    @Override
    public boolean getStatus() {
        return status;
    }
    
    public void addListener(SensorListener s) {
        listeners.add(s);
    }
    
    public void removeListener(SensorListener s) {
        listeners.remove(s);
    }
    
    public void notifyListeners() {
        for (SensorListener sensorListener : listeners) {
            sensorListener.statusChanged();
        }
    }
}
