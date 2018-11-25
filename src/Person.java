import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {

    // Variables
    protected int personID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private boolean isTravelAgent;

    // Constructor
    public Person(int personID, String firstName, String lastName, String phoneNumber, String gender, boolean isTravelAgent) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.isTravelAgent = isTravelAgent;
    }

    // Getters and Setters
    public int getPersonID() {
        return personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return (personID + "\t|" + firstName  + " " + lastName);
    }
}
