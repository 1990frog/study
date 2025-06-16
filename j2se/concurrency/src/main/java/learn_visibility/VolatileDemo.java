package learn_visibility;

import lombok.SneakyThrows;

public class VolatileDemo implements Runnable{

    private final static VolatileDemo demo = new VolatileDemo();

    // volatile 的语义不足以确保递增操作（count++）的原子性
    private static volatile int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

}
