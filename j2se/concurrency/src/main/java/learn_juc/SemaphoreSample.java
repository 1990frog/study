package learn_juc;

import org.testng.annotations.Test;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    private final Semaphore semaphore;

    public SemaphoreSample() {
        semaphore = new Semaphore(1);
    }

    public SemaphoreSample(int permits) {
        semaphore = new Semaphore(permits);
    }

    @Test
    public void test(){
        
    }
}
