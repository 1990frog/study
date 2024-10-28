package learn_collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UnmodifiableSample {
    private final ConcurrentHashMap<String, String> concurrentHashMap;
    private final Map<String, String> unmodifiableMap;

    public UnmodifiableSample(Map<String, String> map) {
        concurrentHashMap = new ConcurrentHashMap<>(map);
        unmodifiableMap = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("c", "d");

        UnmodifiableSample unmodifiableSample = new UnmodifiableSample(map);
        System.out.println(unmodifiableSample.unmodifiableMap);

        unmodifiableSample.concurrentHashMap.replace("a","e");
        System.out.println(unmodifiableSample.unmodifiableMap);

        unmodifiableSample.unmodifiableMap.replace("a","f");
        System.out.println(unmodifiableSample.unmodifiableMap);

    }
}
