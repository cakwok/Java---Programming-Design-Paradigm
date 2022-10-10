package transmission;
import org.junit.Before;

public class TestAutomaticTransmission {

    @org.junit.Test
    public void test1() {
        AutomaticTransmission Setup1 = new AutomaticTransmission(2, 10, 20, 40, 50);
        System.out.println(Setup1);

        Setup1.increaseSpeed();
        System.out.println(Setup1);

        Setup1.increaseSpeed();      Setup1.increaseSpeed();      Setup1.increaseSpeed();      Setup1.increaseSpeed();
        Setup1.increaseSpeed();      Setup1.increaseSpeed();      Setup1.increaseSpeed();      Setup1.increaseSpeed();
        Setup1.increaseSpeed();      Setup1.increaseSpeed();      Setup1.increaseSpeed();      Setup1.increaseSpeed();
        System.out.println(Setup1);

        Setup1.decreaseSpeed();
        System.out.println(Setup1);
    }
}

