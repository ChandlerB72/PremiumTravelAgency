public class TripStateComplete extends TripState{

    // Constructor
    public TripStateComplete(TripContext tripContext) {
        super(tripContext, Status.Complete);
    }

    @Override
    public TripStateLoop.Status execute() {
        System.out.println(System.lineSeparator());
        System.out.println("-- Trip Booked. Itinerary Now Available --");
        System.out.println();

        return TripStateLoop.Status.Stop;
    }
}
