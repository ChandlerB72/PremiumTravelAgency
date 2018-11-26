/**
 * Responsible for adding Travelers to itinerary
 */
public class ItineraryAppendTravelers extends ItineraryDecorator{

    //! Constructor
    public ItineraryAppendTravelers(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }


    /**
     * @return Travelers Component of Itinerary
     */
    @Override
    public String output() {
        StringBuilder toOutput = new StringBuilder(super.output());

        toOutput.append("TRAVELERS");

        toOutput.append(System.lineSeparator());
        toOutput.append(System.lineSeparator());

        for (int traveler = 0; traveler < getTrip().getTravelers().size(); traveler++) {
            toOutput.append(traveler + 1);
            toOutput.append(". ");
            toOutput.append(getTrip().getTravelers().get(traveler).getFirstName() + " " +
                    getTrip().getTravelers().get(traveler).getLastName());
            toOutput.append(System.lineSeparator());
        }

        return toOutput.toString();
    }
}
