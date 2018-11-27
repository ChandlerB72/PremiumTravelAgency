import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Person Singleton
 */
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
                    travelerList.add(new TravelAgent(1,"Jeff", "Adkisson","770-555-0001", true));
                    travelerList.add(new TravelAgent(2,"Marco", "Alfaro","770-555-0002", true));
                    travelerList.add(new TravelAgent(3,"Muhammad", "Ali","770-555-0003", true));
                    travelerList.add(new TravelAgent(4,"Myles", "Andre","770-555-0004",  true));
                    travelerList.add(new TravelAgent(5,"Hunter", "Black", "770-555-0005", true));
                    travelerList.add(new Traveler(6,"Damont'e", "Bowie", "770-555-0006", false));
                    travelerList.add(new Traveler(7,"Danielle", "Brooks", "770-555-0007", false));
                    travelerList.add(new Traveler(8,"Chandler", "Brown", "770-555-0008", false));
                    travelerList.add(new Traveler(9,"Brad", "Cropsey", "770-555-0009", false));
                    travelerList.add(new Traveler(10,"Nathanael", "Curtis", "770-555-0010", false));
                    travelerList.add(new Traveler(11,"Henok", "Demisse", "770-555-0011",  false));
                    travelerList.add(new Traveler(12,"Dickson", "Diku", "770-555-0012", false));
                    travelerList.add(new Traveler(13,"Eric", "Gray", "770-555-0013", false));
                    travelerList.add(new Traveler(14,"Sandra", "Jones", "770-555-0014", false));
                    travelerList.add(new Traveler(15,"Quillan", "May", "770-555-0015", false));
                    travelerList.add(new Traveler(16,"Colt", "McKissk", "770-555-0016", false));
                    travelerList.add(new Traveler(17,"Phuc", "Nguyen", "770-555-0017", false));
                    travelerList.add(new Traveler(18,"Drashtee", "Parmar", "770-555-0018", false));
                    travelerList.add(new Traveler(19,"Sai", "Pyneni", "770-555-0019", false));
                    travelerList.add(new Traveler(20,"Jai", "Rai", "770-555-0020", false));
                    travelerList.add(new Traveler(21,"Adam", "Simonicek", "770-555-0021", false));
                    travelerList.add(new Traveler(22,"Clark", "Wilson", "770-555-0022", false));
                    travelerList.add(new Traveler(23,"Mark", "Zeagler", "770-555-0023", false));
                }
            }
        }
        return Collections.unmodifiableList(travelerList);
    }
}
