import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherAviary extends Conservatory{
    private static int occupancy = 0;
    private static int aviaryNum = 0;
    private String location;
    private static List<String> aviaryDesc = new ArrayList<String>();

    private static Map<String, ArrayList<String>> GetOtherAviaryMap; static {
        GetOtherAviaryMap = new HashMap<String, ArrayList<String>>();
        GetOtherAviaryMap.put("Ground Floor", new ArrayList<String>());
        GetOtherAviaryMap.put("First Floor", new ArrayList<String>());
    }
    public OtherAviary(Birds bird){

        super(bird);

        if (bird.getClass().equals(flightlessBirds.class)){
            throw new IllegalArgumentException();
        }

        occupancy ++;

        if (occupancy == 1) {
            aviaryDesc.add(bird.GetCharacteristics());
        }
        if (occupancy <=5) {
            aviaryNum = 0;
            location = "Ground Floor";
        }
        else if (occupancy > 5 && occupancy <= 10) {
            aviaryNum = 1;
            location = "First Floor";
        }
        GetOtherAviaryMap.get(location).add(GetAviaryAssignment());
        GetOtherAviaryMap.get(location).add(bird.GetName());

        if (aviaryDesc.contains(bird.GetCharacteristics()) == false) {
            aviaryDesc.add(bird.GetCharacteristics());
        }
    }

    public String GetAviaryAssignment() {
        return "OtherAviary" + aviaryNum;
    }
    public String GetLocation() {
        return location;
    }
    public static List<String> GetDesc() {
        return aviaryDesc;
    }
    public static Map<String, ArrayList<String>> GetOtherAviaryMap() {
        System.out.println("GetOtherAviaryMap: " + GetOtherAviaryMap);
        return GetOtherAviaryMap;
    }
}
