import org.junit.Test;

public class TestGear {

    private Gear gear;
    private Character character;

    @org.junit.Test
    public void TestGetName() {
       ;
        Gear metalic_helmet1 = new HeadGear(new String[]{"Scurrying", "Sandals"}, 10);
        System.out.println(metalic_helmet1 .GetGearName());
        System.out.println(metalic_helmet1 .GetDefense());
        System.out.println(metalic_helmet1 .GetAttack());

        Gear tricky_glove1 = new HandGear(new String[]{"Tricky", "Glove"}, 10, 10);
        System.out.println(tricky_glove1 .GetGearName());
        System.out.println(tricky_glove1 .GetDefense());
        System.out.println(tricky_glove1 .GetAttack());

        Gear scurrying_sandals1 = new FootWear(new String[]{"Scurrying", "Sandals"}, 10, 10);
        System.out.println(scurrying_sandals1 .GetGearName());
        System.out.println(scurrying_sandals1 .GetDefense());
        System.out.println(scurrying_sandals1 .GetAttack());
    }

    @org.junit.Test
    public void TestGetCharacter() {

        Gear metalic_helmet1 = new HeadGear(new String[]{"Metalic", "Helmet"}, 10);
        Gear tricky_glove1 = new HandGear(new String[]{"Tricky", "Glove"}, 10, 10);
        Gear scurrying_sandals1 = new FootWear(new String[]{"Scurrying", "Sandals"}, 10, 10);

        Character character1 = new Character (10, 10);
        Character character2 = new Character (20, 20);

        character1.EquipGear(metalic_helmet1);
        System.out.println(character1);

        character1.EquipGear(tricky_glove1);
        character1.EquipGear(tricky_glove1);
        System.out.println(character1);

        character1.EquipGear(scurrying_sandals1);
        System.out.println(character1);
    }

}
