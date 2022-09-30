public class Pigeons extends Birds{
    private boolean extinct;
    public Pigeons(String name, String characteristics, String food, boolean extinct) {
        super(name, characteristics, food);
        this.extinct = extinct;
    }
    public String extinct() {
        return GetName() + " is extinct - " + this.extinct;
    }
}

