/*
Wing Man Casca, Kwok
CS5010 Assignment 1 - Birds
*/

import org.junit.Before;

import java.util.List;

public class BirdsTest {
    private BirdsofPrey ospreys, hawks, eagles;
    private flightlessBirds emus;
    private Owls owls;
    private Parrots parrots;
    private Shorebirds greatAuks, hornedPuffin;
    private Waterfowls waterfowls;

    private Pigeons pigeons;
    private int index = 0;

    @Before
    public void SetUp() {
        ospreys = new BirdsofPrey("ospreys", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", true);
        hawks = new BirdsofPrey("hawks", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", true);
        eagles = new BirdsofPrey("eagles", "sharp, hooked beaks with visible nostrils",
                "small mammals, fish", true);
        emus = new flightlessBirds("emus", "live on the ground and have no (or undeveloped) wings",
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
        waterfowls = new Waterfowls("waterfowls", "live near water sources", "fish, larvae",
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
        System.out.println(hornedPuffin.extinct());
    }

    @org.junit.Test

    public void AssignAviary() {

        Conservatory birdIndex[] = new Conservatory[100];
        List<Birds> birds_list = List.of(ospreys, hawks, emus, eagles, hawks, hawks, hawks, hawks, hawks);
        index = 0;

        for (Birds var : birds_list) {
            birdIndex[index] = new Conservatory(var);
            System.out.println(index);
            System.out.println(var.GetName());
            System.out.println("Assigned bird into: " + birdIndex[index].AssignAviary());
            index++;
        }
        System.out.println("Food needed and quantity:\n" + Conservatory.CalculateFood());
        System.out.println("look up aviary where a bird is in: " + birdIndex[0].SearchAviaryAssignment());
        System.out.println("look up aviary where a bird is in: " + birdIndex[2].SearchAviaryAssignment());
        System.out.println("FlightlessAviary Description: " + FlightlessAviary.GetDesc());
        System.out.println("BirdsofPreyAviary Description: " + BirdsofPreyAviary.GetDesc());
        System.out.println("Get whole map of conservatory: " + Conservatory.GetMap());
        System.out.println("Index: " + Conservatory.GetBirdIndex());
        System.out.println("Total aviaries: " + Conservatory.GetTotalNumAviary());
        System.out.println("New aviary location: " + BirdsofPreyAviary.GetAviaryLocation());


    }

/*
    public void AssignAviary() {

        OtherAviary birdIndex[] = new OtherAviary[100];
        List<Birds> birds_list = List.of(ospreys, hawks, emus, hawks, hawks, hawks, hawks, hawks, hawks);
        index = 0;

        for (Birds var : birds_list) {
            try {
                birdIndex[index] = new OtherAviary(var);
            }
            catch (Exception e) {
                try {
                    birdIndex[index] = new FlightlessAviary(var);
                }
                catch (Exception e) {
                    System.out.println("exception caught");
                }
            }
            System.out.println(index);
            System.out.println(var.GetName());
            System.out.println("Occupancy: " + birdIndex[index].GetOccupancy());
            System.out.println("Aviary assignment: " +  birdIndex[index].GetAviaryAssignment());
            System.out.println("Location: " + birdIndex[index].GetLocation() + "\n");
            index++;
        }

    }


 */
}