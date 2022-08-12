package linked;

/**
 * <p>
 * 使用虚拟头节点简化链表逻辑
 * </p>
 *
 * @author cai
 * @since 2022/8/10
 */
public class DummyHeadLinkedList<E> implements Linked<E> {

    /**
     * 节点
     */
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

    }

    private Node dummyHead;
    private int size;

    public DummyHeadLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e（在链表中不是一个常用的操作）
     * @param index
     * @param e
     */
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

    /**
     * 在链表头添加新的元素e
     * @param e
     */
    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     * @param e
     */
    @Override
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 从链表中删除index(0-based)位置的元素, 返回删除的元素（在链表中不是一个常用的操作）
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Delete failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素, 返回删除的元素
     * @return
     */
    @Override
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素, 返回删除的元素
     * @return
     */
    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e
     * @param e
     */
    @Override
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    /**
     * 修改链表的第index(0-based)个位置的元素为e（在链表中不是一个常用的操作）
     * @param index
     * @param e
     */
    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        cur.e = e;
    }

    /**
     * 获得链表的第index(0-based)个位置的元素（在链表中不是一个常用的操作）
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     * @return
     */
    @Override
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     * @return
     */
    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

}
