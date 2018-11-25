import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Select Travel Agent

        /////////////////////////////////////////////////////////////////////
        TripStateLoop tripStateLoop = new TripStateLoop();
        Trip trip;

        try {
            trip = tripStateLoop.execute();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return;
        }

        while (true)
        {
            showItinerary(trip);

            System.out.println();
            System.out.println("Simulate trip reload to correct state? [yes]");

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

    /// <summary>
    ///     Displays itinerary, if possible
    /// </summary>
    /// <param name="trip"></param>
    private static void showItinerary(Trip trip)
    {
        if (ItineraryFactory.TripCanProduceItinerary(trip))
        {
            System.out.println("Show itinerary? [yes]");
            if (!scanner.nextLine().toLowerCase().trim().equals("yes")) return;

            String itinerary;

            try{
                itinerary = ItineraryFactory.get(trip);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return;
            }

            System.out.println(itinerary);
            return;
        }
        System.out.println();
        System.out.println("---------------------------------------------------------");
        System.out.println("Trip #" + trip.getOrderId() + " Incomplete - Itinerary Unavailable");
        System.out.println("Current state : " + trip.getTripStateStatus());
        System.out.println("---------------------------------------------------------");
    }

}
