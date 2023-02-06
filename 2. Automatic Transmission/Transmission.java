/*
CS5010 Module 2 Lab - Automatic Transmissions
Wing Man, Kwok
Oct 9 2022
 */
// interface represents a single car transmission.
// implemented this interface in a class called AutomaticTransmission which determines the current gear by the current speed of the car.

package transmission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface Transmission {
    public int getSpeed();
    public int getGear();
    public Transmission increaseSpeed();
    public Transmission decreaseSpeed();
}
