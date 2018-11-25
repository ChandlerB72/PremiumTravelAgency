public class ItineraryAppendPackages extends ItineraryDecorator {

    // Constructor
    public ItineraryAppendPackages(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    // Methods

    @Override
    public String output() {
        StringBuilder toOutput = new StringBuilder(super.output());

        toOutput.append("PACKAGES");

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
