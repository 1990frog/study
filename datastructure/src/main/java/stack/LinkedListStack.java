package stack;

import linked.DummyHeadLinkedList;

/**
 * 栈
 * 常规操作都在栈顶，特别适合使用链表做物理存储结构
 *
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    private DummyHeadLinkedList<E> list;

    public LinkedListStack(){
        list = new DummyHeadLinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
