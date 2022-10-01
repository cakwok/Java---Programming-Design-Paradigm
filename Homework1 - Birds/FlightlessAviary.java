/*
import java.util.ArrayList;
import java.util.List;

public class FlightlessAviary extends Conservatory{
    private static int occupancy = 0;
    private static int aviaryNum = 0;
    private String location;
    private static List<String> aviaryDesc = new ArrayList<String>();
    public FlightlessAviary(Birds bird){

        super(bird);
        occupancy ++;

        if (occupancy == 1) {
            aviaryDesc.add(bird.GetCharacteristics());
            System.out.println(bird.GetCharacteristics());
        }
        else if (occupancy <=5) {
            aviaryNum = 0;
            location = "Ground Floor";
        }
        else if (occupancy > 5 && occupancy <= 10) {
            aviaryNum = 1;
            location = "First Floor";
        }

        if (aviaryDesc.contains(bird.GetCharacteristics()) == false) {
            aviaryDesc.add(bird.GetCharacteristics());
        }
    }
    public static int ReturnAviaryNum() {
        return aviaryNum;
    }
    public String GetAviaryAssignment() {
        return "OtherAviary" + aviaryNum;
    }
    public static int GetOccupancy() {
        return occupancy;
    }
    public String GetLocation() {
        return location;
    }
    public static List<String> GetDesc() {
        return aviaryDesc;
    }
}
*/