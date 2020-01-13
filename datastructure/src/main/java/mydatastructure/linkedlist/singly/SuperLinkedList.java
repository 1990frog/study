package mydatastructure.linkedlist.singly;

import mydatastructure.linkedlist.Linked;

public class SuperLinkedList<E> implements Linked<E> {

    private Node head;
    private Node tail;
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

    public SuperLinkedList(){
        Node node = new Node(null,null);
        head = node;
        tail = node;
        size = 0;
    }


    @Override
    public void addLast(E e) {
        tail.next = new Node(e,null);
        tail = tail.next;
        size++;
    }

    @Override
    public void addFirst(E e) {
        head.next = new Node(e,head.next);
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public void set(int index, E e) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
