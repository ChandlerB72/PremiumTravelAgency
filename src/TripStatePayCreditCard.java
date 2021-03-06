import java.math.BigDecimal;
import java.util.Scanner;

/**
 * State of trip if paying with card
 */
public class TripStatePayCreditCard extends TripState{

    //! Constructor
    public TripStatePayCreditCard(TripContext tripContext) {
        super(tripContext, Status.PayCreditCard);
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    @Override
    public TripStateLoop.Status execute() {

        System.out.println();
        System.out.println("-- Credit Card Payment Menu --");
        System.out.println();

        System.out.println(getTripContext().getTrip().getBill().Describe());

        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter an amount to pay");
        System.out.println("\t : Enter [later] to save and return to payment details later");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        // Navigates to new state and/or pays amount based off user input
        while (true) {
            Person payingPerson = selectPersonPaying();
            System.out.println(getTripContext().getTrip().getBill().Describe());
            String userInput = scanner.nextLine().trim();

            // Check for return later
            if (returnLater(userInput))
                return TripStateLoop.Status.Stop;

            //Check for numerical input
            if (isNumeric(userInput)){
                System.out.println("Please enter the credit card number");
                String creditCardNumber = scanner.next().trim();

                // Ensure Credit Card is 16 digits
                while (creditCardNumber.length() != 16){
                    System.out.println("ERROR: Input invalid. Credit card number must be 16 digits!");
                    creditCardNumber = ""; //Resetting credit card number
                    creditCardNumber = scanner.next().trim();
                }

                getTripContext().getTrip().getBill().setPayment(new PaymentCreditCard(new BigDecimal(userInput),payingPerson,creditCardNumber));
                getTripContext().getTrip().getPayments().add(new PaymentCreditCard(new BigDecimal(userInput),payingPerson,creditCardNumber));
                // Check if bill is fully paid
                if (getTripContext().getTrip().getBill().isPaidInFull()){
                    getTripContext().changeState(new TripStateAddThankYou(getTripContext()));
                    return TripStateLoop.Status.Continue;
                }

                else{
                    System.out.println("Continue Payments..");
                    getTripContext().changeState(new TripStateChoosePaymentType(getTripContext()));
                    return TripStateLoop.Status.Continue;
                }
            }
            else
                System.out.println("ERROR: Please input an amount to pay or [later] to save and quit");

        }
    }
}