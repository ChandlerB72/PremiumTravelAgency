import java.util.Date;
import java.util.Random;

public class TripStateCreate extends TripState {

    // Constructor
    public TripStateCreate(TripContext tripContext) {
        super(tripContext, Status.Create);

        Trip trip = new Trip();
        trip.setBookedOn(new Date());
        trip.setOrderId(new Random().nextInt(10000));
        //TODO: Need to check if trip ID is duplicate
        trip.setTripStateStatus(Status.Create);

        getTripContext().setTrip(trip);
    }

    // Methods
    @Override
    public TripStateLoop.Status execute() {
        System.out.println();
        System.out.println("NEW TRIP CREATED");
        System.out.println();
        getTripContext().changeState(new TripStateAddTraveler(getTripContext()));

        return TripStateLoop.Status.Continue;
    }
}
