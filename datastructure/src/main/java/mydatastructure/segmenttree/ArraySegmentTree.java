package mydatastructure.segmenttree;

import java.util.Arrays;

public class ArraySegmentTree<E> implements SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public ArraySegmentTree(E[] arr, Merger<E> merger){
        data = arr;
        tree = (E[])new Object[4 * data.length];
        this.merger = merger;
        buildSegmentTree(0,0,data.length-1);
    }

    private int parent(int index){
        if(index==0)
            throw new IllegalArgumentException("index is illegal");
        return index/2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private void buildSegmentTree(int treeIndex,int l,int r){

        if(l==r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r-l)/2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E query(int queryL, int queryR) {
        return null;
    }

    @Override
    public String toString() {
        return "ArraySegmentTree{" +
                ", tree=" + Arrays.toString(tree) +
                '}';
    }
}

interface Merger<E> {
    E merge(E a, E b);
}
