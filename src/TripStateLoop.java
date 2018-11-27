/**
 * State of trip to loop creation
 */
public class TripStateLoop {

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    public Trip execute() throws Exception{
        return execute(null);
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    public Trip execute(Trip trip) throws Exception{
        TripContext tripContext = trip == null
                ? new TripContext()
                : new TripContext(trip);

        while (tripContext.execute() == Status.Continue){}




        return tripContext.getTrip();
    }

    /**
     * Enum that holds possible loop states
     */
    public enum Status{
        Continue,
        Stop
    }
}
