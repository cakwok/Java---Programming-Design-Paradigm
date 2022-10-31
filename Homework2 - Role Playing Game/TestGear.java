/*
CS5010 Homework2 - Role Playing Games
Wing Man, Kwok
Oct 25 2022
 */
//Test case for creating gear
import static org.junit.Assert.*;

public class TestGear {

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


}
