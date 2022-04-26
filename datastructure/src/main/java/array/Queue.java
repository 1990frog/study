package array;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/4/26
 */
public interface Queue<E> {
    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    E getFront();

    /**
     * 元素数量
     * @return
     */
    int getSize();

    /**
     * 是否null
     * @return
     */
    boolean isEmpty();
}
