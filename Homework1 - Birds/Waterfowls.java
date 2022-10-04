/*
Wing Man Casca, Kwok
CS5010 Homework 1 - Birds
*/
//Child class Waterfowls to specify unique child class feature
public class Waterfowls extends Birds{
    private String bodyofWater;

    //Constructor
    //Throw exception when body of water is numbers
    //@params this.bodyofwater          to describe body of water
    public Waterfowls(String name, String characteristics, String food,  String bodyofWater) {

        super(name, characteristics, food);

        if (bodyofWater.matches("-?[0-9]+")) {
            throw new IllegalArgumentException("Body of Water must be a string");
        }

        this.bodyofWater = bodyofWater;
    }

    //return description of body of water
    public String GetBodyofWater() {
        return GetName() + " live close to " + this.bodyofWater;
    }
}

