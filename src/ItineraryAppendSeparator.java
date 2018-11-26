/**
 * Responsible for adding Separator to itinerary
 */
public class ItineraryAppendSeparator extends ItineraryDecorator{

    //! Constructor
    public ItineraryAppendSeparator(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }


    /**
     * @return Separator Component of Itinerary
     */
    @Override
    public String output() {
        StringBuilder toOutput = new StringBuilder(super.output());
        toOutput.append(System.lineSeparator());
        toOutput.append("--------------------------------------------");
        toOutput.append(System.lineSeparator());
        return toOutput.toString();
    }
}
