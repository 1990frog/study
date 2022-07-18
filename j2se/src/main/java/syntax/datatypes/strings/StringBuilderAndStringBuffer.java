package syntax.datatypes.strings;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * printout:
 * StringBuffer:1000000
 * AtomicInteger:1000000
 * StringBuilder:981663
 * int:994087
 */
public class StringBuilderAndStringBuffer implements Runnable {

    private static StringBuffer sb = new StringBuffer();
    private static StringBuilder sbr = new StringBuilder();
    private static int a;
    private static AtomicInteger b = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            sb.append(0);
            sbr.append(0);
            a++;
            b.incrementAndGet();
        }
    }

    public static void main(String[] args) {

        StringBuilderAndStringBuffer run = new StringBuilderAndStringBuffer();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.execute(run);
        }
        executor.shutdown();

        while (!executor.isTerminated()){}

        System.out.println("StringBuffer:"+sb.length());
        System.out.println("AtomicInteger:"+b);
        System.out.println("StringBuilder:"+sbr.length());
        System.out.println("int:"+a);

    }
}
