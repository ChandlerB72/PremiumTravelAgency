public class TripContext {

    private Trip trip; /*< Holds the active trip object*/
    private TripState tripState; /*< Holds the active trip object's state*/

    //! Constructor
    public TripContext() {
        this.tripState = new TripStateCreate(this);
    }

    //! Constructor
    public TripContext(Trip trip) throws Exception{
        assert trip != null : "ERROR: Trip can't be null!";

        this.trip = trip;
        tripState = TripContextStateFactory.get(this);
    }

    //! Getter
    public Trip getTrip() {
        return trip;
    }
    //! Setter
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    //! Getter
    public TripState getTripState() {
        return tripState;
    }


    /**
     * @param newState State that trip needs to be changed to
     */
    public void changeState(TripState newState){
        tripState = newState;
    }

    /**
     * @return TripStateLoop.Status object
     */
    public TripStateLoop.Status execute(){
        return tripState.execute();
    }
}
