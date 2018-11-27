import java.util.Date;
import java.util.Random;

/**
 * State of trip to create trip
 */
public class TripStateCreate extends TripState {

    //! Constructor
    public TripStateCreate(TripContext tripContext) {
        super(tripContext, Status.Create);

        Trip trip = new Trip();
        trip.setBookedOn(new Date());
        trip.setOrderId(new Random().nextInt(10000));
        //TODO: Need to check if trip ID is duplicate
        trip.setTripStateStatus(Status.Create);

        getTripContext().setTrip(trip);
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    @Override
    public TripStateLoop.Status execute() {
        System.out.println();
        System.out.println("----- PREMIUM TRAVEL SERVICES TRIP RESERVATION SYSTEM -----");
        System.out.println();
        getTripContext().changeState(new TripStateAddTraveler(getTripContext()));

        return TripStateLoop.Status.Continue;
    }
}
