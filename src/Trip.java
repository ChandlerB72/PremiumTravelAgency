import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trip {

    //Variables
    private long orderId;
    private Date bookedOn;
    private List<String> destinations;
    private List<String> travelers;
    private String thankYou;
    private Payment payment;
    private TripState.Status tripStateStatus;   // Holds Current State of Trip Object

    // Constructors
    public Trip() {
        tripStateStatus = TripState.Status.Create;
        destinations = new ArrayList<String>();
        travelers = new ArrayList<String>();
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

    public List<String> getTravelers() {
        return travelers;
    }

    public void setTravelers(List<String> travelers) {
        this.travelers = travelers;
    }

    public String getThankYou() {
        return thankYou;
    }

    public void setThankYou(String thankYou) {
        this.thankYou = thankYou;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public TripState.Status getTripStateStatus() {
        return tripStateStatus;
    }

    public void setTripStateStatus(TripState.Status tripStateStatus) {
        this.tripStateStatus = tripStateStatus;
    }
}
