import java.util.Date;
import java.util.Random;

public class TripStateCreate extends TripState {

    // Constructor
    public TripStateCreate(TripContext tripContext) {
        super(tripContext, Status.Create);

        Trip trip = new Trip();
        trip.setBookedOn(new Date());
        trip.setOrderId(new Random().nextInt(10000));
        trip.setTripStateStatus(Status.Create);

        getTripContext().setTrip(trip);
    }

    // Methods
    @Override
    public TripStateLoop.Status execute() {
        System.out.println();
        System.out.println("-- New Trip Created --");
        getTripContext().changeState(new TripStateAddDestinations(getTripContext()));

        return TripStateLoop.Status.Continue;
    }
}
