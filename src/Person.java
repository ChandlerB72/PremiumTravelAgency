/**
 * Person is the object that holds all
 * the invidiual's information. This is
 * extended by both Traveler and Travel
 * Agent
 */
public class Person {

    protected int personID; /*< Unique identifier*/
    private String firstName; /*< First name of person*/
    private String lastName; /*< Last name of person*/
    private String phoneNumber; /*< Phone number of person*/
    private boolean isTravelAgent; /*< boolean on whether or not they're a travel agent*/

    //! Constructor
    public Person(int personID, String firstName, String lastName, String phoneNumber, boolean isTravelAgent) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.isTravelAgent = isTravelAgent;
    }

    //! Getter
    public int getPersonID() {
        return personID;
    }

    //! Getter
    public String getFirstName() {
        return firstName;
    }

    //! Getter
    public String getLastName() {
        return lastName;
    }

    //! Getter
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * @return Person information via String
     */
    @Override
    public String toString() {
        return (personID + "\t|" + firstName  + " " + lastName);
    }
}
