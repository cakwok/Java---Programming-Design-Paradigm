/*
CS5010 Homework 1 - Birds
Wing Man, Kwok
 */
/*
Child class BirdsofPreyAviary to assign birds of prey into aviary, put max number of birds per aviary into 5
Provide description of the aviary
 */
import java.util.*;

public class BirdsofPreyAviary extends Conservatory{
    private static int occupancy = 0;
    private static int aviaryNum = 0;
    private static List<String> aviaryDesc = new ArrayList<String>();

    // Constructor
    // Exception throw when bird getclass() is not BirdsofPrey
    // @params occupancy            to calculate current state of number of birds in the aviary
    // @params aviaryNum            keep track of number of aviary.  create a new aviary when occupany > 5
    // @params aviaryDesc           description of the birds this aviary houses and information that it may have about that animal.
    public BirdsofPreyAviary(Birds bird, String bird_name){

        super(bird, bird_name);

        if (!bird.getClass().equals(BirdsofPrey.class)){
            throw new IllegalArgumentException("Birds of prey aviary cannot mix with other birds.");
        }

        occupancy ++;

        if (occupancy % 5 == 1) {
            aviaryNum ++;
        }

        SetLocation(String.valueOf(aviaryNum) + " Floor");
        Set_map_aviary_bird("BirdofPreyAviary" + aviaryNum);

        if (occupancy == 1 || aviaryDesc.contains(bird.GetCharacteristics()) == false) {
            aviaryDesc.add(bird.GetCharacteristics());
        }
    }

    //return to parent for which aviary a bird is assigned
    public String GetAviaryAssignment() {
        return "BirdsofPreyAviary" + aviaryNum;
    }

    //return to parent for description of the aviary
    public static List<String> GetDesc() {
        return aviaryDesc;
    }
    //return to parent the number of aviary
    public static int GetNumAviary() {
        return aviaryNum;
    }

}
