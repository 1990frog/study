package mydatastructure.binarysearchtree;

public interface BSTInterface<E> {

    int size();//返回容器元素数量
    boolean isEmpty();//二分搜索树是否为null
    void add(E e);//添加元素
    boolean contain(E e);//包含元素
    void preOrder();//前序遍历
    void inOrder();//中序遍历
    void postOrder();//后续遍历
    void levelOrder();//层序遍历
    E minimum();//查找最小元素
    E maximum();//查找最大元素
    E removeMin();//删除最小元素
    E removeMax();//删除最大元素
    void remove(E e);//删除元素
}
