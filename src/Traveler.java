import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Traveler extends Person{

    public Traveler(int personID, String firstName, String lastName, String phoneNumber, String gender, boolean isTravelAgent) {
        super(personID, firstName, lastName, phoneNumber, gender, isTravelAgent);
    }

    @Override
    public int getPersonID() {
        return super.getPersonID();
    }


}