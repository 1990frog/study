package set;

public interface Set<E> {

    void add(E e);
    int getSize();
    boolean isEmpty();
    boolean contains(E e);
    void remove(E e);

}
