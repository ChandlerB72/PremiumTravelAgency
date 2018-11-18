import java.math.BigDecimal;
import java.util.Scanner;

public class TripStatePayCash extends TripState{

    // Constructor
    public TripStatePayCash(TripContext tripContext) {
        super(tripContext, Status.PayCash);
    }

    @Override
    public TripStateLoop.Status execute() {
        System.out.println(System.lineSeparator());
        System.out.println("-- Cash Payment Selected --");
        System.out.println();
        System.out.println("--Please select one of the following: ");
        System.out.println("\t : Enter an amount to pay");
        System.out.println("\t : Enter [later] to save and return to payment details later");

        Scanner scanner = new Scanner(System.in);

        // Navigates to new state and/or pays amount based off user input
        while (true){
            String userInput = new String();

            if (scanner.hasNext())
                userInput = scanner.next().trim().toLowerCase();

            if (returnLater(userInput))
                return TripStateLoop.Status.Stop;

            if (userInput.isEmpty())
                continue;

            if (isNumeric(userInput)) {
                getTripContext().getTrip().setPayment(new PaymentCash(new BigDecimal(userInput)));
                System.out.println("--Accepted " + userInput + " in cash --");
                getTripContext().changeState(new TripStateAddThankYou(getTripContext()));
                return TripStateLoop.Status.Continue;
            }

            System.out.println("-- Error: Selection invalid. Please try again!--");
        }
}
