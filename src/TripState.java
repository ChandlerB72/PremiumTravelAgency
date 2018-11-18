public abstract class TripState {

    // Variables
    private TripContext tripContext;

    // Constructor
    public TripState(TripContext tripContext, Status tripStateStatus) {
        this.tripContext = tripContext;

        if(tripContext.getTrip() != null)
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

        if(returnLater) {
            System.out.println();
            System.out.println("--Trip Saved to Be Completed Later--");
        }

        return returnLater;
    }

    public enum Status {
        Create,
        AddDestinations,
        ChoosePaymentType,
        PayCash,
        PayCheck,
        PayCreditCard,
        AddThankYou,
        Complete
    }
}
