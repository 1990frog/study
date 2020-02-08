package mydatastructure.heap;

public class Heap<E extends Comparable<E>> {

    private ArrayList<E> list;

    public Heap(int capacity){
        list = new ArrayList<>(capacity);
    }

    public Heap(){
        list = new ArrayList<>();
    }

    public int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return index/2;
    }

    public int leftChild(int index){
        return index*2+1;
    }

    public int rightChild(int index){
        return index*2+2;
    }

    public int getSize(){
        return list.getSize();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }


}
