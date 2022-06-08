package array;

import java.util.Arrays;

public class ArrayList<E> implements Array<E> {

    // 原生容器
    private E[] data;
    // 元素个数，下位索引
    private int size;

    /**
     * 初始构造器，默认容量10
     */
    public ArrayList() {
        this(10);
    }

    /**
     * 指定初始化容量
     */
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * 返回当前数组容积
     */
    @Override
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数(下一个坐标)
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在index索引的位置插入一个新元素（不是替换掉元素，而是向后挤）
     */
    @Override
    public void add(int index, E e) {

        // 校正边界
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        // 容器满了就扩容
        if (size == getCapacity())
            resize(2 * data.length);

        for (int i = size - 1; i > index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    /**
     * 数组尾部添加一个元素
     */
    public void addLast(E e) {
        this.add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     * 只有在最后加元素是O(1)，其余的都是O(n)
     */
    public void addFirst(E e) {
        add(0, e);
    }


    /**
     * 获取index索引位置的元素 O(1)
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return this.data[index];
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        this.data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     */
    @Override
    public boolean contains(E e) {
        return this.find(e) > -1;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     */
    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(data[i]))
                return 1;
        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素 O(n)
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = this.data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];//前移

        // 前移最后一个元素置空
        data[--size] = null;

        // 减容，注意避免复杂度震荡 data.length = 1 时，缩容capacity=0，存在bug
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return ret;
    }

    /**
     * 更换指定序列元素
     *
     * @param i
     * @param j
     */
    @Override
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    /**
     * 将数组空间的容量变成newCapacity大小 O(n)
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    @Override
    public String toString() {
        return "ArrayList{" + "data=" + Arrays.toString(data) + ", size=" + size + ", capacity=" + data.length + '}';
    }

}
