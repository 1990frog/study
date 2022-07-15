package test;

import segmenttree.Merger;
import segmenttree.Segment;

public class SegmentTree<E> implements Segment<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        data = (E[]) new Object[arr.length];
        tree = (E[]) new Object[arr.length * 4];
        this.merger = merger;
        for (int i = 0; i < data.length; i++) {
            data[i] = arr[i];
        }
        buildSegmentTree();
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

    private void buildSegmentTree() {
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int index, int l, int r) {

        if (l == r) {
            tree[index] = data[l];
            return;
        }

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChild(index), l, mid);
        buildSegmentTree(rightChild(index), mid + 1, r);
        tree[index] = merger.merge(tree[leftChild(index)], tree[rightChild(index)]);
    }

    @Override
    public int getSize() {
        return tree.length;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    @Override
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");
        return query(0, 0, getSize() - 1, queryL, queryR);
    }

    private E query(int index, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR)
            return tree[index];

        int mid = l + (r - l) / 2;
        if (queryR < mid)
            return query(leftChild(index), l, mid, queryL, queryR);
        else if (mid < queryL)
            return query(rightChild(index), mid + 1, r, queryL, queryR);
        else {
            E left = query(leftChild(index), l, mid, queryL, mid);
            E right = query(rightChild(index), mid + 1, r, mid + 1, queryR);
            return merger.merge(left, right);
        }

//        if (l == queryL && r == queryR)
//            return tree[treeIndex];
//
//        int leftTreeIndex = leftChild(treeIndex);
//        int rightTreeIndex = rightChild(treeIndex);
//        int mid = l + (r - l) / 2;
//
//        if (mid < queryL)
//            return query(leftTreeIndex, mid + 1, r, queryL, queryR);
//        else if (mid > queryR)
//            return query(rightTreeIndex, l, mid, queryL, queryR);
//
//        E leftResult = query(leftTreeIndex, l, mid, queryL, queryR);
//        E rightResult = query(rightTreeIndex, mid + 1, r, queryL, queryR);
//        return merger.merge(leftResult, rightResult);

    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= getSize())
            throw new IllegalArgumentException();
        data[index] = e;
        set(0, 0, getSize() - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {

        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index < mid)
            set(leftTreeIndex, l, mid, index, e);
        else
            set(rightTreeIndex, mid + 1, r, index, e);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }

}
