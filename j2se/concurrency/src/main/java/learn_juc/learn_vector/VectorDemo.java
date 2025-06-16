package learn_juc.learn_vector;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VectorDemo {

    private static final Vector<Integer> vector = new Vector<>();

    private static final List<Integer> list = new ArrayList<>();

    private final Random random = new Random();

    public void vectorTest() {
        int num = 1000;
        for (int i = 0; i < num; i++) {
            new Thread(() -> {
                Integer val = random.nextInt(1000);
                vector.add(val);
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Vector {}, {}", num, vector.size());
    }

    public void listTest() {
        int num = 1000;
        for (int i = 0; i < num; i++) {
            new Thread(() -> {
                Integer val = random.nextInt(1000);
                list.add(val);
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("List {}, {}", num, list.size());
    }

    public static void main(String[] args) {
        VectorDemo demo = new VectorDemo();
        demo.vectorTest();
        demo.listTest();
    }
}
