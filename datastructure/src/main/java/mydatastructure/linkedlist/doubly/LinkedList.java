package mydatastructure.linkedlist.doubly;

import datastructure.mydatastructure.linkedlist.Linked;

public class LinkedList<E> implements Linked<E> {

    private Node dummyHead;
    private Node tail;
    private int size;

    public LinkedList() {
        Node node = new Node(null, null, null);
        dummyHead = node;
        tail = node;
        size = 0;
    }

    private class Node {
        private E e;
        private Node next;
        private Node prev;

        public Node(E e, Node next, Node prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }
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
    public void addLast(E e) {
        tail.next = new Node(e, null, tail);
        size++;
    }

    @Override
    public void addFirst(E e) {
        dummyHead.next = new Node(e, null, dummyHead);
        tail = dummyHead.next;
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node prev = dummyHead.next;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        prev.next = new Node(e, prev.next, prev);
        size++;
    }

    @Override
    public E removeLast() {
        E ret = tail.e;
        tail.prev = null;
        size--;
        return ret;
    }

    @Override
    public E removeFirst() {
        Node ret = dummyHead.next;
        dummyHead.next = ret.next;
        return ret.e;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        Node prev = dummyHead.next;
        for (int i = 0; i < index; i++)
            prev = prev.next;
//        E ret = prev.next.e;
//        prev.next = prev.next.next;
        Node retNode = prev.next;
        prev.next = retNode.next;
//        retNode.next = null;交给虚拟机处理不行嘛？
        size--;
        return retNode.e;
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node prev = dummyHead.next;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        prev.next.e = e;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node prev = dummyHead.next;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        return prev.next.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    @Override
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur.next != null) {
            cur = cur.next;
            if (e.equals(cur.e))
                return true;
        }
        return false;
    }

}
