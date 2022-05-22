package test;

import linked.Linked;

public class LinkedList<E> implements Linked<E> {

    class Node {
        E e;
        Node next;

        public Node() {
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private int size;
    private final Node dummyHead;

    public LinkedList() {
        dummyHead = new Node();
    }

    @Override
    public void addLast(E e) {
        add(size - 1, e);
    }

    @Override
    public void addFirst(E e) {
        dummyHead.next = new Node(e, dummyHead.next);
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        cur.next = new Node(e, cur.next);
        size++;
    }

    @Override
    public E removeLast() {
        E ret = get(size - 1);
        remove(size - 1);
        return ret;
    }

    @Override
    public E removeFirst() {
        E ret = dummyHead.next.e;
        dummyHead.next = dummyHead.next.next;
        return ret;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        E ret = cur.next.e;
        cur.next = cur.next.next;
        size--;
        return ret;
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.next.e = e;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.next.e;
    }

    @Override
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (e.equals(cur.next))
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
