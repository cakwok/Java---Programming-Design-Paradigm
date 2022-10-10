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
