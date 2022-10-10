package transmission;

import java.util.HashMap;
import java.util.Map;

public class AutomaticTransmission implements Transmission {

    private int gear;
    private int[] speedthresholds;

    private int speed;
    private Map<Integer, Integer> speed_gear_map = new HashMap<Integer, Integer>();

    public AutomaticTransmission(int speedthresholds1, int speedthresholds2, int speedthresholds3,
                                 int speedthresholds4, int speedthresholds5) throws IllegalArgumentException{
        if(speedthresholds1 <=0 || speedthresholds2 <= speedthresholds1 ||
                speedthresholds3 <= speedthresholds2 || speedthresholds4 <= speedthresholds3 ||
                speedthresholds5 <= speedthresholds4) {
            throw new IllegalArgumentException("Speed thresholds either < 0 or not in increment");
        }

        speedthresholds = new int[] {speedthresholds1, speedthresholds2, speedthresholds3, speedthresholds4, speedthresholds5};
        this.speed = 0;
        this.gear = 0;

        setGear(speed, speedthresholds);
    }

    public int setGear(int speed, int[] speedthresholds) {
        for (int i = 0; i< speedthresholds.length; i++) {
            if (speed <= speedthresholds[i]) {
                this.gear = i + 1;
                return this.gear;
            }
        }
        return 0;
    }

    public int getGear() {
        return this.gear;
    }

    public int getSpeed() {
        return this.speed;
    }

    /*
    public Map<Integer, Integer> increaseSpeed() {
        this.speed += 2;
        this.gear = getGear(this.speed, this.speedthresholds);
        speed_gear_map.put(this.speed, this.gear);
        return speed_gear_map;
    }

    public Map<Integer, Integer> decreaseSpeed() {
        if( speed <= 0) {
            throw new IllegalArgumentException();
        }
        this.speed -= 2;
        this.gear = getGear(this.speed, this.speedthresholds);
        speed_gear_map.put(this.speed, this.gear);
        return speed_gear_map;
    }
     */

    public Transmission increaseSpeed() {
        this.speed += 2;
        return this;
    }

    public Transmission decreaseSpeed() {
        if( speed <= 0) {
            throw new IllegalArgumentException();
        }
        this.speed -= 2;
        return this;
    }

    @Override
    public String toString() {
        return "Transmission (speed = " + this.speed + ", gear = " + gear + ")";
    }
}