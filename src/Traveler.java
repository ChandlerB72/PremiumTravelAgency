/**
 * Extension of person but for travelers only
 */
public class Traveler extends Person{

    public Traveler(int personID, String firstName, String lastName, String phoneNumber, boolean isTravelAgent) {
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