/**
 * Responsible for adding Booking Details to itinerary
 */
public class ItineraryAppendBookingDetails extends ItineraryDecorator {

    //! Constructor
    public ItineraryAppendBookingDetails(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    /**
     * @return Booking Details Component of Itinerary
     */
    @Override
    public String output() {
        String toOutput = super.output();

        toOutput = toOutput + "\t\t\t\tBOOKING DETAILS";

        toOutput = toOutput + (System.lineSeparator());
        toOutput = toOutput + (System.lineSeparator());

        toOutput = toOutput + "Order : #" + getTrip().getOrderId() + System.lineSeparator();
        toOutput = toOutput + "Booked : " + getTrip().getBookedOn() + System.lineSeparator();
        toOutput = toOutput + "Price : $" + getTrip().getBill().getPrice() + System.lineSeparator();
        toOutput = toOutput + "Travel Agent: " + getTrip().getTravelAgent().getFirstName() + " " +
                getTrip().getTravelAgent().getLastName() + System.lineSeparator();

        return toOutput;
    }
}
