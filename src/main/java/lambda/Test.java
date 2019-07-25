package lambda;

import java.util.concurrent.atomic.AtomicReference;

/**
 * The type Test.
 */
public class Test {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

    /**
     * Run.
     */
    public void run() {
        AtomicReference<String> name = new AtomicReference<>("Alex");
//        new Thread(() -> System.out.println("Hello, " + name)).start();
        new Thread(
                () -> name.set("haha")
        ).start();
    }
}
