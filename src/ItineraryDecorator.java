/**
 *
 */
public abstract class ItineraryDecorator implements iItineraryComponent{

    private final iItineraryComponent componentToDecorate; /*< Holds iItineraryComponent instance to be decorated */

    //! Constructor
    protected ItineraryDecorator(iItineraryComponent componentToDecorate) {
        this.componentToDecorate = componentToDecorate;
    }

    /**
     * @return trip that itinerary is describing
     */
    @Override
    public Trip getTrip() {
        return componentToDecorate.getTrip();
    }

    /**
     * @return String holding itinerary
     */
    @Override
    public String output() {
        return componentToDecorate.output();
    }
}
