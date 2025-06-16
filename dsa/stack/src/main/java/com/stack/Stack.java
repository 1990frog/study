package com.stack;

/**
 * Last In First Out (LIFO)
 *
 * 多种底层实现方式：
 * 1. 基于动态数组 @see ArrayListStack
 *
 * @param <E>
 */
public interface Stack<E> {
    /**
     * 入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 查看栈顶
     * @return
     */
    E peek();

    /**
     * 查看元素格式
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
