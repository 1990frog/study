package demo.lambda;

import java.util.concurrent.atomic.AtomicReference;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

    public void run() {
        AtomicReference<String> name = new AtomicReference<>("Alex");
//        new Thread(() -> System.out.println("Hello, " + name)).start();
        new Thread(
                () -> name.set("haha")
        ).start();
    }
}
