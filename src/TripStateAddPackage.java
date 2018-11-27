import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * State of trip to add Packages
 */
public class TripStateAddPackage extends TripState{
    private List<Package> packageOptions = LoadPackages.getInstance(); /*< Singleton loaded list */

    //! Constructor
    public TripStateAddPackage(TripContext tripContext) {
        super(tripContext, Status.AddPackages);
    }

    /**
     * @param userInput user input from the execute method
     * @return true if not done entering data
     */
    public boolean continueEnteringPackages(String userInput){
        boolean done = userInput.equals("done");

        if (done && !getTripContext().getTrip().getPackages().isEmpty()){
            System.out.println("-- Packages Selected | " +
                    getTripContext().getTrip().getPackages().size() + " entered --");
        }

        return !done;
    }

    /**
     * @param userInput user input from the execute method
     * @return true if user input passes all data validation
     */
    public boolean isPackageValid(String userInput){
        int packageID;

        // Check if input is empty
        if (userInput.isEmpty()){
            System.out.println("ERROR: Blank input detected");
            return false;
        }

        // Check that input can be parsed
        try{
            packageID = Integer.parseInt(userInput);
            packageID = packageID - 1;
        }
        catch (NumberFormatException e){
            System.out.println("ERROR: Invalid input, please choose packageID");
            return false;
        }

        // Check that num is in range
        if(packageID < 0 && packageID >= packageOptions.size()){
            System.out.println("ERROR: Invalid input. ID is incorrect.");
            return false;
        }

        // Check for duplicate entry
        boolean isDuplicate = getTripContext().getTrip().getPackages().contains(packageOptions.get(packageID));
        if (isDuplicate) {
            System.out.println("ERROR: You can't enter the same package twice");
            return false;
        }
        return true;
    }


    /**
     * @return true/false if the list is empty
     */
    public boolean isPackageListValid(){
        if (getTripContext().getTrip().getTravelers().isEmpty()){
            System.out.println("ERROR: No packages. At least one package required");
            return false;
        }
        return true;
    }

    /**
     * The main execution of this trip state
     * @return The new status after running through this state
     */
    @Override
    public TripStateLoop.Status execute() {

        List<Package> selectedPackages = new ArrayList<>();  /*< List of people selected as travelers*/
        Scanner scanner=  new Scanner(System.in);

        System.out.println();
        System.out.println("-- Package Menu --");

        // Prints Package Options
        System.out.println("ID\tPrice\tHrs\tDeparture to Arrival");
        System.out.println("-----------------------------------------");
        for (int p = 0; p < packageOptions.size(); p++) {
            System.out.println(packageOptions.get(p).toString());
        }

        // User Prompt
        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter ID of package from list");
        System.out.println("\t : Enter [later] to save and return to add package later");


        boolean getPackages = true;
        while (getPackages) {
            String userInput =  scanner.nextLine().trim();

            // Save and Exit if "later"
            if (returnLater(userInput)) {
                return TripStateLoop.Status.Stop;
                // If later, save trip via write factory and json strategy using serialization and go to UI flow 2
            }

            // Data Validation
            if (continueEnteringPackages(userInput)) {
                if (isPackageValid(userInput)) {
                    selectedPackages.add(packageOptions.get(Integer.parseInt(userInput)-1));
                    getTripContext().getTrip().setPackages(selectedPackages);
                    System.out.println("Package #" + userInput + " Added! - (" +
                            packageOptions.get(Integer.parseInt(userInput)-1).getTravelFrom() + " to " +
                            packageOptions.get(Integer.parseInt(userInput)-1).getTravelTo() + ")");
                }
            }
            else {
                getPackages = !isPackageListValid();
            }
        }

        BigDecimal price = new BigDecimal(0);
        for (int p = 0; p < getTripContext().getTrip().getPackages().size(); p++) {
            price = price.add(getTripContext().getTrip().getPackages().get(p).getPrice());
        }
        // Multiply Calculated Price by Number of Travelers
        getTripContext().getTrip().getBill().setPrice(price.multiply(new BigDecimal(getTripContext().getTrip().getTravelers().size())));

        getTripContext().changeState(new TripStateChoosePaymentType(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}
