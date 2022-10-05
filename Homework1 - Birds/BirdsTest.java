/*
Wing Man Casca, Kwok
CS5010 Homework 1 - Birds
*/
//Test code to test part 1 and part 2
import org.junit.Before;

import java.util.List;

public class BirdsTest {
    private BirdsofPrey ospreys, hawks, eagles;
    private flightlessBirds emus, kiwis;
    private Owls owls;
    private Parrots parrots;
    private Pigeons pigeons;
    private Shorebirds greatAuks, hornedPuffin, africanJacana;
    private Waterfowls ducks, swans,  geese;
    private int index = 0;

    //Initialize bird objects and assign characteristics
    @Before
    public void SetUp() {
        ospreys = new BirdsofPrey("ospreys", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", false);
        hawks = new BirdsofPrey("hawks", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", false);
        hawks = new BirdsofPrey("hawks", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", false);
        hawks = new BirdsofPrey("hawks", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", false);
        hawks = new BirdsofPrey("hawks", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", false);
        eagles = new BirdsofPrey("eagles", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", true);
        emus = new flightlessBirds("emus", "live on the ground and have no (or undeveloped) wings",
                "vegetation, larvae");
        kiwis = new flightlessBirds("kiwis", "live on the ground and have no (or undeveloped) wings",
                "vegetation, larvae");
        owls = new Owls("owls", "facial disks that frame the eyes and bill", "small mammals, buds");
        parrots = new Parrots("parrots",
                "short, curved beak and are known for their intelligence and ability to mimic sounds",
                "nuts, vegetation", 20, "Hello");
        pigeons = new Pigeons("pigeons", "feeding their young bird milk very similar to the milk of mammals",
                "nuts, vegetation, buds", false);
        greatAuks = new Shorebirds("great guk", "live near water sources", "fish, larvae",
                "wetlands, freshwater and saltwater shorelands, ocean");
        hornedPuffin = new Shorebirds("horned puffin", "live near water sources", "fish, larvae",
                "wetlands, freshwater and saltwater shorelands, ocean");
        africanJacana= new Shorebirds("horned puffin", "live near water sources", "fish, larvae",
                "wetlands, freshwater and saltwater shorelands, ocean");
        ducks = new Waterfowls("ducks", "live near water sources", "fish, larvae",
                "lake, pound");
        swans = new Waterfowls("swans", "live near water sources", "fish, larvae",
                "lake, pound");
        geese = new Waterfowls("geese", "live near water sources", "fish, larvae",
                "lake, pound");
    }

    //Test code for part 1, to test classifying birds and test if result matches expected result
    @org.junit.Test
    public void Classify() {
        System.out.println("Part 1 - Classification\n");
        System.out.println(ospreys.GetCharacteristics());
        System.out.println("ospreys are extinct: " + ospreys.extinct());
        System.out.println(ospreys.GetNumWings());
        System.out.println(ospreys.GetFood());
        System.out.println(emus.GetNumWings());
        System.out.println(parrots.GetNumWords());
        System.out.println(parrots.GetfavSaying());
        System.out.println(owls.GetCharacteristics());
        System.out.println("pigeons are extinct: " + pigeons.extinct());
        System.out.println(greatAuks.GetBodyofWater());
        System.out.println(ducks.GetBodyofWater());
        System.out.println("hornedPuffin is extinct: " + hornedPuffin.extinct());
    }

    //Test code for part 2, to test assigning birds and test if result matches expected result
    // @params birdIndex[]              bird holder to create new Conservatory instance
    // @params birds_list             a list to hold bird objects
    // @params birds_list_string      a list to hold bird name in string
    // @params index                  to locate position in the birds_list and birds_list_string lists

    @org.junit.Test
    public void AssignAviary() {

        System.out.println("Part 2 - Assign birds into conservatory\n");

        Conservatory birdIndex[] = new Conservatory[100];
        List<Birds> birds_list = List.of(ospreys, hawks, emus, eagles, hawks, hawks, hawks, hawks, hawks, parrots, pigeons, pigeons, ducks, greatAuks, hornedPuffin, owls, emus, kiwis, pigeons, greatAuks, africanJacana, owls, emus, kiwis, pigeons, owls, emus, kiwis, pigeons,parrots);
        List<String> birds_list_string = List.of("osprey1", "hawk1", "emus1", "eagle1", "hawk2", "hawk3", "hawk4", "hawk5", "hawk6", "parrot1", "pigeon1", "pigeon2", "duck1", "greatAuk1", "hornedPuffin1", "owl1", "emus2", "kiwi1", "pigeon3", "greatAuk2", "africanJacana", "owl2", "emus3", "kiwi2", "pigeon4", "owl3", "emus4", "kiwi3", "pigeon5", "parrot2");
        index = 0;

        //Test case 1: Normal
        System.out.println("Test case1: normal");
        for (int i = 0; i<birds_list.size(); i++) {
            try {
                birdIndex[index] = new Conservatory(birds_list.get(i), birds_list_string.get(i));
                birdIndex[index].AssignAviary();
                index++;
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println("\nFood required and quantity:\n----------------\n" + Conservatory.CalculateFood());
        System.out.println("\nLook up where a bird is in:\n----------------\n" + birds_list_string.get(0) + " is in: " + birdIndex[0].SearchAviaryAssignment());
        System.out.println("\nLook up where a bird is in:\n----------------\n" + birds_list_string.get(2) + " is in: " + birdIndex[2].SearchAviaryAssignment());
        System.out.println("\nFlightlessAviary Description:\n----------------\n " + FlightlessAviary.GetDesc());
        System.out.println("\nBirdsofPreyAviary Description:\n----------------\n" + BirdsofPreyAviary.GetDesc());
        System.out.println("\nGet whole map of conservatory:\n----------------\n" + Conservatory.GetMap());
        System.out.println("\nIndex:\n----------------\n" + Conservatory.GetBirdIndex());
        System.out.println("\nTotal aviaries:\n----------------\n" + Conservatory.GetTotalNumAviary());

        //Test case 2: >100 birds
        System.out.println("\nTest case 2 - aviaries > 20 \n");
        System.out.println("Total birds added to conservatory in previous case: " + (index + 1));
        for (int i = 0; i<=100; i++) {
            System.out.println("adding the " + (index + 2) + " bird");
            birdIndex[index] = new Conservatory(ospreys, "osprey1");
            birdIndex[index].AssignAviary();
            index++;
        }
    }
}