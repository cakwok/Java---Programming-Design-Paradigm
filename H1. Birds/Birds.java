/*
Wing Man Casca, Kwok
CS5010 Homework 1 - Birds
*/
//Birds parent class to keep track of birds with characteristics, food, habitant, etc.
public class Birds {
    private String name, characteristics, food;
    private boolean extinct;

    //Constructor
    //Throw exception when name, characteristics, food of birds are numbers
    //@params this.name                    bird type
    //@params this.food                    diet of bird type
    //@params this.characteristics         characteristics to determine bird type
    public Birds(String name, String characteristics, String food)  throws IllegalArgumentException{
        if ((name.matches("-?[0-9]+") || characteristics.matches("-?[0-9]+") ||
                food.matches("-?[0-9]+"))){
            throw new IllegalArgumentException("Value must not be an integer");
        }
        this.name = name;
        this.characteristics = characteristics;
        this.food = food;
        this.extinct = false;
    }

    //Getter for bird name
    public String GetName() {
        return this.name;
    }

    //Getter for bird characteristics
    public String GetCharacteristics(){
        return this.name + " have " + this.characteristics;
    }

    //Getter for number of wings
    public String GetNumWings() {
        return this.name + " have " + "2 wings";
    }

    //Getter of bird food
    public String GetFood() {
        return this.name + " eat " + this.food;
    }

    //Getter of whether a bird type is facing extinct
    public boolean extinct() {
        return this.extinct;
    }
}

