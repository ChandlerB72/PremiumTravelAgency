public class ItineraryFactory {

    // Methods
    public static String get(Trip trip) throws Exception{
        ValidateTripCanProduceItinerary(trip);

        iItineraryComponent itinerary = new Itinerary(trip);
        itinerary = new ItineraryAppendSeparator(itinerary);
        itinerary = new ItineraryAppendBookingDetails(itinerary);
        itinerary = new ItineraryAppendSeparator(itinerary);
        itinerary = new ItineraryAppendTravelers(itinerary);
        itinerary = new ItineraryAppendSeparator(itinerary);
        itinerary = new ItineraryAppendPackages(itinerary);
        itinerary = new ItineraryAppendSeparator(itinerary);
        itinerary = new ItineraryAppendThanks(itinerary);
        itinerary = new ItineraryAppendSeparator(itinerary);

        return itinerary.output();
    }

    // Validates Trip and Trip Status is able to produce Itinerary
    public static boolean TripCanProduceItinerary(Trip trip){
        assert trip != null : "trip != null";

        return trip.getTripStateStatus() == TripState.Status.Complete;
    }

    public static void ValidateTripCanProduceItinerary(Trip trip) throws Exception{
        assert trip != null : "trip != null";

        if(!TripCanProduceItinerary(trip))
            throw new Exception("Trip must be in complete state before generating itinerary");
    }
}
