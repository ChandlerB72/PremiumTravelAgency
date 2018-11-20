import java.util.Scanner;

public class TripStateAddDestinations extends TripState{

    // Constructor
    public TripStateAddDestinations(TripContext tripContext) {
        super(tripContext, Status.AddDestinations);
    }

    // Methods
    private boolean isDestinationListValid() {
        if (getTripContext().getTrip().getDestinations().isEmpty()){
            System.out.println("-- Error: No destinations. At least one destination required");
        return false;
    }
        return true;
    }

    private boolean isDestinationValid(String newDestination){
        if (newDestination.isEmpty()){
            System.out.println("-- Error: Blank destinations are prohibited --");
            return false;
        }

        boolean isDuplicate = getTripContext().getTrip().getDestinations().contains(newDestination);
        if (isDuplicate)
            System.out.println("-- Error: You can't enter the same destination twice. --");

        return !isDuplicate;
    }

    private boolean continueEnteringDestinations(String newDestination){
        boolean done = newDestination.toLowerCase().equals("done");

        if (done && !getTripContext().getTrip().getDestinations().isEmpty()){
            System.out.println();
            System.out.println("-- Destinations Complete. " +
                    getTripContext().getTrip().getDestinations().size() + " entered.==");
        }

        return !done;
    }

    private void showCurrentDestinations(){
        if (!getTripContext().getTrip().getDestinations().isEmpty())
            System.out.println("-- Currently " + getTripContext().getTrip().getDestinations().size() + " in trip.");

        for (int dest = 0; dest < getTripContext().getTrip().getDestinations().size(); dest++) {
            System.out.println((dest + 1) + ". " + getTripContext().getTrip().getDestinations().get(dest));
        }

        System.out.println();
    }

    @Override
    public TripStateLoop.Status execute(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(System.lineSeparator());
        System.out.println("-- Add Destinations --");
        System.out.println();
        System.out.println("-- Please select one of the following: ");
        System.out.println("\t : Enter your destinations");
        System.out.println("\t : Enter [done] to finish adding destinations");
        System.out.println("\t : Enter [later] to save and return to add destinations later");

        boolean getDestinations = false;
        while (!getDestinations) {
            String userInput = scanner.nextLine().trim();

            if (returnLater(userInput))
                return TripStateLoop.Status.Stop;

            if (continueEnteringDestinations(userInput)) {
                if (isDestinationValid(userInput)) {
                    getTripContext().getTrip().getDestinations().add(userInput);
                    System.out.println("-- " + userInput + " Added --");
                }
            }
            else {
                getDestinations = isDestinationListValid();
            }
        }

        getTripContext().changeState(new TripStateChoosePaymentType(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}
