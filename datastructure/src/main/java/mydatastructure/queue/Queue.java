package mydatastructure.queue;

import mydatastructure.arrays.Array;

public class Queue<E> extends Array<E> implements QueueInterface<E> {

    @Override
    public void push(E e) {
        addLast(e);
    }

    @Override
    public E pop() {
        return removeLast();
    }

    @Override
    public E peek() {
        return get(getSize()-1);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (int i = 0; i < getSize(); i++) {
            buffer.append(get(i));
            if(i != getSize() - 1)
                buffer.append(", ");
        }
        buffer.append("] top");
        return buffer.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue =new Queue<>();
        for (int i=0;i<10;i++){
            queue.push(i);
        }
        System.out.println(queue.toString());
        queue.pop();
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);

    }
}
