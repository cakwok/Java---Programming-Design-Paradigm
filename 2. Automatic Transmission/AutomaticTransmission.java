/*
CS5010 Module 2 Lab - Automatic Transmissions
Wing Man, Kwok
Oct 9 2022
 */
package transmission;

import java.util.HashMap;
import java.util.Map;

public class AutomaticTransmission implements Transmission {

    //@params gear                  hold the current value of gear
    //@params speedthresholds       hold the speed thresholds input
    //@params speed                 hold the current value of speed
    private int gear;
    private int[] speedthresholds;
    private int speed;

    //constructor that takes 5 speed thresholds for the 6 possible gears in order
    //throw exception when speed threshold <0, or not in ascending order
    public AutomaticTransmission(int speedthresholds1, int speedthresholds2, int speedthresholds3,
                                 int speedthresholds4, int speedthresholds5) throws IllegalArgumentException{
        if(speedthresholds1 <=0 || speedthresholds2 <= speedthresholds1 ||
                speedthresholds3 <= speedthresholds2 || speedthresholds4 <= speedthresholds3 ||
                speedthresholds5 <= speedthresholds4) {
            throw new IllegalArgumentException("Speed thresholds either < 0 or not in increment");
        }

        this.speedthresholds = new int[] {speedthresholds1, speedthresholds2, speedthresholds3, speedthresholds4, speedthresholds5};
        this.speed = 0;
        this.gear = 0;

        setGear(speed);
    }

    //lookup corresponding gear by speed
    public void setGear(int speed) {
        this.gear = 1;
        if (speed == 0) {
            this.gear = 0;
        }
        else {
            for (int i = 0; i < this.speedthresholds.length; i++) {
                if (speed >= this.speedthresholds[i]) {
                    this.gear = i + 2;
                }
            }
        }
    }

    //get the current gear
    public int getGear() {
        return this.gear;
    }

    //get the speed
    public int getSpeed() {
        return this.speed;
    }

    // returns a Transmission object with speed increased by 2 and the appropriate gear
    public Transmission increaseSpeed() {
        this.speed += 2;
        setGear(this.speed);
        return this;
    }

    //returns a Transmission object with speed decreased by 2 and the appropriate gear
    //throw exception if the speed becomes invalid.
    public Transmission decreaseSpeed() {
        if( speed <= 0) {
            throw new IllegalStateException();
        }
        this.speed -= 2;
        setGear(this.speed);
        return this;
    }

    //to get the current state of the transmission (speed and gear)
    @Override
    public String toString() {
        return "Transmission (speed = " + this.speed + ", gear = " + gear + ")";
    }
}