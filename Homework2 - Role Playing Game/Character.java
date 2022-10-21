import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Character {
    private final int baseAttackPower;
    private final int baseDefenseStrength;
    private  int attackPower;
    private  int defenseStrength;
    private Gear headGear;
    private List<Gear> handGear;
    private List<Gear> footWear;
    private String handGear_combined;
    private String footWear_combined;

    public Character(int baseAttackPower, int baseDefenseStrength) {
        if (baseAttackPower < 0 || baseDefenseStrength < 0) {
            throw new IllegalArgumentException("Value must be bigger than or equal to 0");
        }

        Gear emptyHeadGear = new HeadGear(new String[]{"Empty", "HeadGear"}, 0);
        Gear emptyHandWear = new HandGear(new String[]{"Empty", "HandWear"}, 0, 0);
        Gear emptyFootWear = new FootWear(new String[]{"Empty", "FootWear"}, 0, 0);

        this.baseAttackPower = baseAttackPower;
        this.baseDefenseStrength = baseDefenseStrength;
        this.attackPower = baseAttackPower;
        this.defenseStrength = baseDefenseStrength;
        this.headGear = emptyHeadGear;
        this.handGear = new ArrayList<>();
        this.handGear.add(emptyHandWear);
        this.handGear.add(emptyHandWear);
        this.footWear = new ArrayList<>();
        this.footWear.add(emptyFootWear);
        this.footWear.add(emptyFootWear);
        this.handGear_combined = "Empty HandWear";
        this.footWear_combined = "Empty HandWear";
    }

    public void EquipGear(Gear gear) {

        if (gear.getClass().equals(HeadGear.class)){
            this.headGear = gear;
        }
        else if (gear.getClass().equals(HandGear.class)) {
            if (this.handGear.get(0).GetGearName().equals("Empty HandWear")) {
                this.handGear.set(0, gear);
                this.handGear_combined = this.handGear.get(0).GetGearName();
            }
            else if(this.handGear.get(1).GetGearName().equals("Empty HandWear")) {
                this.handGear.set(1, gear);
                this.handGear_combined = this.handGear.get(0).GetGearName().split(" ")[0] + " "  +
                        this.handGear.get(1).GetGearName().split(" ")[1];
            }
            else {
                throw new IllegalArgumentException("Hand Gear full");
            }
        }
        else if (gear.getClass().equals(FootWear.class)) {
            if (this.footWear.get(0).GetGearName().equals("Empty FootWear")) {
                this.footWear.set(0, gear);
                this.footWear_combined = this.footWear.get(0).GetGearName();
            }
            else if(this.handGear.get(1).GetGearName().equals("Empty FootWear")) {
                this.footWear.set(1, gear);
                this.footWear_combined = this.footWear.get(0).GetGearName().split(" ")[0] + " "  +
                        this.footWear.get(1).GetGearName().split(" ")[1];
            }
            else {
                throw new IllegalArgumentException("Hand Gear full");
            }
       }

        this.defenseStrength +=  + gear.GetDefense();
        this.attackPower += gear.GetAttack();
    }

    @Override
    public String toString() {

        String status = "Attach Power: " + this.attackPower + "\n" +
                "Defense Power: " + this.defenseStrength + "\n" +
                "Head Gear: " + this.headGear.GetGearName() + "\n" +
                "Hand Gear: " + this.handGear_combined + "\n" +
                "Foot Wear: " + this.footWear_combined + "\n";

        return  status;
    }
}
