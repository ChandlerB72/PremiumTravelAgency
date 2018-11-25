import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripStateAddPackage extends TripState{
    private List<Package> packageOptions = LoadPackages.getInstance();

    public TripStateAddPackage(TripContext tripContext) {
        super(tripContext, Status.AddPackages);
    }

    public boolean continueEnteringPackages(String userInput){
        boolean done = userInput.equals("done");

        if (done && !getTripContext().getTrip().getPackages().isEmpty()){
            System.out.println("-- Packages Selected | " +
                    getTripContext().getTrip().getPackages().size() + " entered --");
        }

        return !done;
    }

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
        }
        catch (NumberFormatException e){
            System.out.println("ERROR: Invalid input, please choose packageID");
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

    public boolean isPackageListValid(){
        if (getTripContext().getTrip().getTravelers().isEmpty()){
            System.out.println("ERROR: No packages. At least one package required");
            return false;
        }
        return true;
    }

    @Override
    public TripStateLoop.Status execute() {
        // Variables
        List<Package> selectedPackages = new ArrayList<>();
        Scanner scanner=  new Scanner(System.in);

        // Prints Package Options
        System.out.println("ID\tPrice\tHrs\tDeparture to Arrival");
        System.out.println("-----------------------------------------");
        for (int p = 0; p < packageOptions.size(); p++) {
            System.out.println(packageOptions.get(p).toString());
        }

        // User Prompt
        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter packageID from list");
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
                    selectedPackages.add(packageOptions.get(Integer.parseInt(userInput)));
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

        getTripContext().changeState(new TripStateChoosePaymentType(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}