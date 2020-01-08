package mydatastructure.queue;

public interface QueueInterface<E> {
    void push(E e);
    E pop();
    E peek();
    int getSize();
    boolean isEmpty();
}
