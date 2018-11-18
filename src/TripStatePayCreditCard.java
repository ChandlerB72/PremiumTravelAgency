import java.math.BigDecimal;
import java.util.Scanner;

public class TripStatePayCreditCard extends TripState{

    // Constructor
    public TripStatePayCreditCard(TripContext tripContext) {
        super(tripContext, TripState.Status.PayCheck);
    }

    // Method
    @Override
    public TripStateLoop.Status execute() {
        System.out.println(System.lineSeparator());
        System.out.println("-- Check Payment Selected --");
        System.out.println();
        System.out.println("-- Please select one of the following: ");
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
                try {
                    String creditCardNumber = scanner.next().trim();

                    // Ensure Credit Card is 16 digits
                    while (creditCardNumber.length() != 16){
                        System.out.println("-- Error: Input invalid. Credit card number must be 16 digits");
                        creditCardNumber = scanner.next().trim();
                    }

                    getTripContext().getTrip().setPayment(new PaymentCreditCard(new BigDecimal(userInput), creditCardNumber));
                    System.out.println("--Accepted " + userInput + " via check --");
                    getTripContext().changeState(new TripStateAddThankYou(getTripContext()));
                    return TripStateLoop.Status.Continue;

                } catch (Exception e) {
                    System.out.println("-- Error: Input invalid. Please only use numbers. --");
                    continue;
                }
            }

            System.out.println("-- Error: Selection invalid. Please try again! --");
        }
    }
}
