import java.util.ArrayList;

public abstract class AbstractGear implements Gear {

    protected String[] name;
    protected int defenseStrength;

    protected int attackPower;

    @Override
    public String GetGearName() {
        return this.name[0] + " " + this.name[1];
    }
    @Override
    public int GetDefense() {
        return this.defenseStrength;
    }
    public int GetAttack() {
        return this.attackPower;
    }
}
