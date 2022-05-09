package binarysearchtree;

public interface tree<E> {
    void add(E e);
    boolean contains(E e);
    E minimum();
    E maximum();
    void dlr();
    void ldr();
    void lrd();
    E removeMin();
    E removeMax();
    void remove(E e);
}
