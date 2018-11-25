public class ItineraryAppendBookingDetails extends ItineraryDecorator {

    // Constructor

    public ItineraryAppendBookingDetails(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    @Override
    public String output() {
        String toOutput = super.output();

        toOutput = toOutput + "BOOKING DETAILS";

        toOutput = toOutput + (System.lineSeparator());
        toOutput = toOutput + (System.lineSeparator());

        toOutput = toOutput + "Order # : " + getTrip().getOrderId() + System.lineSeparator();
        toOutput = toOutput + "Booked : " + getTrip().getBookedOn() + System.lineSeparator();
        toOutput = toOutput + "Price : $" + getTrip().getBill().getPrice() + System.lineSeparator();

        return toOutput;
    }
}
