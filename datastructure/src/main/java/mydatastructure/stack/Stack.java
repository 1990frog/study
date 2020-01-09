package mydatastructure.stack;

import mydatastructure.arrays.Array;

public class Stack<E> implements StackInterface<E> {

    private Array<E> array;

    public Stack(){
        array = new Array<>();
    }

    public Stack(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(getSize()-1);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (int i = 0; i < getSize(); i++) {
            buffer.append(array.get(i));
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
