import java.util.List;
import java.util.Scanner;

/**
 * State of trip to add Packages
 */
public class TripStateAddTravelAgent extends TripState{
    private List<TravelAgent> travelAgentsOptions = LoadTravelAgents.getInstance(); /*< Singleton loaded list */

    //! Constructor
    public TripStateAddTravelAgent(TripContext tripContext) {
        super(tripContext, Status.AddTravelAgent);
    }

    /**
     * Method to allow user to select the person who is paying
     */
    public void selectTravelAgent(String userInput) throws IndexOutOfBoundsException{
        Scanner scanner = new Scanner(System.in);

        boolean selectTravelAgent = true;
        int personID = 0;

        while (selectTravelAgent) {

            // Check that input can be parsed
            try{
                personID = Integer.parseInt(userInput);
                personID = personID - 1;

                // Check that num is in range
                if (personID < 0 || personID >= travelAgentsOptions.size()) {
                    System.out.println("ERROR: Invalid input. ID is out of bounds.");
                    userInput = scanner.nextLine().trim();
                    continue;
                }

                System.out.println("Travel Agent Selected: " + travelAgentsOptions.get(personID).getFirstName() + " " +
                        travelAgentsOptions.get(personID).getLastName());
                getTripContext().getTrip().setTravelAgent(travelAgentsOptions.get(personID));
                selectTravelAgent = false;
            }
            catch (NumberFormatException e){
                System.out.println("ERROR: Invalid input. ID is incorrect.");
                userInput = scanner.nextLine().trim();
                continue;
            }
        }
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-- Travel Agent Selection Menu --");
        System.out.println();

        // Prints Person Options
        System.out.println("ID\t|Name");
        System.out.println("-----------------------------------------");
        for (int t = 0; t < travelAgentsOptions.size(); t++) {
            System.out.println(travelAgentsOptions.get(t).toString());
        }

        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter ID number of person from list");
        System.out.println("\t : Enter [later] to save and return to Thank You later");

        while (true) {
            String userInput = "";
            userInput = scanner.nextLine().trim();

            // Save and Exit if "later"
            if (returnLater(userInput)) {
                return TripStateLoop.Status.Stop;
                // If later, save trip via write factory and json strategy using serialization and go to UI flow 2
            }

            selectTravelAgent(userInput);
            getTripContext().changeState(new TripStateAddTraveler(getTripContext()));
            return TripStateLoop.Status.Continue;
        }
    }
}
