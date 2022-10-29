import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestGear {

    private Gear gear;
    private Character character;

    //Test creating objects for head gear, hand gear, footwear
    @org.junit.Test
    public void TestCreatingWeapons() {

        Gear metalic_helmet1 = new HeadGear(new String[]{"Scurrying", "Sandals"}, 10);
        assertEquals("Scurrying Sandals", metalic_helmet1 .GetGearName());
        assertEquals(10, metalic_helmet1.GetDefense());
        assertEquals(0, metalic_helmet1.GetAttack());

        Gear tricky_glove1 = new HandGear(new String[]{"Tricky", "Glove"}, 10, 10);
        assertEquals("Tricky Glove", tricky_glove1.GetGearName());
        assertEquals(10, tricky_glove1.GetDefense());
        assertEquals(10, tricky_glove1.GetAttack());

        Gear scurrying_sandals1 = new FootWear(new String[]{"Scurrying", "Sandals"}, 10, 10);
        assertEquals("Scurrying Sandals", scurrying_sandals1 .GetGearName());
        assertEquals(10, scurrying_sandals1 .GetDefense());
        assertEquals(10, scurrying_sandals1 .GetAttack());
    }

    //Test creating characters and equipping weapons
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

        //Test equipping 1 footwear
        character1.EquipGear(scurrying_sandals1);
        character1.EquipGear(shiny_shoe);
        System.out.println(character1);

        //Test invariant variables
        assertThrows(IllegalArgumentException.class, () -> {
            Character character2 = new Character("character2", -1, 20);
            System.out.println(character2 + "\n");
        });
    }

    //Test creating battle
    @org.junit.Test
    public void TestCreatingBattle() {

        Gear beautiful_hat = new HeadGear(new String[]{"Beautiful", "Hat"}, 0);
        Gear wooden_helmet1 = new HeadGear(new String[]{"Wooden", "Helmet"}, 10);
        Gear metalic_helmet1 = new HeadGear(new String[]{"Metalic", "Helmet"}, 20);
        Gear golden_visor1 = new HeadGear(new String[]{"Golden", "Visor"}, 30);
        Gear transparent_cap1 = new HeadGear(new String[]{"Transparent", "cap"}, 40);

        Gear golden_shield = new HandGear(new String[]{"Golden", "Shield"}, 20, 0);
        Gear tricky_glove1 = new HandGear(new String[]{"Tricky", "Glove"}, 10, 10);
        Gear cutting_axe = new HandGear(new String[]{"Cutting", "Axe"}, 10, 20);
        Gear ironic_sword = new HandGear(new String[]{"Ironic", "Sword"}, 10, 30);

        Gear scurrying_sandal1 = new FootWear(new String[]{"Scurrying", "Sandal"}, 10, 0);
        Gear happy_hoverboard1 = new FootWear(new String[]{"Happy", "Hoverboard"}, 10, 0);
        Gear fabric_boot = new FootWear(new String[]{"Fabric", "Boot"}, 10, 0);
        Gear metalic_sneaker = new FootWear(new String[]{"Metalic", "Sneaker"}, 10, 10);

        List<Gear> gear_list = new ArrayList<>();
        gear_list.add(beautiful_hat);
        gear_list.add(wooden_helmet1);
        gear_list.add(metalic_helmet1);
        gear_list.add(golden_shield);
        gear_list.add(tricky_glove1);
        gear_list.add(cutting_axe);
        gear_list.add(ironic_sword);
        gear_list.add(scurrying_sandal1);
        gear_list.add(happy_hoverboard1);
        gear_list.add(fabric_boot);
        gear_list.add(metalic_sneaker);

        Character character1 = new Character("character1", 10, 10);
        Character character2 = new Character("character2", 10, 10);

        Battle battle1 = new Battle(character1, character2, gear_list);

        for (int i = 0; i <5; i++) {
            battle1.GetEquipment(character1);
            battle1.GetEquipment(character2);
        }
        battle1.toString();
    }
}
