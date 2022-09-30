public class Parrots extends Birds{

    private int numWords;
    private String favSaying;

    public Parrots(String name, String characteristics,  String food, int numWords, String favSaying) {
        super(name, characteristics, food);
        if (numWords < 0) {
            throw new IllegalArgumentException("Number of words must be great than or equal to 0");
        }
        this.numWords = numWords;
        this.favSaying = favSaying;
    }
    public int GetNumWords () {
        return this.numWords;
    }
    public String GetfavSaying () {
        return this.favSaying;
    }
}
