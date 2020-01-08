package mydatastructure.stack;

public interface StackInterface<E> {
    void push(E e);
    E pop();
    E peek();
    int getSize();
    boolean isEmpty();
}
