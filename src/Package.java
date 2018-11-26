import java.math.BigDecimal;

/**
 * Package is the object that holds all of the
 * travel information for the Trip object.
 */
public class Package {

    private int packageID; /*< specific package ID*/
    private BigDecimal price; /*< dollar amount of package*/
    private int hoursOfTravelTime; /*< Hours of travel time*/
    private String travelTo; /*< Destination to travel to*/
    private String travelFrom; /*< Destination to travel from*/

    //! Constructor
    public Package(int packageID, BigDecimal price, int hoursOfTravelTime, String travelFrom, String travelTo) {
        this.packageID = packageID;
        this.price = price;
        this.hoursOfTravelTime = hoursOfTravelTime;
        this.travelTo = travelTo;
        this.travelFrom = travelFrom;
    }

    //! Getter and Setter
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //! Getter and Setter
    public int getHoursOfTravelTime() {
        return hoursOfTravelTime;
    }
    public void setHoursOfTravelTime(int hoursOfTravelTime) {
        this.hoursOfTravelTime = hoursOfTravelTime;
    }

    //! Getter and Setter
    public String getTravelTo() {
        return travelTo;
    }
    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    //! Getter and Setter
    public String getTravelFrom() {
        return travelFrom;
    }
    public void setTravelFrom(String travelFrom) {
        this.travelFrom = travelFrom;
    }

    /**
     * @return Package information via String
     */
    @Override
    public String toString() {
        return packageID + "\t$" + price + "\t" + hoursOfTravelTime + "\t" + travelFrom + " to " + travelTo;
    }
}
