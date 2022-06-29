package linked;

public interface Linked<E> {

    int getSize();
    boolean isEmpty();
    boolean contains(E e);//o(n)

    /**
     * 添加操作
     */
    void add(int index,E e);//o(n/2)=o(n)
    void addFirst(E e);//o(1)
    void addLast(E e);//o(n)
    /**
     * 删除操作o(n)
     */
    E remove(int index);//o(n/2)=o(n)
    E removeFirst();//o(1)
    E removeLast();//o(n)
    void removeElement(E e);
    /**
     * 修改操作
     */
    void set(int index,E e);//o(n)
    /**
     * 查找操作
     */
    E get(int index);//o(n)
    E getFirst();
    E getLast();

}
