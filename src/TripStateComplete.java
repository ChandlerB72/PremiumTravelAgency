/**
 * State of trip to complete trip
 */
public class TripStateComplete extends TripState{

    //! Constructor
    public TripStateComplete(TripContext tripContext) {
        super(tripContext, Status.Complete);
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    @Override
    public TripStateLoop.Status execute() {
        System.out.println("-- Trip Completed | Itinerary Now Available --");

        return TripStateLoop.Status.Stop;
    }
}
