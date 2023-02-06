/*
CS5010 Homework 1 - Birds
Wing Man, Kwok
 */
/*
Conservatory parent class to assign birds into child classes of birds of prey aviary, flightless aviary, waterfowl aviary and other aviary.
Also as a central respository to show reports of all aviaries.
 */
import java.util.*;

public class Conservatory {
    private Birds bird;
    private OtherAviary otherAviary;
    private FlightlessAviary flightlessAviary;
    private BirdsofPreyAviary birdsOfPrey;
    private WaterFowlAviary waterFowlAviary;
    private String location;
    String bird_name;
    private static int Count_birdsOfPrey, Count_flightlessBirds, Count_otherBirds, Count_waterFowl;
    private static Map<String, ArrayList<String>> birdAviaryAssignment_map = new HashMap<String, ArrayList<String>>();  // {birdname: aviary, location}
    private static Map<String, ArrayList<String>> map_aviary_bird = new HashMap<String, ArrayList<String>> ();          // {aviary: birds}
    private static Map<String, String> map_aviary_location = new HashMap<String, String>();                             // {aviary: location}
    private static Map<String, ArrayList<String>> map_aviary_location_bird = new HashMap<String, ArrayList<String>>();  // {aviary: location, birds}

    /*
    Constructor
    Throw exception when total aviaries > 20, and  birds extincts
    @param this.bird        bird object
    @param this.bird_name   String object to hold bird name for searching
     */
    public Conservatory(Birds bird, String bird_name) throws IllegalArgumentException {
        if ((GetTotalNumAviary() > 20)) {
            throw new IllegalArgumentException("Attempted to create " + GetTotalNumAviary() + " aviaries.  More than 20 aviaries is not allowed");
        }
        if (bird.extinct()) {
            throw new IllegalArgumentException(bird_name + " is extinct and cannot put int aviaries.");
        }
        this.bird = bird;
        this.bird_name = bird_name;
        this.location = location;
    }

    /*
    Assign birds into aviaries automatically by detecting child classes exceptions.
    @param birdsOfPrey_temp, flightlessAviary_temp, waterFowlAviary_temp, OtherAviary_temp  temp variables to create child class aviaries
    @param birdAviaryAssignment_map                                                         Map to store bird name, aviary assigned, location.
    @param Count_birdsOfPrey, Count_flightlessBirds, Count_otherBirds, Count_otherBirds     Count number of birds in corresponding aviaries
     */
    public Map<String, ArrayList<String>> AssignAviary() {
        try {
            birdsOfPrey = new BirdsofPreyAviary(this.bird, this.bird_name);
            birdAviaryAssignment_map.put(this.bird_name, new ArrayList<String>());
            birdAviaryAssignment_map.get(this.bird_name).add(birdsOfPrey.GetAviaryAssignment());
            birdAviaryAssignment_map.get(this.bird_name).add(birdsOfPrey.GetLocation());
            Count_birdsOfPrey++;
        } catch (Exception f) {
            System.out.println(f);
            try {
                flightlessAviary = new FlightlessAviary(this.bird, this.bird_name);
                birdAviaryAssignment_map.put(this.bird_name, new ArrayList<String>());
                birdAviaryAssignment_map.get(this.bird_name).add(flightlessAviary.GetAviaryAssignment());
                birdAviaryAssignment_map.get(this.bird_name).add(flightlessAviary.GetLocation());
                Count_flightlessBirds++;
            } catch (Exception g) {
                System.out.println(g);
                try {
                    waterFowlAviary = new WaterFowlAviary(this.bird, this.bird_name);
                    birdAviaryAssignment_map.put(this.bird_name, new ArrayList<String>());
                    birdAviaryAssignment_map.get(this.bird_name).add(waterFowlAviary.GetAviaryAssignment());
                    birdAviaryAssignment_map.get(this.bird_name).add(waterFowlAviary.GetLocation());
                    Count_waterFowl++;
                } catch (Exception h) {
                    System.out.println(h);
                    try {
                        otherAviary = new OtherAviary(this.bird, this.bird_name);
                        birdAviaryAssignment_map.put(this.bird_name, new ArrayList<String>());
                        birdAviaryAssignment_map.get(this.bird_name).add(otherAviary.GetAviaryAssignment());
                        birdAviaryAssignment_map.get(this.bird_name).add(otherAviary.GetLocation());
                        Count_otherBirds++;
                    } catch (Exception i) {
                        System.out.println(i);
                        System.out.println(this.bird + " cannot be assigned");
                    }
                }
            }
        }
        return birdAviaryAssignment_map;            //return bird aviary assignment
    }

    //Guest look up which aviary a bird is in
    public ArrayList<String> SearchAviaryAssignment() {
        return birdAviaryAssignment_map.get(this.bird_name);
    }

    //Print an index that lists all birds in the conservatory in alphabetical order and their location
    public static Map<String, ArrayList<String>> GetBirdIndex() {

        TreeMap<String, ArrayList<String>> sorted_birdAssignment_map = new TreeMap<>();
        sorted_birdAssignment_map.putAll(birdAviaryAssignment_map);

        return sorted_birdAssignment_map;
    }

    //Print total number of aviaries to track if <20
    public static int GetTotalNumAviary() {
        return OtherAviary.GetNumAviary() + FlightlessAviary.GetNumAviary() + BirdsofPreyAviary.GetNumAviary() + WaterFowlAviary.GetNumAviary();
    }

    //Setter for location of aviary
    public void SetLocation(String location) {
        this.location = location;
    }

    //Getter for location of aviary
    public String GetLocation() {
        return this.location;
    }

    //Calculate what food needs to be kept and in what quantities
    public static String CalculateFood() {
        return "small mammals, fish: " + Count_birdsOfPrey +
                "\nvegetation, larvae: " + Count_flightlessBirds +
                "\nsmall mammals, buds, " + "nuts, vegetation, buds, " + "fish, larvae: " + Count_otherBirds +
                "\nfish, larvae: " + Count_waterFowl;
    }

    //Create a “map” that lists all the aviaries by location and the birds they house
    //@params map_aviary_bird       dictionary to hold aviary:bird
    //@params map_aviary_location   dictionary to hold aviary:location
    public void Set_map_aviary_bird(String aviary) {

        if (map_aviary_bird.get(aviary) == null) {
            map_aviary_bird.put(aviary, new ArrayList<String>());
        }

        map_aviary_bird.get(aviary).add(bird.GetName());
        map_aviary_location.put(aviary, this.location);
    }

    //Print a “map” that lists all the aviaries by location and the birds they house
    //@params map_aviary_location_bird      dictionary to hold aviary:location:birds
    public static Map<String, ArrayList<String>> GetMap() {

        for (String aviary : map_aviary_location.keySet()) {
            map_aviary_location_bird.put(aviary, new ArrayList<String>());
            map_aviary_location_bird.get(aviary).add(map_aviary_location.get(aviary).toString());
            map_aviary_location_bird.get(aviary).add(map_aviary_bird.get(aviary).toString());
        }

        return map_aviary_location_bird;
    }
}