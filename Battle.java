import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Battle {
    Character character1;
    Character character2;
    Character previousCharacter;
    private List<Gear> gear_list;
    private int i = 0;

    public Battle(Character character1, Character character2, List<Gear> gear_list) {
        if (character1 == character2) {
            throw new IllegalArgumentException("Characters cannot be the same");
        }
        this.character1 = character1;
        this.character2 = character2;
        this.gear_list = gear_list;

        Collections.sort(this.gear_list, Collections.reverseOrder());
    }

    public void GetEquipment(Character character) {
        i = 0;

        if (previousCharacter == character) {
            throw new IllegalArgumentException("Individual character takes turn to equip");
        }

        while (i < gear_list.size() ) {

            try {
                character.EquipGear(this.gear_list.get(i));

                System.out.println(character);

                this.gear_list.remove(this.gear_list.get(i));

                previousCharacter = character;

                return;
            } catch (Exception e) {
                i++;
            }
        }
        return;
    }
    public String toString() {
        int character1_damage = this.character2.GetAttackPower() - this.character1.GetDefenseStrength();
        int character2_damage = this.character1.GetAttackPower() - this.character2.GetDefenseStrength();

        System.out.println("Character1 damage: " + this.character2.GetAttackPower() + " - " + this.character1.GetDefenseStrength() +
                " = " + character1_damage);
        System.out.println("Character2 damage: " + this.character1.GetAttackPower() + " - " + this.character2.GetDefenseStrength() +
                " = " + character2_damage);

        if ( character1_damage < character2_damage) {
            System.out.println("Character 1 won");
        }
        else if (character1_damage == character2_damage) {
            System.out.println("A tie");
        }
        else {
            System.out.println("Character 2 won");
        }
        return "null";
    }
}
