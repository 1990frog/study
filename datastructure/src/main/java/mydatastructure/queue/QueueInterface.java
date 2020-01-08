package mydatastructure.queue;

public interface QueueInterface<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
