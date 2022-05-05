package test;

import array.Array;
import org.omg.CORBA.Object;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/5/5
 */
public class ArrayList2<E> implements Array<E> {

    private E[] data;
    private int size;

    public ArrayList2() {
        this(10);
    }

    public ArrayList2(int capacity) {
        data = (E[]) new Object[capacity];
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
            throw new IllegalArgumentException("Add failed. Index is illegal.");

        if (size == data.length)
            resize(2 * data.length);

        for (int i = size - 1; i > index; i--)
            data[i + 1] = data[i];

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
        return find(e) > -1;
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
            data[i] = data[index + i];
        }

        data[--size] = null;

        if (size == data.length / 4 && size != data.length / 2)
            resize(data.length / 2);

        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
