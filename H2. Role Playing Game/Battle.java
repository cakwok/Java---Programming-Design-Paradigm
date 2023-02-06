/*
CS5010 Homework2 - Role Playing Games
Wing Man, Kwok
Oct 25 2022
 */
import java.util.Collections;
import java.util.List;


//Battle class to create a battle and return winner
public class Battle {

    /*
    @params character1          create character1 object
    @params character2          create character2 object
    @params previousCharacter   hold value of previous character to ensure character take turn to equip
    @params gear_list           hold a gear list of 10 items to let character equip
    @params i                   pointer of equipment list item position
    @params numGear             number of gears desired for gear list
     */
    Character character1;
    Character character2;
    Character previousCharacter;
    private List<Gear> gear_list;
    private int i;
    private final int numGear = 10;
    //constructor
    public Battle(Character character1, Character character2, List<Gear> gear_list) {
        if (character1 == character2) {
            throw new IllegalArgumentException("Characters cannot be the same");
        }
        if (gear_list.size() != numGear) {
            throw new IllegalArgumentException("Enter 10 items to choose from");
        }
        this.character1 = character1;
        this.character2 = character2;
        this.gear_list = gear_list;

        Collections.sort(this.gear_list, Collections.reverseOrder());
    }

    //start battle, let character take turn to equip, print result of the battle
    public void Play() {
        for (int i = 0; i < numGear/2; i++) {
            GetEquipment(character1);
            GetEquipment(character2);
        }
        this.toString();
    }

    //sub function of Play(), let character take turn to equip,
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

    //sub function of Play(), return result of battle
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
        return "";
    }
}
