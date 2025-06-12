package com.demo;

import com.array.Array;

public class ArrayListTest<E> implements Array<E> {

    private int size;

    private E[] data;

    public ArrayListTest(int category) {
        data = (E[]) new Object[category];
        size = 0;
    }

    public ArrayListTest() {
        this(10);
    }

    @Override
    public int getCapacity() {
        return data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if (size == getCapacity())
            resize(2 * getCapacity());

        for (int i = size - 1; i >= index; i++) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public E get(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        return data[index];
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i]))
                return true;
        }
        return false;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public E remove(int index) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    private void resize(int category) {
        E[] newData = (E[]) new Object[category];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    @Override
    public void swap(int i, int j) {

    }
}
