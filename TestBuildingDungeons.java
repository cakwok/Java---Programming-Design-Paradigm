/*
CS5010 Module 3 Lab - Building Dungeons
Wing Man, Kwok
Nov 24 2022

Testing class by building dungeons, testing exceptions, adding monster, treasure, room
 */
package dungeon;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBuildingDungeons {
    /** Test adding rooms. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 5)
    public void testAddingRoomsTarget() {
        MedievalLevelBuilder b = new MedievalLevelBuilder(1, 3, 0, 0);
        b.addRoom("Entrance");
        b.addRoom("Hallway");
        b.addRoom("Cave");
        Level l1 = b.build();
        String expected = "Level 1 contains 3 rooms:\n\n"
                + "Room 0 -- Entrance\nMonsters:\n\tNone\nTreasures:\n\tNone\n\n"
                + "Room 1 -- Hallway\nMonsters:\n\tNone\nTreasures:\n\tNone\n\n"
                + "Room 2 -- Cave\nMonsters:\n\tNone\nTreasures:\n\tNone\n";
        assertEquals("Error adding rooms", expected, l1.toString());
    }

    /** Testing adding too many treasures. */
    //@Test(expected = IllegalStateException.class)
    //@TestWeight(weight = 1)
    @Test
    public void testAddingTooManyTreasures() {
        MedievalLevelBuilder b = new MedievalLevelBuilder(1, 0, 0, 0);
        try {
            b.addRoom("Entrance");
        } catch (IllegalStateException ex) {
            // this is what we expect
            System.out.println(ex);
        }
        try {
            b.addPotion(1);
            fail("Expected error adding too many potions");
        } catch (IllegalStateException ex) {
            // this is what we expect
            System.out.println(ex);
        }
        try {
            b.addGold(1, 10);
            fail("Expected error adding too many gold");
        } catch (IllegalStateException ex) {
            System.out.println(ex);
        }
        try {
            b.addWeapon(1, "sword");
            fail("Expected error adding too many weapons");
        } catch (IllegalStateException ex) {
            System.out.println(ex);
        }
        try {
            b.addSpecial(1, "magic sword", 100);
            fail("Expected error adding too many special treasures");
        } catch (IllegalStateException ex) {
            System.out.println(ex);
        }
    }

    /** Test adding treasures. */
    @Test(timeout = 3000)
    //@TestWeight(weight = 5)
    public void testAddingTreasureTarget() {
        MedievalLevelBuilder b = new MedievalLevelBuilder(1, 1, 0, 4);
        b.addRoom("Dungeon");
        b.addPotion(0);
        b.addGold(0, 10);
        b.addWeapon(0, "sword");
        b.addSpecial(0, "magic sword", 100);
        Level l1 = b.build();
        String expected = "Level 1 contains 1 rooms:\n\n"
                + "Room 0 -- Dungeon\nMonsters:\n\tNone\nTreasures:\n"
                + "\ta healing potion (value = 1)\n"
                + "\tpieces of gold (value = 10)\n"
                + "\tsword (value = 10)\n"
                + "\tmagic sword (value = 100)\n";
        assertEquals("Error adding rooms", expected, l1.toString());
    }

    @Test(timeout = 3000)
    public void testAddingMonstersTarget() {
        MedievalLevelBuilder b = new MedievalLevelBuilder(1, 1, 5, 0);
        b.addRoom("Dungeon");
        b.addGoblins(0, 2);
        b.addOrc(0);
        b.addOgre(0);
        b.addHuman(0, "Joe", "a regular guy", 15);
        Level l1 = b.build();
        String expected = "Level 1 contains 1 rooms:\n\n" + "Room 0 -- Dungeon\nMonsters:\n"
          + "\tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, "
          + "and greedy creature whose primary purpose is to cause trouble to humankind\n"
          + "\tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, "
          + "and greedy creature whose primary purpose is to cause trouble to humankind\n"
          + "\torc (hitpoints = 20) is a brutish, aggressive, malevolent being serving evil\n"
          + "\togre (hitpoints = 50) is a large, hideous man-like being that likes "
          + "to eat humans for lunch\n"
          + "\tJoe (hitpoints = 15) is a a regular guy" + "\nTreasures:\n\tNone\n";
        assertEquals("Error adding rooms", expected, l1.toString());
    }

}
