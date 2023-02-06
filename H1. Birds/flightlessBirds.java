/*
Wing Man Casca, Kwok
CS5010 Homework 1 - Birds
*/
//Child class flightlessBirds to specify unique child class feature
public class flightlessBirds extends Birds{

    //Constructor
    public flightlessBirds(String name, String characteristics, String food) {
        super(name, characteristics, food);
    }

    //setter for number of wings
    public String GetNumWings() {
        return GetName() + " have no wing";
    }

}
