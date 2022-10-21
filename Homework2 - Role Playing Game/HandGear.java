
public class HandGear extends AbstractGear {
    public HandGear(String[] name,  int defense_strength, int attack_strength) {
        this.name = name;
        this.defenseStrength = defense_strength;
        this.attackPower = attack_strength;

        if (defense_strength < 0 || attack_strength < 0 ) {
            throw new IllegalArgumentException("Defense or attack strength must be larger than 0");
        }
    }
}
