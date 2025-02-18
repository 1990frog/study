package learn_synchronized;

/**
 * 测试可重入性
 */
public class ReentrantSample {

    static int counter = 5;

    public static synchronized void reentrantMethod(int a) {
        if (counter == 0) {
            return;
        }
        System.out.println(Thread.currentThread().getName() + " invoked reentrantMethod count: " + a);
        reentrantMethod(--counter);
    }

    public static void main(String[] args) {
        reentrantMethod(counter);
    }
}
