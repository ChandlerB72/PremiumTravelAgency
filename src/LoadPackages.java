import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadPackages {
    // Person Singleton
    private static final Object syncLock = new Object();
    private static volatile LoadPackages loadPackages;
    private static List packageList = new ArrayList();

    private LoadPackages() {}

    public static List getInstance(){
        if (loadPackages == null){
            synchronized (syncLock){
                if (loadPackages == null){
                    packageList.add(new Package(1181, 18, "Tahiti", "Atlanta"));
                    packageList.add(new Package(335, 2, "Cuba", "Atlanta"));
                    packageList.add(new Package(177, 5, "Los Angeles","Atlanta"));
                    packageList.add(new Package(1388, 12, "Tokyo", "Atlanta"));

                    packageList.add(new Package(1715, 18, "Tahiti", "Cuba"));
                    packageList.add(new Package(348, 2, "Atlanta", "Cuba"));
                    packageList.add(new Package(383, 12, "Los Angeles","Cuba"));
                    packageList.add(new Package(1719, 19, "Tokyo", "Cuba"));

                    packageList.add(new Package(1715, 18, "Cuba", "Tahiti"));
                    packageList.add(new Package(1815, 16, "Atlanta", "Tahiti"));
                    packageList.add(new Package(1400, 8, "Los Angeles","Tahiti"));
                    packageList.add(new Package(1911, 23, "Tokyo", "Tahiti"));

                    packageList.add(new Package(1536, 20, "Cuba", "Tokyo"));
                    packageList.add(new Package(1453, 14, "Atlanta", "Tokyo"));
                    packageList.add(new Package(974, 12, "Los Angeles","Tokyo"));
                    packageList.add(new Package(2038, 13, "Tahiti", "Tokyo"));

                    packageList.add(new Package(215, 2, "Cuba", "Los Angeles"));
                    packageList.add(new Package(200, 5, "Atlanta", "Los Angeles"));
                    packageList.add(new Package(1263, 10, "Tokyo","Los Angeles"));
                    packageList.add(new Package(960, 8, "Tahiti", "Los Angeles"));
                }
            }
        }
        return Collections.unmodifiableList(packageList);
    }
}
