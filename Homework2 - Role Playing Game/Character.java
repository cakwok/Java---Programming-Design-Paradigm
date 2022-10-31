/*
CS5010 Homework2 - Role Playing Games
Wing Man, Kwok
Oct 25 2022
 */
import java.util.ArrayList;
import java.util.List;

//Character class to define character base attack power, base defense strength, holder of gear inventory a character hold
public class Character {

    /*
    @params baseAttackPower         character base attack power
    @params baseDefenseStrength     character base defense strength
    @params attackPower             total attack power upon equipped gear
    @params defenseStrength         total defense strength upon equipped gear
    @params headGear                hold current head gear inventory
    @params handGear                hold current hand gear inventory
    @params footWear                hold current foot wear inventory
    @params headGear_combined       hold combined head gear inventory
    @params handGear_combined       hold combined hand gear inventory
    @params footWear_combined       hold combined foot wear inventory
    @params characterName           hold character name
     */
    private final int baseAttackPower;
    private final int baseDefenseStrength;
    private  int attackPower;
    private  int defenseStrength;
    private Gear headGear;
    private List<Gear> handGear;
    private List<Gear> footWear;
    private String headGear_combined;
    private String handGear_combined;
    private String footWear_combined;
    private String characterName;

    //constructor
    public Character(String characterName, int baseAttackPower, int baseDefenseStrength) {
        if (baseAttackPower < 0 || baseDefenseStrength < 0) {
            throw new IllegalArgumentException("Value must be bigger than or equal to 0");
        }

        Gear emptyHeadGear = new HeadGear(new String[]{"Empty", "HeadGear"}, 0);
        Gear emptyHandWear = new HandGear(new String[]{"Empty", "HandWear"}, 0, 0);
        Gear emptyFootWear = new FootWear(new String[]{"Empty", "FootWear"}, 0, 0);

        this.characterName = characterName;
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
        this.headGear_combined = "Empty HeadGear";
        this.handGear_combined = "Empty HandWear";
        this.footWear_combined = "Empty FootWear";
    }

    //to equip a gear and return total defense strength and attack power
    public void EquipGear(Gear gear) {

        try {
            if (gear.getClass().equals(HeadGear.class)){
                this.headGear_combined = gear.GetGear(this.headGear_combined);
                this.headGear = gear;
            }
            else if (gear.getClass().equals(HandGear.class)) {
                this.handGear_combined = gear.GetGear(this.handGear, gear);
            }
            else if (gear.getClass().equals(FootWear.class)) {
                this.footWear_combined = gear.GetGear(this.footWear, gear);
            }

            this.defenseStrength +=  gear.GetDefense();
            this.attackPower += gear.GetAttack();

        } catch (Exception f) {
            System.out.println(f);
            throw f;
        }
    }

    //to return character attack power
    public int GetAttackPower() {
        return this.attackPower;
    }

    //to return character defense strength
    public int GetDefenseStrength() {
        return this.defenseStrength;
    }

    //to return character equipped status
    @Override
    public String toString() {

        String status = "Character: " + this.characterName  + "\n" +
                "Attach Power: " + this.attackPower + "\n" +
                "Defense Power: " + this.defenseStrength + "\n" +
                "Head Gear: " + this.headGear_combined + "\n" +
                "Hand Gear: " + this.handGear_combined + "\n" +
                "Foot Wear: " + this.footWear_combined + "\n";

        return  status;
    }
}
