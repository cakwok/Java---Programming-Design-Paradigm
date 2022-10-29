import java.util.List;

public class HeadGear extends AbstractGear {
    public HeadGear(String[] name,  int defense_strength) {
        if (name[0].matches("-?[0-9]+") || name[1].matches("-?[0-9]+") || attackPower < 0 || defenseStrength < 0 ) {
            throw new IllegalArgumentException("Weapon name must not be numeric.  Defense or attack strength must be larger than 0");
        }
        this.name = name;
        this.defenseStrength = defense_strength;
        this.attackPower = 0;
    }
    @Override
    public String GetGear(String gear) {
        System.out.println(gear);
        if (!gear.equals("Empty HeadGear")) {
            throw new IllegalArgumentException("Head Gear full");
        }
        this.gearCombined = this.name[0] + " " + this.name[1];
        return this.gearCombined;
    }
    @Override
    public String GetGear(List<Gear> gear_list, Gear gear) {return "null";}

    @Override
    public int compareTo(Gear gear) {
        if (this.attackPower == gear.GetAttack()) {
            return Integer.compare(this.defenseStrength, gear.GetDefense());
        }
        return Integer.compare(this.attackPower, gear.GetAttack());
    }
}
