/**
 * Handles object creation of TripStates
 */
public class TripContextStateFactory {


    /**
     * @param tripContext The context of the trip
     * @return the TripState to change to
     * @throws Exception
     */
    public static TripState get(TripContext tripContext) throws Exception {

        // Ensures tripContext and Trip have been instantiated
        assert tripContext != null;
        assert tripContext.getTrip() != null;

        // Sets local variable tripStateStatus with the state of the trip
        TripState.Status tripStateStatus = tripContext.getTrip().getTripStateStatus();

        // Handles switching to the correct state
        switch (tripStateStatus)
        {
            case Create:
                return new TripStateCreate(tripContext);

            case AddTravelers:
                return new TripStateAddTraveler(tripContext); // Travelers

            case AddPackages:
                return new TripStateAddPackage(tripContext); //Packages

            case PayCash:
                return new TripStatePayCash(tripContext);

            case PayCheck:
                return new TripStatePayCheck(tripContext);

            case PayCreditCard:
                return new TripStatePayCreditCard(tripContext);

            case ChoosePaymentType:
                return new TripStateChoosePaymentType(tripContext);

            case AddThankYou:
                return new TripStateAddThankYou(tripContext);

            case Complete:
                return new TripStateComplete(tripContext);

            default:
                throw new Exception(tripStateStatus + " is an invalid state");
        }
    }
}
