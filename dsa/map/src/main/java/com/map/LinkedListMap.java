package com.map;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/5/12
 */
public class LinkedListMap<K extends Comparable<K>, V> implements Map<K, V> {

    private final Node dummyHead;
    private int size;

    class Node {
        private K key;
        private V value;
        private Node next;

        public Node() {}

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public LinkedListMap() {
        dummyHead = new Node();
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
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }
        else
            node.value = value;
    }

//    private Node getNode(K key){
//        return getNode(dummyHead.next,key);
//    }
//    private Node getNode(Node node, K key) {
//        if (node == null)
//            return null;
//        if (key.compareTo(node.key) == 0)
//            return node;
//        return getNode(node.next, key);
//    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = value;
    }

    @Override
    public V remove(K key){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }

        return null;
    }

//    @Override
//    public V remove(K key) {
//        Node ret = getNode(key);
//        if(ret!=null){
//            dummyHead.next = remove(dummyHead.next,key);
//        }
//        return ret == null ? null : ret.value;
//    }
//
//    private Node remove(Node node, K key) {
//        if(key.compareTo(key)==0){
//            Node next = node.next;
//            node.next = null;
//            size--;
//            return next;
//        }
//        node.next = remove(node.next,key);
//        return node;
//    }

}
