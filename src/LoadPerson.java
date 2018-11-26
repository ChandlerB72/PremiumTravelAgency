import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadPerson {
    // Person Singleton
    private static final Object syncLock = new Object();
    private static volatile LoadPerson loadPerson;
    private static List travelerList = new ArrayList();

    private LoadPerson() {
    }

    public static List getInstance(){
        if (loadPerson == null){
            synchronized (syncLock){
                if (loadPerson == null){
                    travelerList = new ArrayList(); // Preventing list from duplicated when being loaded in other places
                    travelerList.add(new TravelAgent(1,"Pennie", "Paterno","770-555-0001", "Female", true));
                    travelerList.add(new TravelAgent(2,"Cristobal", "Counce","770-555-0002", "Female", true));
                    travelerList.add(new TravelAgent(3,"Glady", "Gosse","770-555-0003", "Male", true));
                    travelerList.add(new TravelAgent(4,"Liana", "Lindeman","770-555-0004", "Female", true));
                    travelerList.add(new TravelAgent(5,"Kris", "Kilgo", "770-555-0005", "Male", true));
                    travelerList.add(new Traveler(6,"Bethann", "Bielecki", "770-555-0006", "Female", false));
                    travelerList.add(new Traveler(7,"Carmon", "Choquette", "770-555-0007", "Female", false));
                    travelerList.add(new Traveler(8,"Deandrea", "Didion", "770-555-0008", "Female", false));
                    travelerList.add(new Traveler(9,"Simonne", "Strawser", "770-555-0009", "Female", false));
                    travelerList.add(new Traveler(10,"Mikel", "Mcneel", "770-555-0010", "Male", false));
                    travelerList.add(new Traveler(11,"Gertrude", "Gowen", "770-555-0011", "Female", false));
                    travelerList.add(new Traveler(12,"Russel", "Rugg", "770-555-0012", "Male", false));
                    travelerList.add(new Traveler(13,"Etha", "Edmundson", "770-555-0013", "Female", false));
                    travelerList.add(new Traveler(14,"Bret", "Boeck", "770-555-0014", "Male", false));
                    travelerList.add(new Traveler(15,"Deon", "Delacerda", "770-555-0015", "Male", false));
                }
            }
        }
        return Collections.unmodifiableList(travelerList);
    }
}
