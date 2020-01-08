package mydatastructure.queue;

import mydatastructure.arrays.Array;

import java.util.Arrays;
import java.util.stream.Stream;

public class LoopQueue<E> implements QueueInterface<E> {

    private int front, tail;
    private E[] data;

    public LoopQueue(){
        data = (E[])new Object[10];
    }

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length==front)
            resize(data.length);
        data[(tail++)%data.length]=e;
    }

    public void resize(int capacity){
        E[] newdata = (E[])new Object[capacity*2];
        for(int i=0;i<capacity-1;i++)
            newdata[i]=data[(front+i)%capacity];
        data = newdata;
        front=0;
        tail=capacity-1;
    }

    @Override
    public E dequeue() {
        if(front+1==data.length){//数组最后一个元素
            front = 0;
            return data[front];
        }else{
            return data[front++]=null;
        }
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return tail-front-1;
    }

    @Override
    public boolean isEmpty() {
        return tail-front==0;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("front [");
        for(int i=0;i<data.length;i++){
            buffer.append(data[i]);
            if(i != data.length - 1)
                buffer.append(", ");
        }
        buffer.append("] tail");
        return buffer.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for(int i=0;i<9;i++){
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println("dequeue");
        System.out.println(loopQueue);
        loopQueue.dequeue();
        System.out.println("dequeue");
        System.out.println(loopQueue);
        loopQueue.enqueue(10);
        System.out.println("enqueue 10");
        System.out.println(loopQueue);
        loopQueue.enqueue(11);
        System.out.println("enqueue 11");
        System.out.println(loopQueue);
    }
}
