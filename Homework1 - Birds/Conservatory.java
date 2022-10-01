public class Conservatory {
    Birds bird;
    private int index = 0;

    AssignOtherAviary birdIndex[] = new AssignOtherAviary[100];
    public Conservatory(Birds bird) throws IllegalArgumentException {
        this.bird = bird;
    }

    public String AssignAviary(){
        if (bird.getClass().equals(BirdsofPrey.class)) {
            birdIndex[index] = new AssignOtherAviary(bird);
            //AssignOtherAviary bird = new AssignOtherAviary(this.bird);
            return birdIndex[index].GetAviaryAssignment();
        }
        return "-1";
    }

    public int GetAviaryNum() {
        if (bird.getClass().equals(BirdsofPrey.class)) {
            return OtherAviary.ReturnAviaryNum();
        }
        return -2;
    }
*/
}
