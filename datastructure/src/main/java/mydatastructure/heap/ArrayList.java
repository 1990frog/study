package mydatastructure.heap;

import java.util.Arrays;

public class ArrayList<E> implements Array<E> {

    private E[] list;
    private int size;

    public ArrayList(){
        list = (E[])(new Object[10]);
    }

    public ArrayList(int capacity){
        list = (E[])(new Object[capacity]);
    }

    @Override
    public int getCapacity() {
        return list.length;
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

        if(index<0 || index>size)
            throw new IllegalArgumentException("error");

        for (int i = size; i >= index ; i--) {
            if(size==getCapacity())
                resize(getCapacity()*2);

            if(i>index)
                list[i] = list[i-1];
            else if(i==index)
                list[i] = e;
            else
                break;
        }

        size++;

    }

    public void addLast(E e){
        add(size,e);
    }

    @Override
    public E get(int index) {
        if(index<0 || index>getCapacity())
            throw new IllegalArgumentException("error");
        return list[index];
    }

    @Override
    public void set(int index, E e) {
        if(index<0 || index>size)
            throw new IllegalArgumentException("error");
        list[index] = e;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if(e.equals(list[i]))
                return true;
        }
        return false;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if(e.equals(list[i]))
                return i;
        }
        return -1;
    }

    @Override
    public E remove(int index) {

        if(index<0 || index>size)
            throw new IllegalArgumentException("error");

        E ret = list[index];

        for (int i = index; i < size; i++)
            list[i] = list[i+1];

        if(size==getCapacity()/2)
            resize(size/4);

        size--;

        return ret;
    }

    private void resize(int newCapacity) {
        E[] newList = (E[])(new Object[newCapacity]);
        for (int i = 0; i < size; i++)
            newList[i] = list[i];
        list = newList;
    }

    public void swap(int i,int j){
        if(i<0 || i>size || j<0 || j>size)
            throw new IllegalArgumentException("");
        E arg = list[i];
        list[i] = list[j];
        list[j] = arg;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "list=" + Arrays.toString(list) +
                ", size=" + size +
                ", capacity =" + getCapacity() +
                '}';
    }
}
