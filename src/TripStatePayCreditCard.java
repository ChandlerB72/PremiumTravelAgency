import java.math.BigDecimal;
import java.util.Scanner;

public class TripStatePayCreditCard extends TripState{

    // Constructor
    public TripStatePayCreditCard(TripContext tripContext) {
        super(tripContext, Status.PayCreditCard);
    }

    // Methods
    @Override
    public TripStateLoop.Status execute() {
        System.out.println();
        System.out.println("-- Credit Card Payment Menu --");
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter an amount to pay");
        System.out.println("\t : Enter [later] to save and return to payment details later");

        Scanner scanner = new Scanner(System.in);

        // Navigates to new state and/or pays amount based off user input
        while (true){
            String userInput = scanner.next().trim();

            // Check for Return Later
            if (returnLater(userInput))
                return TripStateLoop.Status.Stop;

            // Will output error located at bottom of loop
            if (userInput.isEmpty())
                continue;

            if (isNumeric(userInput)) {
                try {
                    System.out.println("Please input your credit card number.");
                    String creditCardNumber = scanner.next().trim();

                    // Ensure Credit Card is 16 digits
                    while (creditCardNumber.length() != 16){
                        System.out.println("ERROR: Input invalid. Credit card number must be 16 digits!");
                        creditCardNumber = ""; //Resetting credit card number
                        creditCardNumber = scanner.next().trim();
                    }


                    getTripContext().getTrip().setPayment(new PaymentCreditCard(new BigDecimal(userInput), creditCardNumber));
                    System.out.println("--Accepted $" + userInput + " via credit card (****" +
                            creditCardNumber.substring(creditCardNumber.length() - 4) + ") --");
                    getTripContext().changeState(new TripStateAddThankYou(getTripContext()));
                    return TripStateLoop.Status.Continue;

                } catch (Exception e) {
                    System.out.println("ERROR: Input invalid. Please only use numbers.");
                    continue;
                }
            }

            System.out.println("ERROR: Selection invalid. Please try again!");
        }
    }
}
