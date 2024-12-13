package learn_juc;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExchangerSample {

    @Test
    public void test() throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread producer = new Thread(() -> {
            try {
                log.info("producer start");
                String ret = exchanger.exchange("producer");
                log.info("producer get value: {}", ret);
                log.info("producer end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "producer");
        Thread consumer = new Thread(() -> {
            try {
                log.info("consumer start");
                String ret = exchanger.exchange("consumer");
                log.info("consumer get value: {}", ret);
                log.info("consumer end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "consumer");
        producer.start();
        TimeUnit.SECONDS.sleep(3);
        consumer.start();
        producer.join();
        consumer.join();
        log.info("end!");
    }

}
