public class TripContextStateFactory {

    // Methods
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
                return new TripStateAddTravelers(tripContext);

            case AddPackages:
                return new TripStateAddPackages(tripContext);

            case AddDestinations:
                return new TripStateAddDestinations(tripContext);

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
