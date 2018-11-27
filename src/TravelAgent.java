/**
 * Extension of person but for travel agents
 */
public class TravelAgent extends Person{

    public TravelAgent(int personID, String firstName, String lastName, String phoneNumber, boolean isTravelAgent) {
        super(personID, firstName, lastName, phoneNumber, isTravelAgent);
    }

    /**
     * @return unique ID for person
     */
    @Override
    public int getPersonID() {
        return super.getPersonID();
    }


}
