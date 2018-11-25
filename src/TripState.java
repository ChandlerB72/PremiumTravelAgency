public abstract class TripState {

    // Variables
    private TripContext tripContext;

    // Constructor
    public TripState(TripContext tripContext, Status tripStateStatus) {
        this.tripContext = tripContext;

        if (tripContext.getTrip() != null)
            tripContext.getTrip().setTripStateStatus(tripStateStatus);
    }

    // Getters and Setters
    public TripContext getTripContext() {
        return tripContext;
    }

    public void setTripContext(TripContext tripContext) {
        this.tripContext = tripContext;
    }

    // Methods
    public abstract TripStateLoop.Status execute();

    protected boolean returnLater(String answer){
        boolean returnLater = answer.toLowerCase().equals("later");

        if (returnLater) {
            System.out.println();
            System.out.println("-- Trip Saved to Be Completed Later --");
        }

        return returnLater;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public enum Status {
        Create,
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
