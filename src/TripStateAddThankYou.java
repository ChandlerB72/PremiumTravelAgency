import java.util.Scanner;

public class TripStateAddThankYou extends TripState{

    // Constructor
    public TripStateAddThankYou(TripContext tripContext) {
        super(tripContext, Status.AddThankYou);
    }

    // Methods
    private boolean isThankYouValid(String thankYou){
        if (thankYou.isEmpty()){
            System.out.println("-- Error: Thank you can't be empty --");
            return false;
        }
        if (thankYou.length() < 5) {
            System.out.println("-- Error: Thank you must be 5 characters or more --");
            return false;
        }
        return true;
    }

    @Override
    public TripStateLoop.Status execute() {
        System.out.println();
        System.out.println("-- Thank You Creation Menu --");
        System.out.println();
        System.out.println("Please select one of the following: ");
        System.out.println("\t : Thank you message (5 characters or more)");
        System.out.println("\t : Enter [later] to save and return to Thank You later");

        Scanner scanner = new Scanner(System.in);
        boolean thanked = false;
        String userInput = null;

        while (!thanked) {
            userInput = scanner.nextLine().trim();

            if (returnLater(userInput)){
                return TripStateLoop.Status.Stop;
            }

            thanked = isThankYouValid(userInput);
        }

        getTripContext().getTrip().setThankYou(userInput);
        getTripContext().changeState(new TripStateComplete(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}
