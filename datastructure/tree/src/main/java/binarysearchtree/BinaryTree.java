package binarysearchtree;

public interface BinaryTree<E> {

    /**
     * 返回二分搜索树中的元素个数
     * @return
     */
    int size();

    /**
     * 返回一个布尔值, 表示二分搜索树中是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 向二分搜索树中添加新的元素e
     *
     * @param e
     */
    void add(E e);

    /**
     * 看二分搜索树中是否包含元素e
     *
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return
     */
    E minimum();

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return
     */
    E maximum();

    /**
     * 二分搜索树的前序遍历
     */
    void dlr();

    /**
     * 二分搜索树的中序遍历
     */
    void ldr();

    /**
     * 二分搜索树的后续遍历
     */
    void lrd();

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     *
     * @return
     */
    E removeMin();

    /**
     * 从二分搜索树中删除最大值所在节点
     *
     * @return
     */
    E removeMax();

    /**
     * 删除指定元素
     *
     * @param e
     */
    void remove(E e);
}
