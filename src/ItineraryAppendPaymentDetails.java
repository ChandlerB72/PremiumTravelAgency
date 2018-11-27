/**
 * Responsible for adding Payment Details to itinerary
 */
public class ItineraryAppendPaymentDetails extends ItineraryDecorator {

    //! Constructor
    public ItineraryAppendPaymentDetails(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    /**
     * @return Payment details Component of Itinerary
     */
    @Override
    public String output() {
        String toOutput = super.output();

        toOutput = toOutput + "\t\tPAYMENT DETAILS";

        toOutput = toOutput + (System.lineSeparator());
        toOutput = toOutput + (System.lineSeparator());

        for (int i = 0; i < getTrip().getPayments().size(); i++) {
            toOutput = toOutput + getTrip().getPayments().get(i).Describe() + System.lineSeparator();
        }

        return toOutput;
    }
}
