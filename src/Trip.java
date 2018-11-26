import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trip {

    //Variables
    private long orderId;
    private Date bookedOn;
    private List<String> destinations;
    private List<Person> travelers;
    private List<Package> packages;
    private String thankYou;
    private Bill bill;
    private TripState.Status tripStateStatus;   // Holds Current State of Trip Object

    // Constructors
    public Trip() {
        tripStateStatus = TripState.Status.Create;
        destinations = new ArrayList<String>();
        travelers = new ArrayList<Person>();
        packages = new ArrayList<Package>();
        bill = new Bill();
    }

    // Getters and Setters
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(Date bookedOn) {
        this.bookedOn = bookedOn;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }

    public List<Person> getTravelers() {
        return travelers;
    }

    public void setTravelers(List<Person> travelers) {
        this.travelers = travelers;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public String getThankYou() {
        return thankYou;
    }

    public void setThankYou(String thankYou) {
        this.thankYou = thankYou;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public TripState.Status getTripStateStatus() {
        return tripStateStatus;
    }

    public void setTripStateStatus(TripState.Status tripStateStatus) {
        this.tripStateStatus = tripStateStatus;
    }
}
