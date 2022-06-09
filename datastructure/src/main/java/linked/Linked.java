package linked;

public interface Linked<E> {
    /**
     * 添加操作
     */
    void addLast(E e);//o(n)
    void addFirst(E e);//o(1)
    void add(int index,E e);//o(n/2)=o(n)
    /**
     * 删除操作o(n)
     */
    E removeLast();//o(n)
    E removeFirst();//o(1)
    E remove(int index);//o(n/2)=o(n)
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
    boolean contains(E e);//o(n)
//    int find(E e);//o(n)

    int getSize();
    boolean isEmpty();
}
