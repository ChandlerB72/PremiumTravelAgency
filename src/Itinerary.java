/**
 * Initializes Itinerary object to be decorated
 */
public class Itinerary implements iItineraryComponent{

    private Trip trip; /*!< Holds trip object >*/

    //! Constructor
    public Itinerary(Trip trip) {
        this.trip = trip;
    }

    /**
     * @return Returns this.trip
     */
    @Override
    public Trip getTrip() {
        return trip;
    }

    /**
     * @return Returns empty string
     */
    @Override
    public String output() {
        return new String();
    }
}
