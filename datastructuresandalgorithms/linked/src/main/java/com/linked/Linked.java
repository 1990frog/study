package com.linked;

/**
 * <p>
 * 
 * </p>
 *
 * @author cai
 * @since 1/8/24
 */
public interface Linked<E> {

    /**
     * 获取链表元素个数
     * @return
     */
    int getSize();

    /**
     * 判断链表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 判断链表是否包含指定元素，o(n)
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 指定索引添加元素，o(n/2)=o(n)
     */
    void add(int index,E e);


    /**
     * 在链表首位添加元素，o(1)
     * @param e
     */
    void addFirst(E e);

    /**
     * 在链表末尾添加元素，o(1)
     * @param e
     */
    void addLast(E e);//o(n)

    /**
     * 删除指定索引位置元素，o(n/2)=o(n)
     */
    E remove(int index);

    /**
     * 删除第一个元素，o(1)
     * @return
     */
    E removeFirst();

    /**
     * 删除末尾元素
     * @return
     */
    E removeLast();//o(n)

    /**
     * 删除指定元素，o(n)
     * @param e
     */
    void removeElement(E e);

    /**
     * 修改操作，o(n)
     */
    void set(int index,E e);

    /**
     * 查找操作，o(n)
     */
    E get(int index);

    /**
     * 获取第一个元素
     * @return
     */
    E getFirst();

    /**
     * 删除最后一个元素
     * @return
     */
    E getLast();

}
