import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGear implements Gear {

    protected String[] name;
    protected int defenseStrength;

    protected int attackPower;
    private List<Gear> gear_list;
    protected String gearCombined;

    @Override
    public String GetGearName() {
        return this.name[0] + " " + this.name[1];
    }
    @Override
    public int GetDefense() {
        return this.defenseStrength;
    }
    public int GetAttack() {
        return this.attackPower;
    }

    public abstract String GetGear(String gear);

    public abstract String GetGear(List<Gear> gear_list, Gear gear);

    /*
    public abstract int compareTo(HeadGear headgear);
    public abstract int compareTo(HandGear handgear);
    public abstract int compareTo(FootWear footwear);

     */
}
