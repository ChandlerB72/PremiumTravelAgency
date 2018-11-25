import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TripStateAddTravelers extends TripState {

    public TripStateAddTravelers(TripContext tripContext) {
        super(tripContext, Status.AddTravelers);
    }

    public boolean continueEnteringTravelers(String userInput){
        boolean done = userInput.toLowerCase().equals("done");

        if (done && !getTripContext().getTrip().getTravelers().isEmpty()){
            System.out.println("-- Travelers Completed | " +
                    getTripContext().getTrip().getTravelers().size() + " entered --");
            System.out.println();
        }
        return !done;
    }

    public boolean isTravelerValid(String userInput, List<Person> travelersList) {
        int selectedID;

        // Empty
        if (userInput.isEmpty()) {
            System.out.println("ERROR: Blank traveler is prohibited");
            return false;
        }

        // NaN
        try {
            selectedID = Integer.parseInt(userInput);
        } catch (Exception e) {
            System.out.println("ERROR: Invalid value. Enter [Done], [Later] or the Person ID");
            return false;
        }

        // Check if ID in list
        for (int traveler = 0; traveler < travelersList.size(); traveler++) {
            if (selectedID == travelersList.get(traveler).personID) //Check if ID in travelersList
                break; // If its valid, it will break out of the if and continue on
            else if (traveler == travelersList.size() - 1) {
                System.out.println("ERROR: Invalid ID. Please select a valid ID from possible travelers");
                return false;
            }
        }

            // Duplicate
            if (getTripContext().getTrip().getTravelers().contains(userInput)) {
                System.out.println("ERROR: You can't enter the same traveler twice!");
                return false;
            }

            return true;
    }

    private boolean isTravelersListValid() {
        if (getTripContext().getTrip().getTravelers().isEmpty()){
            System.out.println("ERROR: No travelers. At least one traveler required");
            return false;
        }
        return true;
    }

    public void showCurrentTravelers(List<Person> travelersList){
        if (!getTripContext().getTrip().getTravelers().isEmpty()) {
            System.out.println("Currently " + getTripContext().getTrip().getTravelers().size() + " in trip.");
            System.out.println();
            System.out.println("Current Travelers");
            System.out.println("ID  |Name");
            System.out.println("----+-----------------------");
        }

        for (int i = 0; i < getTripContext().getTrip().getTravelers().size(); i++) {
            System.out.println(getTripContext().getTrip().getTravelers().get(i) + "\t|" +
                    travelersList.get(i).getFirstName() + " " + travelersList.get(i).getLastName()); // Not the best way to do this...but I'm working with what I got
        }
    }

    @Override
    public TripStateLoop.Status execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-- Add Travelers Menu --");

        // Get Travelers from Singleton
        List<Person> travelerList = LoadPerson.getInstance();

        System.out.println();
        System.out.println("ID  |Name");
        System.out.println("----+-----------------------");
        for (int i = 0; i < travelerList.size(); i++) {
            System.out.println(travelerList.get(i).toString());
        }

        System.out.println();
        showCurrentTravelers(travelerList);
        System.out.println();

        System.out.println("Please select one of the following: ");
        System.out.println("\t : Enter traveler ID");
        System.out.println("\t : Enter [done] to finish adding Travelers");
        System.out.println("\t : Enter [later] to save and return to add travelers later");


        boolean getTravelers = false;
        while (!getTravelers) {
            String userInput = scanner.nextLine().trim();

            if (returnLater(userInput)) {
                return TripStateLoop.Status.Stop;
                // If later, save trip via write factory and json strategy using serialization and go to UI flow 2
            }

            if (continueEnteringTravelers(userInput)){
                if (isTravelerValid(userInput, travelerList)) {
                    getTripContext().getTrip().getTravelers().add(userInput);
                    System.out.println(travelerList.get(Integer.parseInt(userInput)).getFirstName() + " "
                            + travelerList.get(Integer.parseInt(userInput)).getLastName() + " Added!");
                }
            }else {
                getTravelers = isTravelersListValid();
            }
        }

        getTripContext().changeState(new TripStateAddDestinations(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}
