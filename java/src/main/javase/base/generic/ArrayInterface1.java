package javase.base.generic;


public interface ArrayInterface1{
    // 获取数组的容量
    int getCapacity();
    // 获取数组中的元素个数
    int getSize();
    // 返回数组是否为空
    boolean isEmpty();
    // 在index索引的位置插入一个新元素e O(n/2)=O(n) 严格计算需要一些概率论知识
    <E>void add(int index, E e);
    //获取index索引位置的元素 O(1)
    <E>E get(int index);
    // 修改index索引位置的元素为e
    <E>void set(int index, E e);
    // 查找数组中是否有元素e
    <E>boolean contains(E e);
    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    <E>int find(E e);
    // 从数组中删除index位置的元素, 返回删除的元素 O(n)
    <E>E remove(int index);
    // 将数组空间的容量变成newCapacity大小 O(n)
    void resize(int newCapacity);
}
