package learn_concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class Sample {

    static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        // key不存在，直接添加，putIfAbsent方法返回null
        // key存在，不进行操作，putIfAbsent方法返回旧值
        map.putIfAbsent("a","a");
        map.putIfAbsent("a","b");
        System.out.println(map);
    }
}
