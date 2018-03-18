import java.util.*;

public class Observable {
    private static Map<String, Observer> observerMap;
    static {
        observerMap = new LinkedHashMap<>();

    }

    public void attachObserver(String key, Observer observer) {
        if (!observerMap.containsKey(key)) {
            observerMap.put(key, observer);
        }
    }
    public void detachObserver(String key) {
        if (observerMap.containsKey(key)) {
            observerMap.remove(key);
        }
    }
    public void notifyObservers(String area) {
        for (Observer observer: observerMap.values()) {
            observer.update(area);
        }
    }

}
