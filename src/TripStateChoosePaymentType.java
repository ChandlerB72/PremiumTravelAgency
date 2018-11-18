import java.util.Scanner;

public class TripStateChoosePaymentType extends TripState{

    // Constructor

    public TripStateChoosePaymentType(TripContext tripContext) {
        super (tripContext, Status.ChoosePaymentType);
    }

    // Methods

    @Override
    public TripStateLoop.Status execute() {
        System.out.println(System.lineSeparator());
        System.out.println("--Choose Payment Type--");
        System.out.println();
        System.out.println("--Please select one of the following: ");
        System.out.println("\t : Enter [cash] to pay by cash");
        System.out.println("\t : Enter [check] to pay by check");
        System.out.println("\t : Enter [credit] to pay by credit card");
        System.out.println("\t : Enter [later] to save and return to payment details later");

        Scanner scanner = new Scanner(System.in);

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

            System.out.println("-- Error: Selection invalid. Please try again!--");

        }

    }
}
