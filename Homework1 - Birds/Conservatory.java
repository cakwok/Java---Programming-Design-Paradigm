import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Conservatory {
    Birds bird;
    private int index = 0;
    Map<Birds, OtherAviary> map = new HashMap<>();
    Map<String, ArrayList<String>> birdAssignment_map = new HashMap<String, ArrayList<String>>();
    OtherAviary birdIndex[] = new OtherAviary[100];
    public Conservatory(Birds bird) throws IllegalArgumentException {
        this.bird = bird;
    }

    public Map<String, ArrayList<String>> AssignAviary(){
        if (bird.getClass().equals(BirdsofPrey.class)) {
            birdIndex[index] = new OtherAviary(this.bird);
            map.put(this.bird, birdIndex[index]);
            birdAssignment_map.put(this.bird.GetName(), new ArrayList<String>());
            birdAssignment_map.get(this.bird.GetName()).add(birdIndex[index].GetAviaryAssignment());
            birdAssignment_map.get(this.bird.GetName()).add(birdIndex[index].GetLocation());
            return birdAssignment_map;
        }
        return birdAssignment_map;
    }

    public String GetAviaryNum() {
        return this.bird.GetName() + birdAssignment_map.get(this.bird.GetName());
    }


}