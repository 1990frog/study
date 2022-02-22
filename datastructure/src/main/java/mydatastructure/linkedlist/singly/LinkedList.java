package mydatastructure.linkedlist.singly;

import datastructure.mydatastructure.linkedlist.Linked;

public class LinkedList<E> implements Linked<E> {

    //头结点
    private Node head;
    //容量
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // 获取链表中的元素个数
    @Override
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头添加新的元素e
    @Override
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        head = new Node(e, head);//简化
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        if (index == 0)
            addFirst(e);
//        else if(index==size) 只有头坐标需要特殊处理
//            addLast(e);
        else {
//            int i = 1;
//            for(Node node = head; node.next != null; node = node.next){
//                if(i+1==index){
//                    Node cur = node;
//                    Node newNode = new Node(e);
//                    newNode.next=cur.next;
//                    cur.next=newNode;
//                }
//                i++;
//            }
//            size++;
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;//找到前一个位置
            prev.next = new Node(e, prev.next);//一次重置两个next
            size++;
        }
    }

    @Override
    public void addLast(E e) {
        add(size, e);
//        Node node = new Node(e);
//
//        if (head == null) {
//            head = node;
//        } else {
//            Node cur = head;
//            while (cur.next != null) {//下一个节点null，跳出
//                cur = cur.next;//拿到下一个为null的节点
//            }
//            cur.next = node;
//        }
//        size++;
    }

    @Override
    public E removeLast() {
        E ret = null;
        while (head.next.next == null) {
            ret = head.next.e;
            head.next = null;
            size--;
        }
        return ret;
    }

    @Override
    public E removeFirst() {
        size--;
        E ret = head.e;
        head = head.next;
        return ret;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        if (index == 0) {
            return removeFirst();
        } else {
            Node prev = head;//从头开数
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;//
            E ret = prev.next.e;//被删除元素前面一个元素
            prev.next = prev.next.next;//跳过一个
            size--;
            return ret;
        }


//        int i = 0;
//        for (Node node = head; node.next != null; node = head.next) {
//            if (i + 1 == index) {
//                node.next = node.next.next;
//            }
//        }
//        return null;
    }

    // 更改指定位置的值
    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        if (index == 0) {
            head = new Node(e, head.next);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            prev.next = new Node(e, prev.next.next);
        }

    }

    // 返回指定位置的值
    @Override
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.e;
    }

    @Override
    public boolean contains(E e) {
        for (Node cur = head; cur.next != null; cur = cur.next)
            if (e.equals(cur.e))
                return true;
        return false;
    }


    class Node {
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

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("head ");
        Node node = head;
        for (int i = 0; i < size; i++) {
            buffer.append(node.e);
            node = node.next;
            if (node != null)
                buffer.append("->");
        }
        return buffer.toString();
    }

}
