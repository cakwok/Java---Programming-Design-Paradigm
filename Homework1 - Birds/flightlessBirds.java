public class flightlessBirds extends Birds{

    public flightlessBirds(String name, String characteristics, String food) {
        super(name, characteristics, food);
    }
    public String GetNumWings() {
        return GetName() + " have no wing";
    }

}
