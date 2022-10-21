import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Character {
    private int attackPower;
    private int defenseStrength;
    private Gear headGear;
    private List<Gear> handGear;
    private List<Gear> footWear;

    public Character(int attackPower, int defenseStrength) {

        Gear emptyHeadGear = new HeadGear(new String[]{"Empty", "HeadGear"}, 0);
        Gear emptyHandWear = new HandGear(new String[]{"Empty", "HandWear"}, 0, 0);
        Gear emptyFootWear = new FootWear(new String[]{"Empty", "FootWear"}, 0, 0);

        this.attackPower = attackPower;
        this.defenseStrength = defenseStrength;
        this.headGear = emptyHeadGear;
        this.handGear = new ArrayList<>();
        this.handGear.add(emptyHandWear);
        this.handGear.add(emptyHandWear);
        this.footWear = new ArrayList<>();
        this.footWear.add(emptyFootWear);
        this.footWear.add(emptyFootWear);
    }

    public void EquipGear(Gear gear) {

        if (gear.getClass().equals(HeadGear.class)){
            this.headGear = gear;
        }
        if (gear.getClass().equals(HandGear.class)) {
            if (this.handGear.get(0).GetGearName().equals("Empty HandWear")) {
                this.handGear.set(0, gear);
            }
            else if(this.handGear.get(1).GetGearName().equals("Empty HandWear")) {
                this.handGear.set(1, gear);
            }
            else {
                throw new IllegalArgumentException("Hand Gear full");
            }
        }
        if (gear.getClass().equals(FootWear.class)) {
           this.footWear.add(gear);
       }

        this.defenseStrength += gear.GetDefense();
        this.attackPower += gear.GetAttack();
    }

    @Override
    public String toString() {
        String status = "Attach Power: " + this.attackPower + "\n" +
                "Defense Power: " + this.defenseStrength + "\n" +
                "Head Gear: " + this.headGear.GetGearName() + "\n" +
                "Hand Gear: " + this.handGear.get(0).GetGearName() + "\n" +
                "Hand Gear: " + this.handGear.get(1).GetGearName() + "\n" +
                "Foot Wear: " + this.footWear.get(0).GetGearName() + "\n" +
                "Foot Wear: " + this.footWear.get(1).GetGearName() + "\n";
        return  status;
    }
}
