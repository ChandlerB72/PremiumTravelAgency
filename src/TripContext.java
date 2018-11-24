public class TripContext {

    // Variables
    private Trip trip;
    private TripState tripState;

    // Constructors
    public TripContext() {
        this.tripState = new TripStateCreate(this);
    }

    public TripContext(Trip trip) throws Exception{
        assert trip != null : "ERROR: Trip can't be null!";

        this.trip = trip;
        tripState = TripContextStateFactory.get(this);
    }

    // Getters and Setters
    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public TripState getTripState() {
        return tripState;
    }

    // Methods
    public void changeState(TripState newState){
        tripState = newState;
    }

    public TripStateLoop.Status execute(){
        return tripState.execute();
    }
}
