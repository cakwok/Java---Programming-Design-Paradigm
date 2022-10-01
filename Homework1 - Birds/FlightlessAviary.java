public class FlightlessAviary extends Conservatory{
    private static int occupancy = 0;

    public FlightlessAviary(Birds bird){
        super(bird);
        occupancy ++;
    }
    public static int GetOccupancy() {
        return occupancy;
    }

}
