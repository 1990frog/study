package array;

import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayList<E> implements Array<E> {

    private final E[] data;
    private Integer size;
    private final Integer capacity;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return data == null;
    }

    @Override
    public void add(int index, E e) {
        if (index > capacity) {
            this.resize(index);
        }
        for (int i = size; i >= index; i--) {
            data[i + 1] = data[i];
            if (i == index) {
                data[i] = e;
            }
        }
    }

    @Override
    public E get(int index) throws IllegalAccessException {
        if (index > size) {
            throw new IllegalAccessException("illegal index");
        }
        return this.data[index];
    }

    @Override
    public void set(int index, E e) throws IllegalAccessException {
        if (index > capacity) {
            throw new IllegalAccessException("illegal index");
        }
        this.data[index] = e;
    }

    @Override
    public boolean contains(E e) {
        return this.find(e) > -1;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (this.data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) throws IllegalAccessException {
        if (index > size) {
            throw new IllegalAccessException("illegal index");
        }
        E ret = this.data[index];
        this.data[index] = null;
        return ret;
    }

    @Override
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newData[i] = data[i];
        }
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add(0,"a");
        list.add(0,"b");
        list.add(0,"c");
        System.out.print(list.toString());
    }
}
