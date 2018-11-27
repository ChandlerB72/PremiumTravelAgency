import java.util.List;
import java.util.Scanner;

/**
 * Abstract class that all states extend
 */
public abstract class TripState {

    private TripContext tripContext; /*< Holds the trip context object pertaining to the trip*/

    //! Constructor
    public TripState(TripContext tripContext, Status tripStateStatus) {
        this.tripContext = tripContext;

        if (tripContext.getTrip() != null)
            tripContext.getTrip().setTripStateStatus(tripStateStatus);
    }

    //! Getters and Setters
    public TripContext getTripContext() {
        return tripContext;
    }
    public void setTripContext(TripContext tripContext) {
        this.tripContext = tripContext;
    }


    /**
     * @return Abstract class that every state will implement
     */
    public abstract TripStateLoop.Status execute();


    /**
     * @param answer User input from state
     * @return true if answer is "later", false otherwise
     */
    protected boolean returnLater(String answer){
        boolean returnLater = answer.toLowerCase().equals("later");

        if (returnLater) {
            System.out.println();// SAVE TRIP HERE?
            System.out.println("-- Trip Saved to Be Completed Later --");
        }

        return returnLater;
    }


    /**
     * @param str User input from state
     * @return true/false if number is numeric
     */
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Method to allow user to select the person who is paying
     */
    public Person selectPersonPaying(){
        List<Person> payingPersonOptions = LoadPerson.getInstance(); /*< Singleton loaded list */
        Scanner scanner = new Scanner(System.in);

        // Prints Package Options
        System.out.println("ID\t|Name");
        System.out.println("-----------------------------------------");
        for (int p = 0; p < payingPersonOptions.size(); p++) {
            System.out.println(payingPersonOptions.get(p).toString());
        }

        System.out.println();
        System.out.println("Enter ID number of person from list");
        int personID;

        while (true) {
            String userInput = scanner.nextLine().trim();

            // Check that input can be parsed
            try{
                personID = Integer.parseInt(userInput);

                // Check that num is in range
                if (personID < 0 || personID >= payingPersonOptions.size()) {
                    System.out.println("ERROR: Invalid input. ID is incorrect.");
                }
                else {
                    personID = personID - 1;
                    System.out.println("Selected: " + payingPersonOptions.get(personID).getFirstName() + " " +
                            payingPersonOptions.get(personID).getLastName());
                    return payingPersonOptions.get(personID);
                }
            }
            catch (NumberFormatException e){
                System.out.println("ERROR: Invalid input, please enter an ID number");
            }
        }
    }

    /**
     * Enum that holds all possible states of trip
     */
    public enum Status {
        Create,
        AddTravelAgent,
        AddTravelers,
        AddPackages,
        ChoosePaymentType,
        PayCash,
        PayCheck,
        PayCreditCard,
        AddThankYou,
        Complete
    }
}
