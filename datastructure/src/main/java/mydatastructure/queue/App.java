package mydatastructure.queue;

import java.util.Random;

public class App {

    private static double testQueue(QueueInterface<Integer> q,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i=0;i<opCount;i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i=0;i<opCount;i++)
            q.dequeue();
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;
        Queue<Integer> queue = new Queue<>();
        System.out.println(testQueue(queue,opCount));
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println(testQueue(loopQueue,opCount));

    }
}
