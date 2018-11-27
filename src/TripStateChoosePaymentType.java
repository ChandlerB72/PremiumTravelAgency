import java.util.List;
import java.util.Scanner;

public class TripStateChoosePaymentType extends TripState{
    private List<Person> payingPersonOptions = LoadPerson.getInstance(); /*< Singleton loaded list */

    //! Constructor
    public TripStateChoosePaymentType(TripContext tripContext) {
        super (tripContext, Status.ChoosePaymentType);
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("-- Payment Menu --");

        System.out.println(getTripContext().getTrip().getBill().Describe());

        // Check if user wants to pay by cash, check, credit, or save and quit
        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter [cash] to pay by cash");
        System.out.println("\t : Enter [check] to pay by check");
        System.out.println("\t : Enter [credit] to pay by credit card");
        System.out.println("\t : Enter [later] to save and return to payment details later");

        // Navigates to new state based off user input
        while (true){
            String userInput = new String();

            if (scanner.hasNext())
                userInput = scanner.next().trim().toLowerCase();

            if (returnLater(userInput))
                return TripStateLoop.Status.Stop;

            if (userInput.isEmpty())
                continue;

            if (userInput.equals("cash")){
                getTripContext().changeState(new TripStatePayCash(getTripContext()));
                return TripStateLoop.Status.Continue;
            }

            if (userInput.equals("check")){
                getTripContext().changeState(new TripStatePayCheck(getTripContext()));
                return TripStateLoop.Status.Continue;
            }

            if (userInput.equals("credit")){
                getTripContext().changeState(new TripStatePayCreditCard(getTripContext()));
                return TripStateLoop.Status.Continue;
            }

            System.out.println("ERROR: Selection invalid. Please try again!");

        }

    }
}
