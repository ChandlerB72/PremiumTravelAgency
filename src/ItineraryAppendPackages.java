/**
 * Responsible for adding Packages to itinerary
 */
public class ItineraryAppendPackages extends ItineraryDecorator {

    //! Constructor
    public ItineraryAppendPackages(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }


    /**
     * @return Packages Component of Itinerary
     */
    @Override
    public String output() {
        StringBuilder toOutput = new StringBuilder(super.output());

        toOutput.append("\t\tPACKAGES");

        toOutput.append(System.lineSeparator());
        toOutput.append(System.lineSeparator());

        for (int p = 0; p < getTrip().getPackages().size(); p++) {
            toOutput.append(p + 1);
            toOutput.append(". ");
            toOutput.append(getTrip().getPackages().get(p).getTravelFrom() + " to " +
                    getTrip().getPackages().get(p).getTravelTo());
            toOutput.append(System.lineSeparator());
        }

        return toOutput.toString();
    }
}
