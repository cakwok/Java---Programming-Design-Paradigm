import java.util.*;

public class BirdsofPreyAviary extends Conservatory{
    private static int occupancy = 0;
    private static int aviaryNum = 0;
    //private String location;
    private static List<String> aviaryDesc = new ArrayList<String>();




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

        Set_map_aviary_bird("OtherAviary" + aviaryNum);

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

}
