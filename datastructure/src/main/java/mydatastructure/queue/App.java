package mydatastructure.queue;

import java.util.Random;

public class App {

    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i=0;i<opCount;i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i=0;i<opCount;i++)
            q.dequeue();
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) throws InterruptedException {
        int opCount = 100000;
        Thread thread1 = new Thread(()->{//ArrayQueue.dequeue复杂度o(n)
            ArrayQueue<Integer> queue = new ArrayQueue<>();
            System.out.println("ArrayQueue :"+testQueue(queue,opCount));
        });
        Thread thread2 = new Thread(()->{//LoopQueue.dequeue复杂度o(1)
            LoopQueue<Integer> loopQueue = new LoopQueue<>();
            System.out.println("LoopQueue :"+testQueue(loopQueue,opCount));
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Test is end!");
    }
}
