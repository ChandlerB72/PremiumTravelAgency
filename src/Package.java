import java.math.BigDecimal;

public class Package {

    // Variables
    private int packageID;
    private BigDecimal price;
    private int hoursOfTravelTime;
    private String travelTo;
    private String travelFrom;

    // Constructor
    public Package(String travelTo, String travelFrom) {
        this.travelTo = travelTo;
        this.travelFrom = travelFrom;
    }

    public Package(int packageID, BigDecimal price, int hoursOfTravelTime, String travelFrom, String travelTo) {
        this.packageID = packageID;
        this.price = price;
        this.hoursOfTravelTime = hoursOfTravelTime;
        this.travelTo = travelTo;
        this.travelFrom = travelFrom;
    }

    // Getters and Setters
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getHoursOfTravelTime() {
        return hoursOfTravelTime;
    }

    public void setHoursOfTravelTime(int hoursOfTravelTime) {
        this.hoursOfTravelTime = hoursOfTravelTime;
    }

    public String getTravelTo() {
        return travelTo;
    }

    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    public String getTravelFrom() {
        return travelFrom;
    }

    public void setTravelFrom(String travelFrom) {
        this.travelFrom = travelFrom;
    }

    @Override
    public String toString() {
        return packageID + "\t$" + price + "\t" + hoursOfTravelTime + "\t" + travelFrom + " to " + travelTo;
    }
}
