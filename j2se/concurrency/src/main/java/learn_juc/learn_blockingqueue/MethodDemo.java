package learn_juc.learn_blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MethodDemo {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        log.info("poll() {}", queue.poll());
        log.info("poll(time) {}", queue.poll(1, TimeUnit.SECONDS));
        // add 1
        queue.put(1);
        // throw IllegalStateException: Queue full
//        queue.add(2);/**/

        log.info("peek() {}", queue.peek());
        log.info("all: {}", queue);

        log.info("offer() {}", queue.offer(1, 1, TimeUnit.SECONDS));
        log.info("take() {}", queue.take());
    }
}
