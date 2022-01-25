package mydatastructure.map;

public interface Map<K,V> {
//    void add(K k,V b);
//    void set(K k,V v);
    void put(K k,V v);
    V remove(K k);
    boolean contains(K k);
    V get(K k);
    int getSize();
    boolean isEmpty();
}
