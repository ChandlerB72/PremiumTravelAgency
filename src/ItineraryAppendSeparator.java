public class ItineraryAppendSeparator extends ItineraryDecorator{

    // Constructor
    public ItineraryAppendSeparator(iItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    // Methods
    @Override
    public String output() {
        StringBuilder toOutput = new StringBuilder(super.output());

        toOutput.append("--------------------------------------------");

        return toOutput.toString();
    }
}
