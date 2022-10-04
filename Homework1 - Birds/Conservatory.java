import java.util.*;

public class Conservatory {
    private Birds bird;
    private static Map<String, ArrayList<String>> birdAviaryAssignment_map = new HashMap<String, ArrayList<String>>();

    private OtherAviary OtherAviary_temp;
    private FlightlessAviary flightlessAviary_temp;
    private BirdsofPreyAviary birdsOfPrey_temp;

    private String location;
    private static int Count_birdsOfPrey, Count_flightlessBirds, Count_otherBirds;
    private static Map<String, ArrayList<String>> map_aviary_bird = new HashMap<String, ArrayList<String>> ();
    private static Map<String, String> map_aviary_location = new HashMap<String, String>();

    public Conservatory(Birds bird) throws IllegalArgumentException {
        if ((GetTotalNumAviary() > 20)) {
            throw new IllegalArgumentException("More than 20 aviaries");
        }
        /*
        if (bird.extinct()) {
            throw new IllegalArgumentException(bird.getClass() + " is extinct and cannot put int avaries.");
        }
        */

        this.bird = bird;
    }
    public Map<String, ArrayList<String>> AssignAviary() {
        try {
            birdsOfPrey_temp = new BirdsofPreyAviary(this.bird);
            birdAviaryAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(birdsOfPrey_temp.GetAviaryAssignment());
            birdAviaryAssignment_map.get(this.bird.GetName()).add(birdsOfPrey_temp.GetLocation());
            Count_birdsOfPrey++;
        } catch (Exception f) {
            try {
                flightlessAviary_temp = new FlightlessAviary(this.bird);
                birdAviaryAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
                birdAviaryAssignment_map.get(this.bird.GetName()).add(flightlessAviary_temp.GetAviaryAssignment());
                birdAviaryAssignment_map.get(this.bird.GetName()).add(flightlessAviary_temp.GetLocation());
                Count_flightlessBirds++;
            } catch (Exception g) {
                try {
                    OtherAviary_temp = new OtherAviary(this.bird);
                    birdAviaryAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
                    birdAviaryAssignment_map.get(this.bird.GetName()).add(OtherAviary_temp.GetAviaryAssignment());
                    birdAviaryAssignment_map.get(this.bird.GetName()).add(OtherAviary_temp.GetLocation());
                    Count_otherBirds++;
                } catch (Exception h) {
                    System.out.println(this.bird + " cannot be assigned");
                }
            }
        }
        return birdAviaryAssignment_map;
    }
    public String SearchAviaryAssignment() {
        return this.bird.GetName() + birdAviaryAssignment_map.get(this.bird.GetName());
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
                "\nvegetation, larvae: " + Count_flightlessBirds +
                "\nsmall mammals, buds " + "nuts, vegetation, buds " + "fish, larvae " + Count_otherBirds;
    }

    public void Set_map_aviary_bird(String tempHolder) {
        if (map_aviary_bird.get(tempHolder) == null) {
            map_aviary_bird.put(tempHolder, new ArrayList<String>());
        }

        map_aviary_bird.get(tempHolder).add(bird.GetName());

        map_aviary_location.put(tempHolder, location);

        //System.out.println(map_aviary_bird);
        //System.out.println(map_aviary_location);
    }

    public static void GetMap() {
        System.out.println(map_aviary_bird);
        System.out.println(map_aviary_location);
    }


}