package linked;

/**
 * 带有尾指针的链表
 * 优点：
 * 实现队列，入队出队都是O(1)
 * @param <E>
 */ 
public class DoubleHeadLinkedList<E> implements Linked<E> {

    private Node dummyHead;
    private Node tail;
    private int size;

    /**
     * 节点
     */
    private class Node {
        E e;
        Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    public void addLast(E e) {
        Node node = new Node(e);
        tail.next = node;
        tail = node;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if (index == size) {
            addLast(e);
        } else {
            Node prev = dummyHead.next;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        Node removeNode = dummyHead.next;
        dummyHead.next = removeNode.next;
        size--;
        return removeNode.e;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = dummyHead.next;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node removeNode = prev.next;
        prev.next = removeNode.next;
        size--;
        return removeNode.e;
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    @Override
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur.next != null){
            if (cur.e.equals(e))
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
