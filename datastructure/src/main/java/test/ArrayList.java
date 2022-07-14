package test;

import array.Array;

public class ArrayList<E> implements Array<E> {

    private E[] data;
    private int size;

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public ArrayList() {
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
    public void addObject(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException();
        if (data.length == size)
            resize(data.length * 2);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        return data[index];
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        data[index] = e;
    }

    @Override
    public boolean contains(E e) {
        return this.find(e) > -1;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(data[i]))
                return 1;
        return -1;
    }


    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];//前移
        data[--size] = null;
        if (size == data.length / 4 && size / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    @Override
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    private void resize(int capatity) {
        E[] newData = (E[]) new Object[capatity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }
}
