import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Conservatory {
    private Birds bird;
    private static Map<String, ArrayList<String>> birdAviaryAssignment_map = new HashMap<String, ArrayList<String>>();
    private OtherAviary birdIndex[] = new OtherAviary[100];
    private int index = 0;
    private OtherAviary OtherAviary_temp;
    private FlightlessAviary flightlessAviary_temp;
    private String location;

    public Conservatory(Birds bird) throws IllegalArgumentException {
        if ((GetTotalNumAviary() > 20)) {
            throw new IllegalArgumentException("More than 20 aviaries");
        }
        this.bird = bird;
    }
    public Map<String, ArrayList<String>> AssignAviary(){
        if (bird.getClass().equals(BirdsofPrey.class)) {
            OtherAviary_temp = new OtherAviary(this.bird);
            birdAviaryAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(OtherAviary_temp.GetAviaryAssignment());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(OtherAviary_temp.GetLocation());
        }
        else if (bird.getClass().equals(flightlessBirds.class)) {
            flightlessAviary_temp = new FlightlessAviary(this.bird);
            birdAviaryAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(flightlessAviary_temp.GetAviaryAssignment());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(flightlessAviary_temp.GetLocation());
        }
        return birdAviaryAssignment_map;
    }
    public String GetAviaryAssignment() {
        return this.bird.GetName() + birdAviaryAssignment_map.get(this.bird.GetName());
    }
    public static Map<String, ArrayList<String>> GetMap() {
        return OtherAviary.GetOtherAviaryMap();
    }
    public static Map<String, ArrayList<String>> GetBirdIndex() {
        TreeMap<String, ArrayList<String>> sorted_birdAssignment_map = new TreeMap<>();
        sorted_birdAssignment_map.putAll(birdAviaryAssignment_map);
        return sorted_birdAssignment_map;
    }
    public int GetTotalNumAviary() {
        return OtherAviary.GetNumAviary();
    }
    public void SetLocation(String locationHolder) {
        location = locationHolder;
    }
    public String GetLocation() {
        return location;
    }




}