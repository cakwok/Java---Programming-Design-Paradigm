import java.util.*;

public class Conservatory {
    private Birds bird;
    private static Map<String, ArrayList<String>> birdAviaryAssignment_map = new HashMap<String, ArrayList<String>>();

    private OtherAviary OtherAviary_temp;
    private FlightlessAviary flightlessAviary_temp;
    private BirdsofPreyAviary birdsOfPrey_temp;

    private String location;
    private static int Count_birdsOfPrey, Count_flightlessBirds, Count_otherBirds;

    public Conservatory(Birds bird) throws IllegalArgumentException {
        if ((GetTotalNumAviary() > 20)) {
            throw new IllegalArgumentException("More than 20 aviaries");
        }
        this.bird = bird;
    }
    public Map<String, ArrayList<String>> AssignAviary(){
        if (bird.getClass().equals(BirdsofPrey.class)) {
            birdsOfPrey_temp = new BirdsofPreyAviary(this.bird);
            birdAviaryAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(birdsOfPrey_temp.GetAviaryAssignment());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(birdsOfPrey_temp.GetLocation());
            Count_birdsOfPrey ++;

        }
        else if (bird.getClass().equals(flightlessBirds.class)) {
            flightlessAviary_temp = new FlightlessAviary(this.bird);
            birdAviaryAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(flightlessAviary_temp.GetAviaryAssignment());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(flightlessAviary_temp.GetLocation());
            Count_flightlessBirds ++;
        }
        else {
            OtherAviary_temp = new OtherAviary(this.bird);
            birdAviaryAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(OtherAviary_temp.GetAviaryAssignment());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(OtherAviary_temp.GetLocation());
            Count_otherBirds ++;
        }
        return birdAviaryAssignment_map;
    }
    public String SearchAviaryAssignment() {
        return this.bird.GetName() + birdAviaryAssignment_map.get(this.bird.GetName());
    }
    public static Dictionary GetMap() {
        //return FlightlessAviary.GetAviaryMap() + "\n" + BirdsofPreyAviary.GetAviaryMap()  + "\n" + OtherAviary.GetAviaryMap();
        return BirdsofPreyAviary.GetAviaryLocation();
    }
    public static Map<String, ArrayList<String>> GetBirdIndex() {
        TreeMap<String, ArrayList<String>> sorted_birdAssignment_map = new TreeMap<>();
        sorted_birdAssignment_map.putAll(birdAviaryAssignment_map);
        return sorted_birdAssignment_map;
    }
    public static int GetTotalNumAviary() {
        return OtherAviary.GetNumAviary() + FlightlessAviary.GetNumAviary() + BirdsofPreyAviary.GetNumAviary();
    }
    public void SetLocation(String locationHolder) {
        location = locationHolder;
    }
    public String GetLocation() {
        return location;
    }

    public static String CalculateFood() {
        return "small mammals, fish: " + Count_birdsOfPrey +
                "\nvegetation, larvae: " + Count_flightlessBirds;}


}