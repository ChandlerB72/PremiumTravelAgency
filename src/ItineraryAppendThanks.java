/**
 * Responsible for adding Thanks to itinerary
 */
public class ItineraryAppendThanks extends ItineraryDecorator{

    //! Constructor
    public ItineraryAppendThanks(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }


    /**
     * @return Thanks Component of Itinerary
     */
    @Override
    public String output() {
        StringBuilder toOutput = new StringBuilder(super.output());

        toOutput.append("THANKS");

        toOutput.append(System.lineSeparator());
        toOutput.append(System.lineSeparator());

        toOutput.append(getTrip().getThankYou());

        toOutput.append(System.lineSeparator());

        return toOutput.toString();
    }
}
