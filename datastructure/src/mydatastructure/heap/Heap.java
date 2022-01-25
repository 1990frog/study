package mydatastructure.heap;

public class Heap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public Heap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public Heap() {
        data = new ArrayList<>();
    }

    public int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return index / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 最大堆添加元素，直接加到数组最后，然后执行上浮操作
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    private void siftDown(int index) {
//        if(data.get(index).compareTo(data.get(leftChild(index))) > 0 && data.get(index).compareTo(data.get(rightChild(index))) >0)
//            return;
//
//        if(data.get(leftChild(index)).compareTo(data.get(rightChild(index)))>0){
//            data.swap(index,leftChild(index));
//            siftDown(leftChild(index));
//        }else{
//            data.swap(index,rightChild(index));
//            siftDown(rightChild(index));
//        }
        while (leftChild(index) < data.getSize()) {//考虑变量边界
            int j = leftChild(index);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)//右孩子的值大于左孩子的值
                j++;//取右孩子的值（选取左右最大值）
            if (data.get(index).compareTo(data.get(j)) >= 0)//终止条件
                break;
            data.swap(index, j);
            index = j;
        }

    }

    // 看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    public E extractMax() {

        E ret = findMax();

        data.swap(0, data.getSize() - 1);//将最大堆的root节点与最末尾的节点对换
        data.removeLast();
        siftUp(0);

        return ret;
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return data.removeLast();
    }


}
