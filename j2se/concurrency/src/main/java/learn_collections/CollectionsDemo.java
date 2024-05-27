package learn_collections;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CollectionsDemo {

    private final Random random = new Random();

    @Test
    public void synchronizedListTest() throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        // 静态工厂方法，封装非线程安全的容器
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
//        List<Integer> synchronizedList = Collections.synchronizedList(new LinkedList<>());
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                int val = random.nextInt(1000);
                list.add(val);
                synchronizedList.add(val);
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);
        log.info("List size: {}", list.size());
        log.info("SynchronizedList size: {}", synchronizedList.size());
    }
}
