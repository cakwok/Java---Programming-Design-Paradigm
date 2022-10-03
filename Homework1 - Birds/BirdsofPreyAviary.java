import java.util.*;

public class BirdsofPreyAviary extends Conservatory{
    private static int occupancy = 0;
    private static int aviaryNum = 0;
    //private String location;
    private static List<String> aviaryDesc = new ArrayList<String>();

    private static Dictionary<String, String> aviaryLocation = new Hashtable<>();
    private static Dictionary<String, String> aviaryName = new Hashtable<>();

    public BirdsofPreyAviary(Birds bird){

        super(bird);

        if (!bird.getClass().equals(BirdsofPrey.class)){
            throw new IllegalArgumentException("Birds of prey aviary cannot mix with other birds.");
        }

        occupancy ++;

        if (occupancy % 5 == 1) {
            aviaryNum ++;
        }

        SetLocation(String.valueOf(aviaryNum) + " Floor");

        if (aviaryName.get("BirdsofPreyAviary" + aviaryNum) != null ) {
            aviaryName.put("BirdsofPreyAviary" + aviaryNum, aviaryName.get("BirdsofPreyAviary" + aviaryNum) + " , " + bird.GetName());
        }
        else {
            aviaryName.put("BirdsofPreyAviary" + aviaryNum, bird.GetName());
            aviaryLocation.put(GetLocation(), aviaryName.toString());
        }

        if (occupancy == 1 || aviaryDesc.contains(bird.GetCharacteristics()) == false) {
            aviaryDesc.add(bird.GetCharacteristics());
        }
    }
    public String GetAviaryAssignment() {
        return "BirdsofPreyAviary" + aviaryNum;
    }

    public static List<String> GetDesc() {
        return aviaryDesc;
    }
    public static int GetNumAviary() {
        return aviaryNum;
    }
    /*
    public static Map<String, ArrayList<String>> GetAviaryMap() {
        System.out.println("GetBirdsofPreyAviaryMap: " + OtherAviaryMap);
        return OtherAviaryMap;
    }
     */
    public static Dictionary GetAviaryLocation() {
        return aviaryLocation;
    }

}
