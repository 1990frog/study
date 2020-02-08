package mydatastructure.map;

import mydatastructure.linkedlist.singly.LinkedList;

public class LinkedMap<K extends Comparable<K>,V> implements Map<K,V> {

    private final LinkedList linked;

    public LinkedMap(){
        linked = new LinkedList();
    }

    @Override
    public void add(K k, V b) {

    }

    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public boolean contains(K k) {
        return false;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public void set(K k, V v) {

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
