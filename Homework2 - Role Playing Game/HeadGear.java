/*
CS5010 Homework2 - Role Playing Games
Wing Man, Kwok
Oct 25 2022
 */
import java.util.List;

//HeadGear class to store head gear inventory, combine 2 gears into 1, and sort gear by attack then defense
public class HeadGear extends AbstractGear {

    /* Constructor
    @params name                    Gear name
    @params defenseStrength         Defense strength value
    @params attackPower             Attack power value
    */
    public HeadGear(String[] name,  int defense_strength) {
        if (name[0].matches("-?[0-9]+") || name[1].matches("-?[0-9]+") || attackPower < 0 || defenseStrength < 0 ) {
            throw new IllegalArgumentException("Weapon name must not be numeric.  Defense or attack strength must be larger than 0");
        }
        this.name = name;
        this.defenseStrength = defense_strength;
        this.attackPower = 0;
    }

    //Get single gear information or combine 2 gears
    @Override
    public String GetGear(String gear) {
        if (!gear.equals("Empty HeadGear")) {
            throw new IllegalArgumentException("Head Gear full");
        }
        this.gearCombined = this.name[0] + " " + this.name[1];
        return this.gearCombined + ", Defense: " + this.GetDefense() +
                " Attack: " + this.GetAttack();
    }
    @Override
    public String GetGear(List<Gear> gear_list, Gear gear) {return "";}

    //Sort gear by attack then defense
    @Override
    public int compareTo(Gear gear) {
        if (this.attackPower == gear.GetAttack()) {
            return Integer.compare(this.defenseStrength, gear.GetDefense());
        }
        return Integer.compare(this.attackPower, gear.GetAttack());
    }
}
