public class ItineraryAppendBookingDetails extends ItineraryDecorator {

    // Constructor

    public ItineraryAppendBookingDetails(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    @Override
    public String output() {
        String toOutput = super.output();

        toOutput = toOutput + "Order # : " + getTrip().getOrderId() + System.lineSeparator();
        toOutput = toOutput + "Booked : " + getTrip().getBookedOn() + System.lineSeparator();
        toOutput = toOutput + "Payment : " + getTrip().getPayment() + System.lineSeparator();

        return toOutput;
    }
}
