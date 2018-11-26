import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Travel Agents Singleton
 */
public class LoadTravelAgents {
    // Singleton
    private static final Object syncLock = new Object();
    private static volatile LoadTravelAgents loadTravelAgents;
    private static List travelAgentList = new ArrayList();

    private LoadTravelAgents(){}

    public static List getInstance(){
        if (loadTravelAgents == null){
            synchronized (syncLock){
                if (loadTravelAgents == null){
                    travelAgentList.add(new TravelAgent(1,"Jeff", "Adkisson","770-555-0001", true));
                    travelAgentList.add(new TravelAgent(2,"Marco", "Alfaro","770-555-0002", true));
                    travelAgentList.add(new TravelAgent(3,"Muhammad", "Ali","770-555-0003", true));
                    travelAgentList.add(new TravelAgent(4,"Myles", "Andre","770-555-0004",  true));
                    travelAgentList.add(new TravelAgent(5,"Hunter", "Black", "770-555-0005", true));
                }
            }
        }
        return Collections.unmodifiableList(travelAgentList);
    }
}
