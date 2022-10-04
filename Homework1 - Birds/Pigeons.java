/*
Wing Man Casca, Kwok
CS5010 Homework 1 - Birds
*/
//Child class Pigeons to specify unique child class feature
public class Pigeons extends Birds{
    private boolean extinct;

    //Constructor
    //@params extinct       boolean to reflect if a bird is facing extinction
    public Pigeons(String name, String characteristics, String food, boolean extinct) {
        super(name, characteristics, food);
        this.extinct = extinct;
    }

    //return if a bird is facing extinction
    public boolean extinct() {
        return this.extinct;
    }
}

