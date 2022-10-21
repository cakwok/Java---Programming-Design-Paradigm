
public class FootWear extends AbstractGear {
    public FootWear(String[] name,  int defenseStrength, int attackPower) {
        this.name = name;
        this.defenseStrength = defenseStrength;
        this.attackPower = attackPower;

        if (defenseStrength < 0 || defenseStrength < 0 ) {
            throw new IllegalArgumentException("Defense or attack strength must be larger than 0");
        }
    }
}
