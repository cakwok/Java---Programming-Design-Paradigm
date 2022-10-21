
public class FootWear extends AbstractGear {
    public FootWear(String[] name,  int defenseStrength, int attackPower) {
        if (attackPower < 0 || defenseStrength < 0 ) {
            throw new IllegalArgumentException("Defense or attack strength must be larger than 0");
        }
        this.name = name;
        this.defenseStrength = defenseStrength;
        this.attackPower = attackPower;
    }
}
