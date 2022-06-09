package test;

import heap.Heap;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    /**
     * heapify
     *
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new ArrayList<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int getCapacity() {
        return data.getCapacity();
    }

    /**
     * 向堆中添加元素
     *
     * @param e
     */
    @Override
    public void add(E e) {
        data.addLast(e);
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
            throw new IllegalArgumentException("Can not findMax when datastructure.playdatastructure.heap is empty.");
        return data.get(0);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    @Override
    public E extractMax() {
        data.swap(0, data.getSize() - 1);
        E ret = data.removeLast();
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
    public E replate(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param k
     * @return
     */
    private int leftChild(int k) {
        return k * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param k
     * @return
     */
    private int rightChild(int k) {
        return k * 2 + 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param k
     * @return
     */
    private int parent(int k) {
        if (k == 0)
            throw new IllegalArgumentException("k-0 doesn't have parent.");
        return (k - 1) / 2;
    }

    /**
     * 上浮
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 下沉
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j++;
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }
}
