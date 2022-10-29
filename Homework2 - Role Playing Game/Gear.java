import java.util.List;

public interface Gear extends Comparable<Gear>{

    String GetGearName();
    int GetDefense();

    int GetAttack();
    String GetGear(String gear);
    String GetGear(List<Gear> gear_list, Gear gear);
}