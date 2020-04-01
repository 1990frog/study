package datastructure.mydatastructure.queue;

import datastructure.mydatastructure.arrays.Array;

public class ArrayQueue<E> extends Array<E> implements Queue<E> {

    @Override
    public void enqueue(E e) {
        addLast(e);
    }

    @Override
    public E dequeue() {
        return removeFirst();
    }

    @Override
    public E getFront() {
        return get(0);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("front [");
        for (int i = 0; i < getSize(); i++) {
            buffer.append(get(i));
            if(i != getSize() - 1)
                buffer.append(", ");
        }
        buffer.append("]");
        return buffer.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i=0;i<100;i++)
            queue.enqueue(i);
        System.out.println(queue);
    }
}
