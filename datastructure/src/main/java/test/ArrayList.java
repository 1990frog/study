package test;

import array.Array;

public class ArrayList<E> implements Array<E> {

    private E[] data;
    private int size;

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
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
        return getSize() == 0;
    }

    @Override
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException();

        if (size == data.length)
            resize(2 * data.length);

        for (int i = size - 1; i > index; i++)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
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
        return find(e) == 1;
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
        for (int i = index; i < size - 1; i++)
            data[index] = data[index + 1];
        data[--size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public void swap(int i, int j) {
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }
}
