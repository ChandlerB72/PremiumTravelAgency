import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadPackages {
    // Package Singleton
    private static final Object syncLock = new Object();
    private static volatile LoadPackages loadPackages;
    private static List packageList = new ArrayList();

    private LoadPackages() {}

    public static List getInstance(){
        if (loadPackages == null){
            synchronized (syncLock){
                if (loadPackages == null){
                    packageList.add(new Package(1,348.00, 2, "Atlanta", "Cuba"));
                    packageList.add(new Package(2,200.00, 5, "Atlanta", "Los Angeles"));
                    packageList.add(new Package(3,1815.00, 16, "Atlanta", "Tahiti"));
                    packageList.add(new Package(4,1453.00, 14, "Atlanta", "Tokyo"));

                    packageList.add(new Package(5,335.00, 2, "Cuba", "Atlanta"));
                    packageList.add(new Package(6,215.00, 2, "Cuba", "Los Angeles"));
                    packageList.add(new Package(7,1715.00, 18, "Cuba", "Tahiti"));
                    packageList.add(new Package(8,1536.00, 20, "Cuba", "Tokyo"));

                    packageList.add(new Package(9,177.00, 5, "Los Angeles","Atlanta"));
                    packageList.add(new Package(10,383.00, 12, "Los Angeles","Cuba"));
                    packageList.add(new Package(11,1400.00, 8, "Los Angeles","Tahiti"));
                    packageList.add(new Package(12,974.00, 12, "Los Angeles","Tokyo"));

                    packageList.add(new Package(13,1181.00, 18, "Tahiti", "Atlanta"));
                    packageList.add(new Package(14,1715.00, 18, "Tahiti", "Cuba"));
                    packageList.add(new Package(15,960.00, 8, "Tahiti", "Los Angeles"));
                    packageList.add(new Package(16,2038.00, 13, "Tahiti", "Tokyo"));

                    packageList.add(new Package(17,1388.00, 12, "Tokyo", "Atlanta"));
                    packageList.add(new Package(18,1263.00, 10, "Tokyo","Los Angeles"));
                    packageList.add(new Package(19,1263.00, 10, "Tokyo","Los Angeles"));
                    packageList.add(new Package(20,1911.00, 23, "Tokyo", "Tahiti"));

                }
            }
        }
        return Collections.unmodifiableList(packageList);
    }
}
