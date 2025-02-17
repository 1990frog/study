package learn_synchronized;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;


public class ExtendsDemo {

    public synchronized void method() {
        try {
            System.out.println(Thread.currentThread().getName() + "开始执行！");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + "结束执行！");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Sub extends ExtendsDemo {

    }

    @SneakyThrows
    public static void main(String[] args) {
        ExtendsDemo.Sub demo = new ExtendsDemo.Sub();
        Thread t1 = new Thread(demo::method, "t1");
        Thread t2 = new Thread(demo::method, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println();
    }
}
