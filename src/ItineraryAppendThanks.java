public class ItineraryAppendThanks extends ItineraryDecorator{

    // Constructor
    public ItineraryAppendThanks(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    // Methods
    @Override
    public String output() {
        StringBuilder toOutput = new StringBuilder(super.output());

        toOutput.append("Thanks!");

        toOutput.append(System.lineSeparator());
        toOutput.append(System.lineSeparator());

        toOutput.append(getTrip().getThankYou());

        toOutput.append(System.lineSeparator());

        return toOutput.toString();
    }
}
