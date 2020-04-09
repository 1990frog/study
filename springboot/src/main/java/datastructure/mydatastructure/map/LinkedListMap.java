package datastructure.mydatastructure.map;

public class LinkedListMap<K extends Comparable<K>,V> implements Map<K,V> {

    private final LinkedList<K,V> list;

    public LinkedListMap(){
        list = new LinkedList<K,V>();
    }

    private void add(K k, V v) {
        list.add(k,v);
    }

    private void set(K k, V v) {
        list.set(k,v);
    }

    @Override
    public void put(K k,V v){
        if(contains(k)){
            set(k,v);
        }else{
            add(k,v);
        }
    }

    @Override
    public V remove(K k) {
        return list.remove(k);
    }

    @Override
    public boolean contains(K k) {
        return list.contains(k);
    }

    @Override
    public V get(K k) {
        return list.get(k);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
