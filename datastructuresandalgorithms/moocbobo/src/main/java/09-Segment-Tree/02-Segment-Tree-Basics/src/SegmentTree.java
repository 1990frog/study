public class SegmentTree<E> {

    private final E[] tree;
    private final E[] data;

    public SegmentTree(E[] arr){

        data = (E[])new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);

        tree = (E[])new Object[4 * arr.length];
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2*index + 2;
    }
}
