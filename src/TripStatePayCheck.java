import java.math.BigDecimal;
import java.util.Scanner;

/**
 * State of trip if paying with check
 */
public class TripStatePayCheck extends TripState{

    //! Constructor
    public TripStatePayCheck(TripContext tripContext) {
        super(tripContext, TripState.Status.PayCheck);
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    @Override
    public TripStateLoop.Status execute() {
        System.out.println();
        System.out.println("-- Check Payment Menu --");
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter an amount to pay");
        System.out.println("\t : Enter [later] to save and return to payment details later");
        Scanner scanner = new Scanner(System.in);

        // Navigates to new state and/or pays amount based off user input
        while (true) {
            System.out.println(getTripContext().getTrip().getBill().Describe());
            String userInput = scanner.nextLine().trim();

            // Check for return later
            if (returnLater(userInput))
                return TripStateLoop.Status.Stop;

            //Check for numerical input
            if (isNumeric(userInput)){
                System.out.println("Please enter the check number.");
                int checkNumber = scanner.nextInt();
                getTripContext().getTrip().getBill().setPayment(new PaymentCheck(new BigDecimal(userInput),checkNumber));

                // Check if bill is fully paid
                if (getTripContext().getTrip().getBill().isPaidInFull()){
                    getTripContext().changeState(new TripStateAddThankYou(getTripContext()));
                    return TripStateLoop.Status.Continue;
                }

                else{
                    System.out.println("Continue Payments..");
                    continue;
                }
            }
            else
                System.out.println("ERROR: Please input an amount to pay or [later] to save and quit");

        }
    }
}


//            if (scanner.hasNext())
//                userInput = scanner.next().trim().toLowerCase();
//
//            if (returnLater(userInput))
//                return TripStateLoop.Status.Stop;
//
//            if (userInput.isEmpty())
//                continue;
//
//            if (isNumeric(userInput)) {
//                try {
//                    System.out.println("Please input a check number.");
//
//                    int checkNumber = scanner.nextInt();
//                    getTripContext().getTrip().getBill().setPayment(new PaymentCheck(new BigDecimal(userInput), checkNumber));
//                    System.out.println("Accepted $" + userInput + " via check #" + checkNumber + "!");
//                    getTripContext().changeState(new TripStateAddThankYou(getTripContext()));
//                    return TripStateLoop.Status.Continue;
//
//                } catch (Exception e){
//                    System.out.println("ERROR: Input invalid. Please only use numbers.");
//                    continue;
//                }
//            }
//
//            // Check for return later
//            if (returnLater(userInput))
//                return TripStateLoop.Status.Stop;