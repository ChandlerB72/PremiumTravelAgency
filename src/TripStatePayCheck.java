import java.math.BigDecimal;
import java.util.Scanner;

public class TripStatePayCheck extends TripState{

    // Constructor
    public TripStatePayCheck(TripContext tripContext) {
        super(tripContext, TripState.Status.PayCheck);
    }

    // Methods
    @Override
    public TripStateLoop.Status execute() {
        System.out.println(System.lineSeparator());
        System.out.println("-- Check Payment Menu --");
        System.out.println("Please input a check number.");
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
                    System.out.println("Please select one of the following: ");
                    System.out.println("\t : Enter an amount to pay");
                    System.out.println("\t : Enter [later] to save and return to payment details later");

                    int checkNumber = scanner.nextInt();
                    getTripContext().getTrip().setPayment(new PaymentCheck(new BigDecimal(userInput), checkNumber));
                    System.out.println("-- Accepted " + checkNumber + " via check #" + userInput + " -- ");
                    getTripContext().changeState(new TripStateAddThankYou(getTripContext()));
                    return TripStateLoop.Status.Continue;

                } catch (Exception e){

                    System.out.println("ERROR: Input invalid. Please only use numbers.");
                    continue;

                }
            }

            System.out.println("ERROR: Selection invalid. Please try again!");
        }
    }
}
