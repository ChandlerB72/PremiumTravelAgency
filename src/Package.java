public class Package {

    // Variables
    private int packageID;
    private double price;
    private int hoursOfTravelTime;
    private String travelTo;
    private String travelFrom;

    // Constructor
    public Package(String travelTo, String travelFrom) {
        this.travelTo = travelTo;
        this.travelFrom = travelFrom;
    }

    public Package(int packageID, double price, int hoursOfTravelTime, String travelTo, String travelFrom) {
        this.packageID = packageID;
        this.price = price;
        this.hoursOfTravelTime = hoursOfTravelTime;
        this.travelTo = travelTo;
        this.travelFrom = travelFrom;
    }

    // Getters and Setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        return packageID + "\t$" + price + "\t" + hoursOfTravelTime + "\t" + travelTo + " to " + travelFrom;
    }
}
