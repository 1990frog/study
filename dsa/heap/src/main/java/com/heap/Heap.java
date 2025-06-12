package com.heap;
/**
 * <p>
 * 最大堆：根结点的键值是所有堆结点键值中最大者的堆。
 * 最小堆：根结点的键值是所有堆结点键值中最小者的堆。
 * </p>
 *
 * @author cai
 * @since 2022/5/18
 */
public interface Heap<E extends Comparable<E>> {

    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 返回一个布尔值, 表示堆中是否为空
     *
     * @return
     */
    boolean isEmpty();

    int getCapacity();

    /**
     * 向堆中添加一个元素
     *
     * @param e
     */
    void add(E e);

    /**
     * 看堆中的最大元素
     *
     * @return
     */
    E findMax();

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    E extractMax();

    /**
     * 取出堆最大元素，并且替换成元素e
     *
     * @param e
     * @return
     */
    E replace(E e);

}
