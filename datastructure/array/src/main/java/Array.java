/**
 * <p>
 * Array—是基于索引(index)的数据结构，它使用索引在数组中搜索和读取数据是很快的。
 * Array获取数据的时间复杂度是O(1),但是要删除数据却是开销很大的，因为这需要重排数组中的所有数据。
 * List—是一个有序的集合，可以包含重复的元素，提供了按索引访问的方式，它继承Collection。
 * </p>
 *
 * @author cai
 * @since 2022/6/9
 */
public interface Array<E> {

    /**
     * 获取数组的容量
     * @return
     */
    int getCapacity();

    /**
     * 获取数组中的元素个数
     * @return
     */
    int getSize();

    /**
     * 返回数组是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 在index索引的位置插入一个新元素e
     * @param index
     * @param e
     */
    void add(int index, E e);

    /**
     * 获取index索引位置的元素 O(1)
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param e
     */
    void set(int index, E e);

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    int find(E e);

    /**
     * 从数组中删除index位置的元素, 返回删除的元素 O(n)
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 更换元素位置
     * @param i
     * @param j
     */
    void swap(int i,int j);

}
