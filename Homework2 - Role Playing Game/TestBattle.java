/*
CS5010 Homework2 - Role Playing Games
Wing Man, Kwok
Oct 25 2022
 */
//Test case for creating battle
import java.util.ArrayList;
import java.util.List;
public class TestBattle {

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
        //gear_list.add(beautiful_hat);
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
        battle1.Play();
    }
}
