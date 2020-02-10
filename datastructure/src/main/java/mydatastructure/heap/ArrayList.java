package mydatastructure.heap;

import java.util.Arrays;

public class ArrayList<E> implements Array<E> {

    private E[] data;
    private int size;

    public ArrayList() {
        data = (E[]) (new Object[10]);
    }

    public ArrayList(int capacity) {
        data = (E[]) (new Object[capacity]);
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

        for (int i = size; i > index; i--)
            data[i] = data[i - 1];
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
        if (index < 0 || index > getCapacity())
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

        for (int i = index; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(size / 2);

        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("");
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) (new Object[newCapacity]);
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "list=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity =" + getCapacity() +
                '}';
    }
}
