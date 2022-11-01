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
        Gear beautiful_hat = new HeadGear(new String[]{"Beautiful", "Hat"}, 10);
        Gear tricky_glove1 = new HandGear(new String[]{"Tricky", "Glove"}, 10, 10);
        Gear magical_hand = new HandGear(new String[]{"Magical", "Hand"}, 10, 10);
        Gear sharp_knife = new HandGear(new String[]{"Sharp", "Knife"}, 10, 20);
        Gear scurrying_sandals1 = new FootWear(new String[]{"Scurrying", "Sandals"}, 10, 10);
        Gear shiny_shoe = new FootWear(new String[]{"Shiny", "Shoe"}, 10, 10);
        Gear scurrying_highheel = new FootWear(new String[]{"Scurrying", "Highheel"}, 10, 10);

        //Test creating character
        Character character1 = new Character ("character1", 10, 10);

        //Test equipping head gear
        character1.EquipGear(metalic_helmet1);
        assertEquals("Character: character1\n" +  "Attach Power: 10\n" + "Defense Power: 20\n" +  "Head Gear: Metalic Helmet, Defense: 10 Attack: 0\n" +
                "Hand Gear: Empty HandWear\n" + "Foot Wear: Empty FootWear\n", character1.toString());

        //Test equipping 2 head gear
        assertThrows(IllegalArgumentException.class, () -> {
            character1.EquipGear(beautiful_hat);
        });

        //Test equipping 2 hand gear
        character1.EquipGear(tricky_glove1);
        character1.EquipGear(magical_hand);
        assertEquals("Character: character1\n" + "Attach Power: 30\n" + "Defense Power: 40\n" + "Head Gear: Metalic Helmet, Defense: 10 Attack: 0\n" +
                "Hand Gear: Tricky Hand, Defense: 20 Attack: 20\n" + "Foot Wear: Empty FootWear\n", character1.toString());

        //Test equipping 3 hand gear
        assertThrows(IllegalArgumentException.class, () -> {
            character1.EquipGear(sharp_knife);
        });

        //Test equipping 2 footwear
        character1.EquipGear(scurrying_sandals1);
        character1.EquipGear(shiny_shoe);
        assertEquals("Character: character1\n" + "Attach Power: 50\n" + "Defense Power: 60\n" + "Head Gear: Metalic Helmet, Defense: 10 Attack: 0\n" +
                "Hand Gear: Tricky Hand, Defense: 20 Attack: 20\n" + "Foot Wear: Scurrying Shoe, Defense: 20 Attack: 20\n", character1.toString());

        //Test equipping 3 footwear
        assertThrows(IllegalArgumentException.class, () -> {
            character1.EquipGear(scurrying_highheel);
        });

        //Test invariant variables
        assertThrows(IllegalArgumentException.class, () -> {
            Character character2 = new Character("character2", -1, 20);
        });

        //Test equipping 1 handgear and 1 footwear
        Character character2 = new Character("character2", 10, 20);
        character2.EquipGear(magical_hand);
        character2.EquipGear(shiny_shoe);
        assertEquals("Character: character2\n" + "Attach Power: 30\n" + "Defense Power: 40\n" + "Head Gear: Empty HeadGear\n" +
                "Hand Gear: Magical Hand, Defense: 10 Attack: 10\n" + "Foot Wear: Shiny Shoe, Defense: 10 Attack: 10\n", character2.toString());
    }
}
