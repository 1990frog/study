package com.array;

/**
 * <p>
 * 原生数组 E[]
 * 自定义动态数据 ArrayList
 * </p>
 *
 * @author cai
 * @since 2022/8/10
 */
public class ArrayList<E> implements Array<E> {

    // 原生容器，静态数组
    private E[] data;
    // 元素个数，下位索引
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public ArrayList(int capacity) {
        /*java不支持new E[size],(E[])new Object[size]*/
        data = (E[]) new Object[capacity];
        size = 0;
    }
    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public ArrayList() {
        this(10);
    }

    /**
     * 获取数组的容量
     * @return
     */
    @Override
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在index索引的位置插入一个新元素e，O(n)
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {
        // 校正边界
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        // 容器满了就扩容
        if (size == getCapacity())
            // java 默认是1.5倍
            resize(2 * data.length);

        // size-1 是最后一个元素索引位置，[index, size-1]这些元素位置向后迁移
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        // 指定位置 index 元素空了，赋予新值
        data[index] = e;

        // 维护 size 个数
        size++;
    }

    /**
     * 向所有元素后添加一个新元素，O(1)
     * @param e
     */
    public void addLast(E e) {
        // size - 1 是最后一个元素，size 是最后一个元素下一位
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素，O(n)
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取index索引位置的元素，O(1)
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e，O(1)
     * @param index
     * @param e
     */
    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e，O(n)
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1，O(n)
     * @param e
     * @return
     */
    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素，O(n)
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null; // loitering objects != memory leak

        // 避免复杂度震荡
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素，O(n)
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素，O(1)
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e，O(n-1)
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    /**
     * 将数组空间的容量变成newCapacity大小
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        // if (size >= 0) System.arraycopy(data, 0, newData, 0, size);

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }


}
