package array;

/**
 * <p>
 * 循环队列
 * 数组队列删除一个元素，后续的元素向前移动，复杂度O(n)
 * <p>
 * capacity 浪费一个空间
 * (tail+1)%c == front 队列满
 *
 * 复杂度：
 * enqueue O(1) 均摊
 * dequeue O(1) 均摊
 * getFront() O(1)
 * getSize() O(1)
 * getCapacity() O(1)
 * </p>
 *
 * @author cai
 * @since 2022/4/26
 */
public class LoopArrayQueue<E> implements Queue<E> {

    /**
     * 容器
     */
    private E[] data;

    /**
     * front:队首
     * tail:下一个空位指针
     * size:元素个数
     */
    private int front, tail, size;

    public LoopArrayQueue() {
        this(10);
    }

    public LoopArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }
}
