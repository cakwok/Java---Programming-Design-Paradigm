/*
CS5010 Homework2 - Role Playing Games
Wing Man, Kwok
Oct 25 2022
 */
import java.util.List;

//FootWear class to store foot wear inventory, combine 2 gears into 1, and sort gear by attack then defense
public class FootWear extends AbstractGear {

    /* Constructor
    @params name                    Gear name
    @params defenseStrength         Defense strength value
    @params attackPower             Attack power value
    @params gearCombined            Combined gear name
    */
    public FootWear(String[] name,  int defenseStrength, int attackPower) {
        if (name[0].matches("-?[0-9]+") || name[1].matches("-?[0-9]+") || attackPower < 0 || defenseStrength < 0 ) {
            throw new IllegalArgumentException("Weapon name must not be numeric.  Defense or attack strength must be larger than 0");
        }
        this.name = name;
        this.defenseStrength = defenseStrength;
        this.attackPower = attackPower;
        this.gearCombined = "Empty FootWear";
    }

    //Get single gear information or combine 2 gears
    @Override
    public String GetGear(List<Gear> gear_list, Gear gear) {
        if (gear_list.get(0).GetGearName().equals("Empty FootWear")) {
            gear_list.set(0, gear);
            this.gearCombined = gear_list.get(0).GetGearName();
        }
        else if(gear_list.get(1).GetGearName().equals("Empty FootWear")) {
            gear_list.set(1, gear);
            this.gearCombined = gear_list.get(0).GetGearName().split(" ")[0] + " "  +
                    gear_list.get(1).GetGearName().split(" ")[1];
        }
        else {
            throw new IllegalArgumentException("Foot Wear full");
        }
        return this.gearCombined + ", Defense: " + (gear_list.get(0).GetDefense() + gear_list.get(1).GetDefense()) +
                " Attack: " + (gear_list.get(0).GetAttack() + gear_list.get(1).GetAttack());
    }
    @Override
    public String GetGear(String gear) {return "";};

    //Sort gear by attack then defense
    @Override
    public int compareTo(Gear gear) {
        if (this.attackPower == gear.GetAttack()) {
            return Integer.compare(this.defenseStrength, gear.GetDefense());
        }
        return Integer.compare(this.attackPower, gear.GetAttack());
    }
}
