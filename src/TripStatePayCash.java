import java.math.BigDecimal;
import java.util.Scanner;

public class TripStatePayCash extends TripState{

    // Constructor
    public TripStatePayCash(TripContext tripContext) {
        super(tripContext, Status.PayCash);
    }

    // Methods
    @Override
    public TripStateLoop.Status execute() {
        System.out.println();
        System.out.println("-- Cash Payment Menu --");
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
                getTripContext().getTrip().getBill().setPayment(new PaymentCash(new BigDecimal(userInput)));

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
