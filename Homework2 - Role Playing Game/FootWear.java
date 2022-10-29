import java.util.List;

public class FootWear extends AbstractGear {
    public FootWear(String[] name,  int defenseStrength, int attackPower) {
        if (name[0].matches("-?[0-9]+") || name[1].matches("-?[0-9]+") || attackPower < 0 || defenseStrength < 0 ) {
            throw new IllegalArgumentException("Weapon name must not be numeric.  Defense or attack strength must be larger than 0");
        }
        this.name = name;
        this.defenseStrength = defenseStrength;
        this.attackPower = attackPower;
        this.gearCombined = "Empty FootWear";
    }

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
        return this.gearCombined;
    }
    @Override
    public String GetGear(String gear) {return "null";};

    @Override
    public int compareTo(Gear gear) {
        if (this.attackPower == gear.GetAttack()) {
            return Integer.compare(this.defenseStrength, gear.GetDefense());
        }
        return Integer.compare(this.attackPower, gear.GetAttack());
    }
}
