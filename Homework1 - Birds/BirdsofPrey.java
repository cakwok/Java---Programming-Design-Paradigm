public class BirdsofPrey extends Birds{
    boolean extinct;

    public BirdsofPrey(String name, String characteristics,  String food, boolean extinct) {
        super(name, characteristics, food);
        this.extinct = extinct;
    }
    public boolean extinct() {
        return this.extinct;
    }

}
