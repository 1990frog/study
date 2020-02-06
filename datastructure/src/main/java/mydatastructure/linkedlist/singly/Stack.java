package mydatastructure.linkedlist.singly;

import mydatastructure.stack.StackInterface;

public class Stack<E> implements StackInterface<E> {

    private LinkedInterfaceList<E> linkedList;

    public Stack(){
        linkedList = new LinkedInterfaceList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.get(0);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
