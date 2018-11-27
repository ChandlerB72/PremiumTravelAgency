import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Main component of PTS software
 * Holds all the trip information
 */
public class Trip {

    private long orderId; /*< holds the unique ID for the trip */
    private Date bookedOn; /*< holds the date the trip was booked on*/
    private List<String> destinations; /*< holds a list of all destinations */
    private List<Person> travelers; /*< Holds a list of all travelers */
    private List<Package> packages; /*< Holds a list of all packages */
    private List<Payment> payments; /*< Holds a list of all payments */
    private TravelAgent travelAgent; /*< Holds the travel agent person */
    private String thankYou; /*< Holds thankYou string */
    private Bill bill; /*< Holds bill object */
    private TripState.Status tripStateStatus; /*< Holds Current State of Trip Object */

    //! Constructor
    public Trip() {
        tripStateStatus = TripState.Status.Create;
        destinations = new ArrayList<>();
        travelers = new ArrayList<>();
        packages = new ArrayList<>();
        bill = new Bill();
    }

    //! Getters and Setters
    public long getOrderId() {
        return orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    //! Getters and Setters
    public Date getBookedOn() {
        return bookedOn;
    }
    public void setBookedOn(Date bookedOn) {
        this.bookedOn = bookedOn;
    }

    //! Getters and Setters
    public List<String> getDestinations() {
        return destinations;
    }
    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }

    //! Getters and Setters
    public List<Person> getTravelers() {
        return travelers;
    }
    public void setTravelers(List<Person> travelers) {
        this.travelers = travelers;
    }

    //! Getters and Setters
    public List<Package> getPackages() {
        return packages;
    }
    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    //! Getters and Setters
    public TravelAgent getTravelAgent() {
        return travelAgent;
    }
    public void setTravelAgent(TravelAgent travelAgent) {
        this.travelAgent = travelAgent;
    }

    //! Getters and Setters
    public String getThankYou() {
        return thankYou;
    }
    public void setThankYou(String thankYou) {
        this.thankYou = thankYou;
    }

    //! Getters and Setters
    public Bill getBill() {
        return bill;
    }
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    //! Getters and Setters
    public TripState.Status getTripStateStatus() {
        return tripStateStatus;
    }
    public void setTripStateStatus(TripState.Status tripStateStatus) {
        this.tripStateStatus = tripStateStatus;
    }
}
