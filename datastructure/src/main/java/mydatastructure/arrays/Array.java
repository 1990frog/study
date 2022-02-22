package mydatastructure.arrays;

public class Array<E> implements ArrayInterface<E>{

    //容器
    private E[] data;
    //下一位坐标
    private int size;

    /**
     * 初始构造器，默认容量10
     */
    public Array() {
        this(10);
    }

    /**
     * 指定初始化容量
     */
    public Array(int capacity) {
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
            resize(2 * size);

        for(int i = size - 1; i > index ; i --)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    /**
     * 数组尾部添加一个元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个新元素
     * 只有在最后加元素是O(1)，其余的都是O(n)
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 获取index索引位置的元素 O(1)
     */
    @Override
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e
     */
    @Override
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     */
    @Override
    public boolean contains(E e) {
        for (E cur : data) {
            if (cur.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     */
    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素 O(n)
     */
    @Override
    public E remove(int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for(int i = index + 1 ; i < size ; i ++)
            data[i -1] = data[i];//前移

        // 维护数组长度
        size --;
        // 跑到前面去了，不置null就有两个了
        data[size] = null;
        // 减容，注意避免复杂度震荡
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return ret;
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    /**
     * 将数组空间的容量变成newCapacity大小 O(n)
     */
    @Override
    public void resize(int newCapacity) {
        E[] newdata = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newdata[i] = data[i];
        }
        data = newdata;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (int i = 0; i < size; i++) {
            buffer.append(data[i]);
            if(i != size - 1)
                buffer.append(", ");
        }
        buffer.append("]");
        return buffer.toString();
    }

}
