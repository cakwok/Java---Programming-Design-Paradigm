
public class HeadGear extends AbstractGear {
    public HeadGear(String[] name,  int defense_strength) {
        this.name = name;
        this.defenseStrength = defense_strength;
        this.attackPower = 0;

        if (this.defenseStrength <0) {
            throw new IllegalArgumentException("Defense must be larger than 0");
        }
    }
}
