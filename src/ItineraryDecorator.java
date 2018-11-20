public abstract class ItineraryDecorator implements iItineraryComponent{

    // Variables
    private final iItineraryComponent componentToDecorate;

    // Constructor
    protected ItineraryDecorator(iItineraryComponent componentToDecorate) {
        this.componentToDecorate = componentToDecorate;
    }

    // Methods
    @Override
    public Trip getTrip() {
        return componentToDecorate.getTrip();
    }

    @Override
    public String output() {
        return componentToDecorate.output();
    }
}
