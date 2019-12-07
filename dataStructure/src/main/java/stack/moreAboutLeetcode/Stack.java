package stack.moreAboutLeetcode;

/**
 * 定义栈的行为
 * @param <E>
 */
public interface Stack<E> {
    int getSize();//获取容量
    boolean isEmpty();//是否空
    void push(E e);//入栈
    E pop();//出栈
    E peek();//查看栈顶
}
