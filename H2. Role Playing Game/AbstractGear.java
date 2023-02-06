/*
CS5010 Homework2 - Role Playing Games
Wing Man, Kwok
Oct 25 2022
 */
import java.util.List;

//Abstract class to implement Gear
public abstract class AbstractGear implements Gear {

    /*
    @params name                String array to hold gear noun and adjective
    @params defenseStrength     Defense strength value of a gear
    @params attackPower         Attack power value of a gear
    @params gearCombined        Combined 2 gear name
     */
    protected String[] name;
    protected int defenseStrength;
    protected int attackPower;
    protected String gearCombined;

    //Get gear name
    @Override
    public String GetGearName() {
        return this.name[0] + " " + this.name[1];
    }

    //Get defense strength of a gear
    @Override
    public int GetDefense() {
        return this.defenseStrength;
    }

    //Get attack power of a gear
    public int GetAttack() {
        return this.attackPower;
    }

    //Get single gear information or combine 2 gears
    public abstract String GetGear(String gear);
    public abstract String GetGear(List<Gear> gear_list, Gear gear);
}
