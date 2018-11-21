public class TripStateComplete extends TripState{

    // Constructor
    public TripStateComplete(TripContext tripContext) {
        super(tripContext, Status.Complete);
    }

    @Override
    public TripStateLoop.Status execute() {
        System.out.println("-- Trip Completed | Itinerary Now Available --");

        return TripStateLoop.Status.Stop;
    }
}
