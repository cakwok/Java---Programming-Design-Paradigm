public class AssignOtherAviary extends Conservatory{
    private int occupancy = 0;
    private int aviaryNum = 0;
    private String location;
    public AssignOtherAviary(Birds bird){
        //super(bird);
        occupancy ++;

        if (occupancy <=5) {
            aviaryNum = 0;
            location = "Ground Floor";
        }
        else if (occupancy > 5 && occupancy <= 10) {
            aviaryNum = 1;
            location = "First Floor";
        }
    }
    public int GetAviaryNum() {
        return aviaryNum;
    }
    public String GetAviaryAssignment() {
        return "OtherAviary" + aviaryNum;
    }
    public String GetLocation() {
        return location;
    }
}
