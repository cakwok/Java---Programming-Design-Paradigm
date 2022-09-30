/*
Wing Man Casca, Kwok
CS5010 Assignment 1 - Birds
*/

public class Birds {
    private String name, characteristics, food;

    public Birds(String name, String characteristics, String food)  throws IllegalArgumentException{
        if ((name.matches("-?[0-9]+") || characteristics.matches("-?[0-9]+") ||
                food.matches("-?[0-9]+"))){
            throw new IllegalArgumentException("Value must not be an integer");
        }
        this.name = name;
        this.characteristics = characteristics;
        this.food = food;
    }
    public String GetCharacteristics(){
        return this.characteristics;
    }
    public String GetNumWings() {
        return "2 wings";
    }
    public String GetFood() {
        return this.food;
    }

}

