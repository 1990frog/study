package array;

/**
 * <p>
 * 循环队列
 * 数组队列删除一个元素，后续的元素向前移动，复杂度O(n)
 * </p>
 *
 * @author cai
 * @since 2022/4/26
 */
public class LoopArrayQueue<E> implements Queue<E> {

    private E[] data;
    /*队首位置*/
    private int front = 0;
    /*下一个元素的位置*/
    private int fail = 0;

    public LoopArrayQueue() {
        data = (E[]) new Object[10];
    }

    public LoopArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E e) {
        data[fail++] = e;
        if (fail > data.length) {
            E[] newData = (E[]) new Object[data.length * 2];
            for(int i=0;i<data.length;i++){
//                newData[]
            }

        }
    }

    @Override
    public E dequeue() {
        E ret = data[front];
        data[front++] = null;
        return ret;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return front != fail;
    }
}
