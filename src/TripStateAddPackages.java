import java.util.Scanner;

public class TripStateAddPackages extends TripState {

    // Constructor
    public TripStateAddPackages(TripContext tripContext) {
        super(tripContext, Status.AddPackages);
    }

    // Methods
    public void getPackages() {
        // Should load travelers from json and print
        // Singleton
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-- Add Travelers Menu --");
        getPackages();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter travelers");
        System.out.println("\t : Enter [done] to finish adding Travelers");
        System.out.println("\t : Enter [later] to save and return to add travelers later");

        boolean getPackages = false;
        while (!getPackages) {
            String userInput = scanner.nextLine().trim();

            if (returnLater(userInput))
                return TripStateLoop.Status.Stop;
            // If later, save trip via write factory and json strategy using serialization and go to UI flow 2
        }
        return TripStateLoop.Status.Continue;
    }
}
