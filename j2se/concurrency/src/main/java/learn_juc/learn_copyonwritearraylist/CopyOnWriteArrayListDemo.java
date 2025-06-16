package learn_juc.learn_copyonwritearraylist;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author caijingquan
 * @since 5/30/24
 */
public class CopyOnWriteArrayListDemo {

    private static final Random random = new Random();

    @SneakyThrows
    @Test
    public void test1() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
                System.out.println(copyOnWriteArrayList);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        for (Integer val : copyOnWriteArrayList) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(val);
        }

    }

}
