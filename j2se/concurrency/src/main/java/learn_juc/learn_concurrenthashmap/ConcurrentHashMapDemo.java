package learn_juc.learn_concurrenthashmap;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ConcurrentHashMapDemo {

    private final ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

    @Test
    public void putIfAbsentTest() {
        concurrentHashMap.putIfAbsent(1, 1);
    }
}
