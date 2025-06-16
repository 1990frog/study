package learn_interrupt.old;

import java.math.BigInteger;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class PrimeProducer extends Thread {
    private final BlockingDeque<BigInteger> queue;

    PrimeProducer(BlockingDeque<BigInteger> queue){
        this.queue = queue;
    }

    public void run(){
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()){
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            System.out.println("啥也不想做！");
        }
    }

    public void cancel(){
        interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        PrimeProducer primeProducer = new PrimeProducer(new LinkedBlockingDeque<>());
        primeProducer.start();
        TimeUnit.SECONDS.sleep(3);
        primeProducer.cancel();
    }
}
