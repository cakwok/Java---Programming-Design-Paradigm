/*
CS5010 Homework2 - Role Playing Games
Wing Man, Kwok
Oct 25 2022
 */
import java.util.List;

//Interface for creating head gear, hand gear, foot wear
public interface Gear extends Comparable<Gear>{

    //Get gear name
    String GetGearName();

    //Get defense strength of a gear
    int GetDefense();

    //Get attack power of a gear
    int GetAttack();

    //Get single gear information or combine 2 gears
    String GetGear(String gear);
    String GetGear(List<Gear> gear_list, Gear gear);
}