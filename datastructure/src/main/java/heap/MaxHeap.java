package heap;

import array.ArrayList;

/**
 * <p>
 * 最大堆
 * </p>
 *
 * @author cai
 * @since 2022/8/12
 */
public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return data.getSize();
    }

    /**
     * 返回一个布尔值, 表示堆中是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int getCapacity() {
        return data.getCapacity();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    @Override
    public void add(E e) {
        data.add(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 看堆中的最大元素
     *
     * @return
     */
    @Override
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    @Override
    public E extractMax() {
        E ret = findMax();
        data.swap(0, getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     *
     * @param e
     * @return
     */
    @Override
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {
            // 在此轮循环中,data[k]和data[j]交换位置
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0)
                j++;  // data[j] 是 leftChild 和 rightChild 中的最大值
            if(data.get(k).compareTo(data.get(j)) >= 0 )
                break;

            data.swap(k, j);
            k = j;
        }
    }
}
