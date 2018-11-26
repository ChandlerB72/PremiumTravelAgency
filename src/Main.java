import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Initializing necessary objects
        TripStateLoop tripStateLoop = new TripStateLoop();
        Trip trip;

        // Try to start normal process flow, if not throw an error
        try {
            trip = tripStateLoop.execute();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return;
        }


        while (true)
        {
            // Attempt to showItinerary, if state
            showItinerary(trip);

            System.out.println();
            System.out.println("Simulate trip reload to correct state? [yes]");

            // Loading simulation - Restart normal process flow, if not throw an error
            if (scanner.nextLine().toLowerCase().trim().equals("yes")){
                try {
                    tripStateLoop.execute(trip);
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    break;
                }
            }else{
                break;
            }
        }
    }

    // Makes necessary function calls to prepare itinerary if trip is valid
    private static void showItinerary(Trip trip)
    {
        // Validates Trip and Trip Status is able to produce Itinerary
        if (ItineraryFactory.TripCanProduceItinerary(trip)) {
            System.out.println("Show itinerary? [yes]");
            if (!scanner.nextLine().toLowerCase().trim().equals("yes")) return;

            // Initializes itinerary as a string
            String itinerary;

            // Start building the itinerary from trip components, if not throw an error
            try{
                itinerary = ItineraryFactory.get(trip);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return;
            }

            // Displays itinerary
            System.out.println(itinerary);
            return;
        }

        // If trip preconditions aren't met, output to user and jump back to main
        System.out.println();
        System.out.println("---------------------------------------------------------");
        System.out.println("Trip #" + trip.getOrderId() + " Incomplete - Itinerary Unavailable");
        System.out.println("Current state : " + trip.getTripStateStatus());
        System.out.println("---------------------------------------------------------");
    }

}
