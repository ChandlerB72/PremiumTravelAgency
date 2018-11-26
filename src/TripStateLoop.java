public class TripStateLoop {

    // Methods
    public Trip execute() throws Exception{
        return execute(null);
    }

    public Trip execute(Trip trip) throws Exception{
        TripContext tripContext = trip == null
                ? new TripContext()
                : new TripContext(trip);

        while (tripContext.execute() == Status.Continue){}




        return tripContext.getTrip();
    }

    public enum Status{
        Continue,
        Stop
    }
}
