/*
Wing Man Casca, Kwok
CS5010 Homework 1 - Birds
*/
//Child class BirdsofPrey to specify unique child class feature
public class BirdsofPrey extends Birds{
    private boolean extinct;

    //Constructor
    //@params extinct       boolean to return if the bird type is facing extinction
    public BirdsofPrey(String name, String characteristics,  String food, boolean extinct) {
        super(name, characteristics, food);
        this.extinct = extinct;
    }

    //setter for if the bird is extinct
    public boolean extinct() {
        return this.extinct;
    }

}
