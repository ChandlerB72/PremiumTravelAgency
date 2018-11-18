public class TripStateLoop {

    // Methods
    public Trip execute(){
        return execute(null);
    }

    public Trip execute(Trip trip){

        TripContext tripContext = trip == null ? new TripContext() : new TripContext(trip);

        while (tripContext.execute() == Status.Continue){}

        System.out.println(System.lineSeparator());
        System.out.println("-- Trip Loop has Stopped--");
        System.out.println(System.lineSeparator());

        return tripContext.getTrip();
    }

    public enum Status{
        Continue,
        Stop
    }
}
