//import java.util.*;
//
//public class TripStateAddPackages extends TripState {
//
//    // Constructor
//    public TripStateAddPackages(TripContext tripContext) {
//        super(tripContext, Status.AddPackages);
//    }
//
//    // Method to show all the possible places for arrival/departure
//    public void showPackages(List<Package> packageList) {
//
//        System.out.println("DESTINATIONS");
//
//        // Print From Destinations
//        List<String> duplicatedListOfPlaces = new ArrayList<>();
//        for (int p = 0; p < packageList.size(); p++) {
//            duplicatedListOfPlaces.add(packageList.get(p).getTravelFrom());
//        }
//
//        // Remove Duplicates
//        Set<String> setListOfPlaces = new TreeSet<>(duplicatedListOfPlaces);
//        List<String> listOfPlaces = new ArrayList<>(setListOfPlaces);
//
//        // Printing List
//        for (int place = 0; place < listOfPlaces.size(); place++) {
//            System.out.println(listOfPlaces.get(place));
//        }
//    }
//
//    // Method to check for "done" to end loop
//    public boolean continueEnteringPackages(String userInput) {
//        boolean done = userInput.toLowerCase().equals("done");
//
//        if (done && !getTripContext().getTrip().getPackages().isEmpty()) {
//            System.out.println("-- Packages Completed | " +
//                    getTripContext().getTrip().getPackages().size() + " entered --");
//        }
//
//        return !done;
//    }
//
//    // Method to show all packages currently saved
//    public void showCurrentPackages(){
//        if (!getTripContext().getTrip().getPackages().isEmpty())
//            System.out.println("Currently " + getTripContext().getTrip().getPackages().size() + " in trip.");
//
//        for (int p = 0; p < getTripContext().getTrip().getPackages().size(); p++) {
//            System.out.println();
//        }
//    }
//
//    // Method to validate departure input from user
//    public boolean isDepartureValid(String userInput, List<Package> packageList){
//
//        // Empty
//        if (userInput.isEmpty()) {
//            System.out.println("ERROR: Blank Location is invalid");
//            return false;
//        }
//
//        // Loop Over List to Ensure Name is present
//        for (int location = 0; location < packageList.size(); location++) {
//
//            // String Comparison Input vs List
//            if ((packageList.get(location).getTravelFrom().equals(userInput))){
//                break; // If its valid, it will break out of the if and continue on
//            }
//
//            if (location == packageList.size()-1){ // Compare length of list to iteration
//                System.out.println("ERROR: Invalid name. Please select a valid name from possible travelers");
//                return false;
//            }
//        }
//
//        // Duplicates
//        boolean isDuplicate = getTripContext().getTrip().getTravelers().contains(userInput);
//        if (isDuplicate) {
//            System.out.println("ERROR: You can't use the same destination twice");
//            return false;
//        }
//
//        return true;
//    }
//
//    // Method to validate arrival input from user
//    public boolean isArrivalValid(String departure, String arrival, List<Package> packageList){
//
//        // Empty
//        if (arrival.isEmpty()) {
//            System.out.println("ERROR: Blank Location is invalid");
//            return false;
//        }
//
//        // Loop Over List to Ensure Name is present
//        for (int location = 0; location < packageList.size(); location++) {
//
//            // String Comparison Input vs List
//            if ((packageList.get(location).getTravelFrom().equals(arrival))){
//                break; // If its valid, it will break out of the if and continue on
//            }
//
//            if (location == packageList.size()-1){ // Compare length of list to iteration
//                System.out.println("ERROR: Invalid name. Please select a valid name from possible travelers");
//                return false;
//            }
//        }
//
//        // Ensure Arrival and Departure are not equal
//        if (departure == arrival){
//            System.out.println("ERROR: Invalid args. Arrival and departure can't be the same place.");
//        }
//
//        // Duplicates
//        boolean isDuplicate = getTripContext().getTrip().getTravelers().contains(arrival);
//        if (isDuplicate) {
//            System.out.println("ERROR: You can't use the same destination twice");
//            return false;
//        }
//
//        return true;
//    }
//
//    @Override
//    public TripStateLoop.Status execute() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("-- Select Package Menu --");
//
//        // Get Packages from Singleton
//        List<Package> packageList = LoadPackages.getInstance();
//        showPackages(packageList);
//
//        System.out.println();
//        System.out.println("Please select one of the following: ");
//        System.out.println("\t : Enter departure destination from list");
//        System.out.println("\t : Enter [later] to save and return to add package later");
//
//        boolean getPackages = false;
//        while (!getPackages) {
//            String departure = scanner.nextLine().trim();
//
//            // Save and Exit if "later"
//            if (returnLater(departure)) {
//                return TripStateLoop.Status.Stop;
//                // If later, save trip via write factory and json strategy using serialization and go to UI flow 2
//            }
//
//            // Validating Departure Input
//            if (continueEnteringPackages(departure)){
//                if (isDepartureValid(departure, packageList)){
//
//                    System.out.println("Please enter the arrival destination from the list");
//                    String arrival = scanner.nextLine().trim();
//
//                    // Validating Arrival Input
//                    if (continueEnteringPackages(arrival)){
//                        if(isArrivalValid(departure, arrival, packageList)){
//                            getTripContext().getTrip().setPackages(new Package(departure,arrival)); // Need to figure out how to add package
//                        }
//                    }
//                }
//            }
//
//        }
//
//        getTripContext().changeState(new TripStateAddDestinations(getTripContext()));
//        return TripStateLoop.Status.Continue;
//    }
//}
