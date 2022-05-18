package heap;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/5/18
 */
public interface Heap<E extends Comparable<E>> {

    /**
     * 返回堆中的元素个数
     * @return
     */
    int getSize();

    /**
     * 返回一个布尔值, 表示堆中是否为空
     * @return
     */
    boolean isEmpty();

    void add(E e);

    /**
     * 看堆中的最大元素
     * @return
     */
    E findMax();

    /**
     * 取出堆中最大元素
     * @return
     */
    E extractMax();

}
