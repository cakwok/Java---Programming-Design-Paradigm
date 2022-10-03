import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class FlightlessAviary extends Conservatory{
    private static int occupancy = 0;
    private static int aviaryNum = 0;
    //private String location;
    private static List<String> aviaryDesc = new ArrayList<String>();

    private static Map<String, ArrayList<String>> OtherAviaryMap;
    static {
        OtherAviaryMap = new HashMap<String, ArrayList<String>>();
        OtherAviaryMap.put("1 Floor", new ArrayList<String>());
        OtherAviaryMap.put("2 Floor", new ArrayList<String>());
    }
    public FlightlessAviary(Birds bird){

        super(bird);

        if (!bird.getClass().equals(flightlessBirds.class)){
            throw new IllegalArgumentException();
        }

        occupancy ++;

        if (occupancy % 5 == 1) {
            aviaryNum ++;
        }

        SetLocation(String.valueOf(aviaryNum) + " Floor");

        OtherAviaryMap.get(GetLocation()).add("FlightlessAviary" + aviaryNum);
        OtherAviaryMap.get(GetLocation()).add(bird.GetName());

        if (occupancy == 1 || aviaryDesc.contains(bird.GetCharacteristics()) == false) {
            aviaryDesc.add(bird.GetCharacteristics());
        }
    }
    public String GetAviaryAssignment() {
        return "FlightlessAviary" + aviaryNum;
    }
    public static List<String> GetDesc() {
        return aviaryDesc;
    }
    public static int GetNumAviary() {
        return aviaryNum;
    }
    public static Map<String, ArrayList<String>> GetAviaryMap() {
        System.out.println("FlightlessbirdAviary Map: " + OtherAviaryMap);
        return OtherAviaryMap;
    }
}


