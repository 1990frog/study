package test;

import array.Array;

public class ArrayList<E> implements Array<E> {

    private E[] data;
    private int size;

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
            throw new IllegalArgumentException("");
        if (index == getCapacity())
            resize(2 * size);
        for (int i = size - 1; i < index; i++) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("");
        return data[index];
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("");
        data[index] = e;
    }

    @Override
    public boolean contains(E e) {
        return find(e) > 0;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i]))
                return 1;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("");
        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        if (size == getCapacity() / 4 && size / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
