/*
Wing Man Casca, Kwok
CS5010 Homework 1 - Birds
*/
//Parent class to classify birds with characteristics, food, habitant, etc.
public class Birds {
    private String name, characteristics, food;
    private boolean extinct;

    //Constructor
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

    public String GetName() {
        return this.name;
    }
    public String GetCharacteristics(){
        return this.name + " have " + this.characteristics;
    }
    public String GetNumWings() {
        return this.name + " have " + "2 wings";
    }
    public String GetFood() {
        return this.name + " eat " + this.food;
    }
    public boolean extinct() {
        return this.extinct;
    }


}

