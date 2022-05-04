package linked;

/**
 * <p>
 * 链表
 * 物理存储结构：非线性表
 * 真正的动态数据结构
 * <p>
 * 优点：真正的动态，不需要处理1固定容量的问题
 * 缺点：丧失了随机访问的能力
 * </p>
 *
 * @author cai
 */
public class LinkedList<E> implements Linked<E> {

    private Node head;
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

    /**
     * 初始化
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 链表添加位首元素复杂度O(1)
     *
     * @param e
     */
    @Override
    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    /**
     * 在index位置添加新元素e
     * <p>
     * 这种操作在链表中不是一个常用的操作，因为不符合链表的优势
     * <p>
     * 核心就是要找到插入位置的前一个节点
     * 特殊情况：第一个元素没有前一个节点，要特殊处理，可以使用虚拟头结点优化
     *
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            /* index 前一个位置：index-1 */
            for (int i = 0; i < index - 1; i++) {
                /* 每次都向后移动一个元素 */
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);//一次重置两个next
            size++;
        }
    }

    @Override
    public E removeLast() {
//        return remove(size);
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        size--;
        return last.e;
    }

    @Override
    public E removeFirst() {
        E ret = head.e;
        head = head.next;
        size--;
        return ret;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed. Illegal index.");
        }
        if (index == 0) {
            return removeFirst();
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            E ret = prev.next.e;//被删除元素前面一个元素
            prev.next = prev.next.next;//跳过一个
            size--;
            return ret;
        }
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed. Illegal index.");
        }
//        Node cur = head;
//        for (int i = 0; i < index; i++)
//            cur = cur.next;
//        cur.e = e;

        if (index == 0) {
            head = new Node(e, head.next);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            prev.next = new Node(e, prev.next.next);
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get failed. Illegal index.");
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
//        Node cur = head;
//        for (int i = 0; i < index; i++)
//            cur = cur.next;
//        return cur.e;

//        if (index == 0) {
//            return head.e;
//        } else {
//            Node prev = head;
//            for (int i = 0; i < index - 1; i++)
//                prev = prev.next;
//            return prev.next.e;
//        }
    }

    @Override
    public boolean contains(E e) {
//        Node cur = head;
//        while (cur != null) {
//            if (cur.e == e) {
//                return true;
//            }
//            cur = cur.next;
//        }
//        return false;
        for (Node cur = head; cur.next != null; cur = cur.next)
            if (e.equals(cur.e))
                return true;
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
