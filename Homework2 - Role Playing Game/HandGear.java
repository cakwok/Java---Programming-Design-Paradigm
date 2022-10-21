
public class HandGear extends AbstractGear {
    public HandGear(String[] name,  int defenseStrength, int attackPower) {
        if (defenseStrength < 0 || attackPower < 0 ) {
            throw new IllegalArgumentException("Defense or attack strength must be larger than 0");
        }
        this.name = name;
        this.defenseStrength = defenseStrength;
        this.attackPower = attackPower;
    }
}
