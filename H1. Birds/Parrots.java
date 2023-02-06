/*
Wing Man Casca, Kwok
CS5010 Homework 1 - Birds
*/
//Child class Parrots to specify unique child class feature
public class Parrots extends Birds{
    private int numWords;
    private String favSaying;

    //Constructor
    //Throw exception when number of words is negative
    //@params this.numWords     number of words parrot can speak
    //@params this.favSaying    the favorite saying of the bird
    public Parrots(String name, String characteristics,  String food, int numWords, String favSaying) {

        super(name, characteristics, food);

        if (numWords < 0) {
            throw new IllegalArgumentException("Number of words must be great than or equal to 0");
        }

        this.numWords = numWords;
        this.favSaying = favSaying;
    }

    //to return number of words a parrot can speak
    public String GetNumWords () {
        return GetName() + " can speak " + this.numWords + " words";
    }

    //to return a parrot's favourite saying
    public String GetfavSaying () {
        return this.favSaying + " is " + GetName() + "' favorite saying";
    }
}
