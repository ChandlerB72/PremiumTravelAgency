import java.util.Scanner;


/**
 * State of trip to add Packages
 */
public class TripStateAddThankYou extends TripState{

    //! Constructor
    public TripStateAddThankYou(TripContext tripContext) {
        super(tripContext, Status.AddThankYou);
    }

    /**
     * @param thankYou user input from the execute method
     * @return true if user input passes all data validation
     */
    private boolean isThankYouValid(String thankYou){
        if (thankYou.isEmpty()){
            System.out.println("-- Error: Thank you can't be empty --");
            return false;
        }
        if (thankYou.length() < 5) {
            System.out.println("-- Error: Thank you must be 5 characters or more --");
            return false;
        }
        return true;
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    @Override
    public TripStateLoop.Status execute() {
        System.out.println();
        System.out.println("-- Thank You Creation Menu --");
        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Thank you message (5 characters or more)");
        System.out.println("\t : Enter [later] to save and return to Thank You later");

        Scanner scanner = new Scanner(System.in);
        boolean thanked = false;
        String userInput = null;

        while (!thanked) {
            userInput = scanner.nextLine().trim();

            if (returnLater(userInput)){
                return TripStateLoop.Status.Stop;
            }

            thanked = isThankYouValid(userInput);
        }

        getTripContext().getTrip().setThankYou(userInput);
        getTripContext().changeState(new TripStateComplete(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}
