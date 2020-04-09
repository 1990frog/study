package datastructure.mydatastructure.map;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    private BST<K,V> bst;

    public BSTMap(){
        bst = new BST<>();
    }

    @Override
    public void put(K k, V v) {
        bst.add(k,v);
    }

    @Override
    public V remove(K k) {
        bst.remove(k);
        return null;
    }

    @Override
    public boolean contains(K k) {
        return bst.contains(k);
    }

    @Override
    public V get(K k) {
        return bst.get(k);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public String toString() {
        return bst.toString();
    }
}

