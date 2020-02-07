package mydatastructure.linkedlist.singly;

import mydatastructure.linkedlist.LinkedInterface;

public class DummyHeadLinkedList<E> implements LinkedInterface<E> {

    private Node dummyHead;
    private int size;

    class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

    }

    public DummyHeadLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public void addFirst(E e) {
//        Node node = new Node(e);
//        dummyHead.next = node;
        add(0,e);
    }

    @Override
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size++;
    }

    @Override
    public E removeLast() {
        return remove(size);
    }

    @Override
    public E removeFirst() {
        Node ret = dummyHead.next;
        dummyHead.next = ret.next;
        size--;
        return ret.e;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        Node node = dummyHead;
        for (int i = 0; i < index; i++)
            node = node.next;
        E var = node.next.e;
        node.next = node.next.next;
        return var;
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node node = dummyHead;
        for (int i = 0; i < index; i++)
            node = node.next;
        node.e = e;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node node = dummyHead;
        for (int i = 0; i < index; i++)
            node = node.next;
        return node.e;
    }

    @Override
    public boolean contains(E e) {
//        for (Node node = dummyHead.next; node.next != null; node = node.next)
//            if (node.e.equals(e))
//                return true;
//        return false;

        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e))
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

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        Node cur = dummyHead;
        while (cur.next != null) {
            buffer.append(cur.next.e);
            cur = cur.next;
            if (cur.next != null)
                buffer.append("->");
        }
        return buffer.toString();
    }

}
