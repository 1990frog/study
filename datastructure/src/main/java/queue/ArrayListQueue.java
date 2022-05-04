package queue;

import array.ArrayList;
import queue.Queue;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/4/26
 */
public class ArrayListQueue<E> implements Queue<E> {

    private ArrayList<E> data;

    public ArrayListQueue() {
        data = new ArrayList<>();
    }

    public ArrayListQueue(int capacity) {
        data = new ArrayList<>(capacity);
    }

    @Override
    public void enqueue(E o) {
        data.add(o);
    }

    @Override
    public E dequeue() {
        return data.remove(0);
    }

    @Override
    public E getFront() {
        return data.get(0);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public String toString() {
        return "ArrayListQueue{" +
                "data= Front" + data +
                "} End";
    }
}
