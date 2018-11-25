import java.util.List;
import java.util.Scanner;

public class TripStateAddPackages extends TripState {

    // Constructor
    public TripStateAddPackages(TripContext tripContext) {
        super(tripContext, Status.AddPackages);
    }

    // Methods
    public void listLocations() {
//        System.out.println(getTripContext().getTrip().getPackage);
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-- Select Package Menu --");

        // Get Packages from Singleton
        List<Package> packageList = LoadPackages.getInstance();

        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter departure destination from list");
        System.out.println("\t : Enter [later] to save and return to add package later");



        boolean getPackages = false;
        while (!getPackages) {
            String userInput = scanner.nextLine().trim();

            if (returnLater(userInput)) {
                return TripStateLoop.Status.Stop;
                // If later, save trip via write factory and json strategy using serialization and go to UI flow 2
            }
        }

        getTripContext().changeState(new TripStateAddDestinations(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}
