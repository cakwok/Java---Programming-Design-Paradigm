/*
Wing Man Casca, Kwok
CS5010 Assignment 1 - Birds
*/
import org.junit.Before;

public class BirdsTest {
    private BirdsofPrey ospreys, hawks, eagles;
    private flightlessBirds emus;
    private Owls owls;
    private Parrots parrots;
    private Shorebirds greatAuks, hornedPuffin;
    private Waterfowls waterfowls;

    private Pigeons pigeons;

    @Before
    public void SetUp() {
        ospreys = new BirdsofPrey("ospreys", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", true);
        emus = new flightlessBirds("flightless Birds", "live on the ground and have no (or undeveloped) wings",
                "vegetation, larvae");
        owls = new Owls("Owls", "facial disks that frame the eyes and bill", "small mammals, buds");
        parrots = new Parrots("parrots",
                "short, curved beak and are known for their intelligence and ability to mimic sounds",
                "nuts, vegetation", 20, "Hello");
        pigeons = new Pigeons("pigeons", "feeding their young bird milk very similar to the milk of mammals",
                "nuts, vegetation, buds", true);
        greatAuks = new Shorebirds("great guk", "live near water sources", "fish, larvae",
                "wetlands, freshwater and saltwater shorelands, ocean");
        hornedPuffin = new Shorebirds("horned puffin", "live near water sources", "fish, larvae",
                "wetlands, freshwater and saltwater shorelands, ocean\"");
        waterfowls = new Waterfowls("waterfowls", " live near water sources", "fish, larvae",
                "ducks, swans, and geese");

    }

    @org.junit.Test
    public void Classify() {
        System.out.println(ospreys.GetCharacteristics());
        System.out.println(ospreys.extinct());
        System.out.println(ospreys.GetNumWings());
        System.out.println(ospreys.GetFood());
        System.out.println(emus.GetNumWings());
        System.out.println(parrots.GetNumWords());
        System.out.println(parrots.GetfavSaying());
        System.out.println(owls.GetCharacteristics());
        System.out.println(pigeons.extinct());
        System.out.println(greatAuks.GetBodyofWater());
        System.out.println(waterfowls.GetBodyofWater());
    }
}