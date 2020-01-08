package mydatastructure.stack;

import mydatastructure.arrays.Array;

public class Stack<E> extends Array<E> implements StackInterface<E> {

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
        Stack<Integer> queue =new Stack<>();
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
