public class Waterfowls extends Birds{
    private String bodyofWater;
    public Waterfowls(String name, String characteristics, String food,  String bodyofWater) {
        super(name, characteristics, food);
        if (bodyofWater.matches("-?[0-9]+")) {
            throw new IllegalArgumentException("Body of Water must be a string");
        }
        this.bodyofWater = bodyofWater;
    }
    public String GetBodyofWater() {
        return GetName() + "live close to " + this.bodyofWater;
    }
}

