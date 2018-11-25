import java.math.BigDecimal;
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
                    packageList.add(new Package(1,new BigDecimal(348.00), 2, "Atlanta", "Cuba"));
                    packageList.add(new Package(2,new BigDecimal(200.00), 5, "Atlanta", "Los Angeles"));
                    packageList.add(new Package(3,new BigDecimal(1815.00), 16, "Atlanta", "Tahiti"));
                    packageList.add(new Package(4,new BigDecimal(1453.00), 14, "Atlanta", "Tokyo"));

                    packageList.add(new Package(5,new BigDecimal(335.00), 2, "Cuba", "Atlanta"));
                    packageList.add(new Package(6,new BigDecimal(215.00), 2, "Cuba", "Los Angeles"));
                    packageList.add(new Package(7,new BigDecimal(1715.00), 18, "Cuba", "Tahiti"));
                    packageList.add(new Package(8,new BigDecimal(1536.00), 20, "Cuba", "Tokyo"));

                    packageList.add(new Package(9,new BigDecimal(177.00), 5, "Los Angeles","Atlanta"));
                    packageList.add(new Package(10,new BigDecimal(383.00), 12, "Los Angeles","Cuba"));
                    packageList.add(new Package(11,new BigDecimal(1400.00), 8, "Los Angeles","Tahiti"));
                    packageList.add(new Package(12,new BigDecimal(974.00), 12, "Los Angeles","Tokyo"));

                    packageList.add(new Package(13,new BigDecimal(1181.00), 18, "Tahiti", "Atlanta"));
                    packageList.add(new Package(14,new BigDecimal(1715.00), 18, "Tahiti", "Cuba"));
                    packageList.add(new Package(15,new BigDecimal(960.00), 8, "Tahiti", "Los Angeles"));
                    packageList.add(new Package(16,new BigDecimal(2038.00), 13, "Tahiti", "Tokyo"));

                    packageList.add(new Package(17,new BigDecimal(1388.00), 19, "Tokyo", "Atlanta"));
                    packageList.add(new Package(18,new BigDecimal(1920.00), 10, "Tokyo","Cuba"));
                    packageList.add(new Package(19,new BigDecimal(1263.00), 10, "Tokyo","Los Angeles"));
                    packageList.add(new Package(20,new BigDecimal(1911.00), 23, "Tokyo", "Tahiti"));

                }
            }
        }
        return Collections.unmodifiableList(packageList);
    }
}
