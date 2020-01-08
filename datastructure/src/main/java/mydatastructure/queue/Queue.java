package mydatastructure.queue;

import mydatastructure.arrays.Array;

public class Queue<E> extends Array<E> implements QueueInterface<E> {

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
        Queue<Integer> queue = new Queue<>();
        for(int i=0;i<100;i++)
            queue.enqueue(i);
        System.out.println(queue);
    }
}
