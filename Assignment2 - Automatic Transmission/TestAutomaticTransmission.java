/*
CS5010 Module 2 Lab - Automatic Transmissions
Wing Man, Kwok
Oct 9 2022
 */
//Test cases for getting gear and speed by increasing and decreasing speed
package transmission;
import org.junit.Before;

public class TestAutomaticTransmission {

    @org.junit.Test
    public void test1() {

        AutomaticTransmission Setup1 = new AutomaticTransmission(10, 20, 30, 40, 50);

        System.out.println(Setup1);

        for (int i = 0; i<=46; i++) {
            System.out.println(i);
            Setup1.increaseSpeed();
            System.out.println(Setup1 + "\n");
        }

        Setup1.decreaseSpeed();
        System.out.println(Setup1);
    }
}

