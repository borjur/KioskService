package aop.bo;

import aop.DVDInfo;

import java.util.Map;
import java.util.HashMap;
import java.util.List;



public class DVDStatistics {
    private Map<String, Integer> stats = new HashMap<String, Integer>();
    private static DVDStatistics currentInstance;

    public static DVDStatistics getInstance() {
        if (currentInstance == null) {
            currentInstance = new DVDStatistics();
        }
        return currentInstance;
    }

    private DVDStatistics() {
    }

    public void addData(List<DVDInfo> data) {
        for (DVDInfo info : data) {
            String title = info.getTitle();
            if (stats.containsKey(title)) {
                int counter = stats.get(title);
                counter++;
                stats.put(title, counter);
            } else {
                stats.put(title, 1);
            }
        }
    }

    public Map<String, Integer> getStatistics() {
        return stats;
    }
}
