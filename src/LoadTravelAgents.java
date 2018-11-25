import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadTravelAgents {
    // Singleton
    private static final Object syncLock = new Object();
    private static volatile TravelAgent travelAgent;
    private static List travelAgentList = new ArrayList();

    private LoadTravelAgents(){}

    public static List getInstance(){
        if (travelAgent == null){
            synchronized (syncLock){
                if (travelAgent == null){
                    travelAgentList.add(new TravelAgent(1,"Pennie", "Paterno","770-555-0001", "Female", true));
                    travelAgentList.add(new TravelAgent(2,"Cristobal", "Counce","770-555-0002", "Female", true));
                    travelAgentList.add(new TravelAgent(3,"Glady", "Gosse","770-555-0003", "Male", true));
                    travelAgentList.add(new TravelAgent(4,"Liana", "Lindeman","770-555-0004", "Female", true));
                    travelAgentList.add(new TravelAgent(5,"Kris", "Kilgo", "770-555-0005", "Male", true));
                }
            }
        }
        return Collections.unmodifiableList(travelAgentList);
    }
}
