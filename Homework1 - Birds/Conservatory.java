import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Conservatory {
    private Birds bird;
    private int index = 0;

    private Map<Birds, OtherAviary> map = new HashMap<>();
    private static Map<String, ArrayList<String>> birdAssignment_map = new HashMap<String, ArrayList<String>>();
    private OtherAviary birdIndex[] = new OtherAviary[100];
    public Conservatory(Birds bird) throws IllegalArgumentException {
        this.bird = bird;
    }

    public Map<String, ArrayList<String>> AssignAviary(){
        if (bird.getClass().equals(BirdsofPrey.class)) {
            birdIndex[index] = new OtherAviary(this.bird);
            //map.put(this.bird, birdIndex[index]);
            birdAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
            birdAssignment_map.get(this.bird.GetName()).add(birdIndex[index].GetAviaryAssignment());
            birdAssignment_map.get(this.bird.GetName()).add(birdIndex[index].GetLocation());
        }
        return birdAssignment_map;
    }

    public String GetAviaryNum() {
        return this.bird.GetName() + birdAssignment_map.get(this.bird.GetName());
    }
    public static Map<String, ArrayList<String>> GetMap() {
        return OtherAviary.GetOtherAviaryMap();
    }
    public static Map<String, ArrayList<String>> GetBirdIndex() {
        TreeMap<String, ArrayList<String>> sorted_birdAssignment_map = new TreeMap<>();
        sorted_birdAssignment_map.putAll(birdAssignment_map);
        return sorted_birdAssignment_map;
    }
}