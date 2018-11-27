import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * State of trip to add Packages
 */
public class TripStateAddTraveler extends TripState{
    private List<Person> personOptions = LoadPerson.getInstance(); /*< Singleton loaded list */

    //! Constructor
    public TripStateAddTraveler(TripContext tripContext) {
        super(tripContext, Status.AddTravelers);
    }

    /**
     * @param userInput user input from the execute method
     * @return true if not done entering data
     */
    public boolean continueEnteringTravelers(String userInput){
        boolean done = userInput.equals("done");

        if (done && !getTripContext().getTrip().getTravelers().isEmpty()){
            System.out.println("-- Traveler Selected | " +
                    getTripContext().getTrip().getTravelers().size() + " entered --");
        }

        return !done;
    }

    /**
     * @param userInput user input from the execute method
     * @return true if user input passes all data validation
     */
    public boolean isTravelerValid(String userInput){
        int personID;

        // Check if input is empty
        if (userInput.isEmpty()){
            System.out.println("ERROR: Blank input detected");
            return false;
        }

        // Check that input can be parsed
        try{
            personID = Integer.parseInt(userInput);
            personID = personID - 1;
        }
        catch (NumberFormatException e){
            System.out.println("ERROR: Invalid input. ID is incorrect.");
            return false;
        }

        // Check that num is in range
        if (personID < 0 || personID >= personOptions.size()){
            System.out.println("ERROR: Invalid input. ID is incorrect.");
            return false;
        }

        // Check for duplicate entry
        boolean isDuplicate = getTripContext().getTrip().getTravelers().contains(personOptions.get(personID));
        if (isDuplicate) {
            System.out.println("ERROR: You can't enter the same traveler twice");
            return false;
        }

        return true;
    }

    /**
     * @return true/false if the list is empty
     */
    public boolean isTravelerListValid(){
        if (getTripContext().getTrip().getTravelers().isEmpty()){
            System.out.println("ERROR: No travelers. At least one traveler required");
            return false;
        }
        return true;
    }

    /**
     * Dispalys all current travelers
     */
    public void showTravelers(){
        if (getTripContext().getTrip().getTravelers().size() > 0) {
            System.out.println("Current Travelers");
            System.out.println("--------------------");
            for (int i = 0; i < getTripContext().getTrip().getTravelers().size(); i++) {
                System.out.println(getTripContext().getTrip().getTravelers().get(i).getFirstName() + " " +
                        getTripContext().getTrip().getTravelers().get(i).getLastName());
            }
        }
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    @Override
    public TripStateLoop.Status execute() {

        List<Person> selectedPersons = new ArrayList<>(); /*< List of people selected as travelers*/
        Scanner scanner =  new Scanner(System.in);

        System.out.println();
        System.out.println("-- Travelers Menu --");
        System.out.println();

        // Prints Person Options
        System.out.println("ID\t|Name");
        System.out.println("-----------------------------------------");
        for (int p = 0; p < personOptions.size(); p++) {
            System.out.println(personOptions.get(p).toString());
        }

        System.out.println("");
        showTravelers();
        System.out.println("");

        // User Prompt
        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter ID number of person from list");
        System.out.println("\t : Enter [later] to save and return to add package later");
        System.out.println("\t : Enter [done] to finish adding packages");

        boolean getTravelers = true;
        while(getTravelers) {
            String userInput =  scanner.nextLine().trim();

            // Save and Exit if "later"
            if (returnLater(userInput)) {
                return TripStateLoop.Status.Stop;
                // If later, save trip via write factory and json strategy using serialization and go to UI flow 2
            }

            // Data Validation
            if (continueEnteringTravelers(userInput)) {
                if (isTravelerValid(userInput)) {

                    // Data Validated - Add to List and Give User Confirmation
                    selectedPersons.add(personOptions.get(Integer.parseInt(userInput)-1));
                    getTripContext().getTrip().setTravelers(selectedPersons);
                    System.out.println(personOptions.get(Integer.parseInt(userInput)-1).getFirstName() + " " +
                            personOptions.get(Integer.parseInt(userInput)-1).getLastName() + " Added!");
                }
            }
            else {
                getTravelers = !isTravelerListValid();
            }
        }

        getTripContext().changeState(new TripStateAddPackage(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}
