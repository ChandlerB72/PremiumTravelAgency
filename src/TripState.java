/**
 * Abstract class that all states extend
 */
public abstract class TripState {

    private TripContext tripContext; /*< Holds the trip context object pertaining to the trip*/

    //! Constructor
    public TripState(TripContext tripContext, Status tripStateStatus) {
        this.tripContext = tripContext;

        if (tripContext.getTrip() != null)
            tripContext.getTrip().setTripStateStatus(tripStateStatus);
    }

    //! Getters and Setters
    public TripContext getTripContext() {
        return tripContext;
    }
    public void setTripContext(TripContext tripContext) {
        this.tripContext = tripContext;
    }


    /**
     * @return Abstract class that every state will implement
     */
    public abstract TripStateLoop.Status execute();


    /**
     * @param answer User input from state
     * @return true if answer is "later", false otherwise
     */
    protected boolean returnLater(String answer){
        boolean returnLater = answer.toLowerCase().equals("later");

        if (returnLater) {
            System.out.println();// SAVE TRIP HERE?
            System.out.println("-- Trip Saved to Be Completed Later --");
        }

        return returnLater;
    }


    /**
     * @param str User input from state
     * @return true/false if number is numeric
     */
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    /**
     * Enum that holds all possible states of trip
     */
    public enum Status {
        Create,
        AddTravelAgent,
        AddTravelers,
        AddPackages,
        ChoosePaymentType,
        PayCash,
        PayCheck,
        PayCreditCard,
        AddThankYou,
        Complete
    }
}
