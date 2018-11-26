import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class TripStateChoosePaymentType extends TripState{
    private List<Person> payingPersonOptions = LoadPerson.getInstance();

    // Constructor
    public TripStateChoosePaymentType(TripContext tripContext) {
        super (tripContext, Status.ChoosePaymentType);
    }

    public void selectPersonPaying(){
        Scanner scanner = new Scanner(System.in);

        // Prints Package Options
        System.out.println("ID\t|Name");
        System.out.println("-----------------------------------------");
        for (int p = 0; p < payingPersonOptions.size(); p++) {
            System.out.println(payingPersonOptions.get(p).toString());
        }

        System.out.println();
        System.out.println("Enter ID number of person from list");
        boolean selectPersonPaying = true;
        int personID = 0;

        while (selectPersonPaying) {
            String userInput = scanner.nextLine().trim();

            // Check that input can be parsed
            try{
                personID = Integer.parseInt(userInput);

                // Check that num is in range
                if (personID <= 0 && personID >= payingPersonOptions.size()) {
                    System.out.println("ERROR: Invalid input. ID is incorrect.");
                }

                personID = personID - 1;
                System.out.println("Person Selected: " + payingPersonOptions.get(personID).getFirstName() + " " +
                        payingPersonOptions.get(personID).getLastName());
                getTripContext().getTrip().getBill().getPayment().setPersonPaying(payingPersonOptions.get(personID));
                selectPersonPaying = false;
            }
            catch (NumberFormatException e){
                System.out.println("ERROR: Invalid input, please enter an ID number");
            }
        }
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("-- Payment Menu --");

        // Check if user wants to exit or continue with payment details
        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter [person] to select person paying bill");
        System.out.println("\t : Enter [later] to save and return to payment details later");
        String userInput;
        while(true) {
            userInput = scanner.nextLine().trim();

            // Empty Handling
            if (userInput.isEmpty())
                System.out.println("ERROR: Please make a valid selection: [person] or [later]");

            // Save and Quit
            if (returnLater(userInput))
                return TripStateLoop.Status.Stop;

            // Continue with process
            if (userInput.toLowerCase().equals("person")) {
                selectPersonPaying();
                break;
            }
            else{
                System.out.println("ERROR: Please make a valid selection: [person] or [later]");
            }
        }

        // Check if user wants to pay by cash, check, credit, or save and quit
        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter [cash] to pay by cash");
        System.out.println("\t : Enter [check] to pay by check");
        System.out.println("\t : Enter [credit] to pay by credit card");
        System.out.println("\t : Enter [later] to save and return to payment details later");

        // Navigates to new state based off user input
        while (true){
            userInput = new String();

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
