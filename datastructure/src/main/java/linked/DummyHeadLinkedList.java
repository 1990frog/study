package linked;

/**
 * 使用虚拟头节点简化链表逻辑
 */
public class DummyHeadLinkedList<E> implements Linked<E> {

    private Node dummyHead;
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

    public DummyHeadLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        // dummyHead 是0这个位置的元素前一个位置的节点
        // head 是1这个位置的节点，所以遍历index-1次
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Delete failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        size--;
        return retNode.e;
    }

    @Override
    public void removeElement(E e) {

    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
//        Node prev = dummyHead;
//        for (int i = 0; i < index; i++) {
//            prev = prev.next;
//        }
//        prev.next = new Node(e, prev.next);
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public boolean contains(E e) {
//        for (Node cur = dummyHead.next; cur.next != null; cur = cur.next)
//            if (e.equals(cur))
//                return true;
//        return false;
        Node cur = dummyHead.next;
        while (cur != null) {
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
