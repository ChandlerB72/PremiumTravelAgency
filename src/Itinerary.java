public class Itinerary implements iItineraryComponent{

    // Variables
    private Trip trip;

    // Constructor
    public Itinerary(Trip trip) {
        this.trip = trip;
    }

    @Override
    public Trip getTrip() {
        return trip;
    }

    @Override
    public String output() {
        return new String();
    }
}
