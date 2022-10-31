/*
CS5010 Homework2 - Role Playing Games
Wing Man, Kwok
Oct 25 2022
 */
//Test case for creating character
import static org.junit.Assert.*;
public class TestCharacter {
    @org.junit.Test
    public void TestCreatingCharacter() {
        Gear metalic_helmet1 = new HeadGear(new String[]{"Metalic", "Helmet"}, 10);
        Gear tricky_glove1 = new HandGear(new String[]{"Tricky", "Glove"}, 10, 10);
        Gear magical_hand = new HandGear(new String[]{"Magical", "Hand"}, 10, 10);
        Gear scurrying_sandals1 = new FootWear(new String[]{"Scurrying", "Sandals"}, 10, 10);
        Gear shiny_shoe = new FootWear(new String[]{"Shiny", "Shoe"}, 10, 10);
        Gear scurrying_highheel = new FootWear(new String[]{"Scurrying", "Highheel"}, 10, 10);

        //Test creating character
        Character character1 = new Character ("character1", 10, 10);

        //Test equipping head wear
        character1.EquipGear(metalic_helmet1);
        System.out.println(character1);

        //Test equipping 2 hand wears
        character1.EquipGear(tricky_glove1);
        character1.EquipGear(magical_hand);
        System.out.println(character1);

        //Test equipping 2 footwear
        character1.EquipGear(scurrying_sandals1);
        character1.EquipGear(shiny_shoe);
        System.out.println(character1);

        //Test invariant variables
        assertThrows(IllegalArgumentException.class, () -> {
            Character character2 = new Character("character2", -1, 20);
            System.out.println(character2 + "\n");
        });
    }

}
