package test;

import array.ArrayList;
import heap.Heap;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private void siftUp(int k) {
//        if (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
//            data.swap(k, parent(k));
//            siftUp(parent(k));
//        }
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    private void siftDown(int k) {
//        if (data.get(k).compareTo(data.get(leftChild(k))) < 0) {
//            data.swap(k, leftChild(k));
//            siftDown(leftChild(k));
//        }

        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0)
                j++;

            if(data.get(k).compareTo(data.get(j)) >= 0 )
                break;

            data.swap(k, j);
            k = j;
        }
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.getSize() == 0;
    }

    @Override
    public int getCapacity() {
        return data.getCapacity();
    }

    @Override
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    @Override
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    @Override
    public E extractMax() {
        data.swap(0, data.getSize() - 1);
        E ret = data.removeLast();
        siftDown(0);
        return ret;
    }

    @Override
    public E replate(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
