package learn_synchronized;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * `synchronized` 关键字不能被多态继承。
 * 如果父类中的某个方法是 `synchronized` 的，
 * 而子类中覆盖了这个方法，那么默认情况下子类中的这个方法并不是 `synchronized` 的，
 * 必须显式的在子类的这个方法中加上 `synchronized` 关键字才行。当然，不覆盖的话没事。
 * <p>
 * 不过子类的那个方法也可以通过调用父类中该相应的方法来实现 `synchronized` 效果。
 */


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
