package learn_threadsafe.publish;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) {
            throw new AssertionError("This statement is false.");
        }
    }

    public void test(){
        if(n == 0){
            System.out.println("This statement is 0.");
        }
    }

}

public class Demo1 {

    private Holder holder;

    public void initialize() {
        holder = new Holder(100);
    }

    public static void main(String[] args) {
        for (int j = 0; j < 100000000; j++) {
            Demo1 demo1 = new Demo1();
            ExecutorService executors = Executors.newFixedThreadPool(100);
            for (int i = 0; i < 100; i++) {
                if (i == 10) {
                    executors.submit(demo1::initialize);
                } else {
                    executors.submit(() -> demo1.holder.test());
                }
            }
            executors.shutdown();
        }
    }
}
