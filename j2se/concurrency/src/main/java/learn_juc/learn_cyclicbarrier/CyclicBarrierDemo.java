package learn_juc.learn_cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 
 * </p>
 *
 * @author caijingquan@clinbrain.com
 * @since 5/30/24
 */
public class CyclicBarrierDemo implements Runnable {

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("所有人都到场了， 大家统一出发！"));

    private static final Random random = new Random();

    @Override
    public void run() {
        long id = Thread.currentThread().getId();
        System.out.println("线程" + id + "现在前往集合地点");
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(10));
            System.out.println("线程" + id + "到了集合地点，开始等待其他人到达");
            cyclicBarrier.await();
            System.out.println("线程" + id + "出发了");
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new CyclicBarrierDemo()).start();
        }
    }

}
