package mydatastructure.heap;

public class Heap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public Heap(int capacity){
        data = new ArrayList<>(capacity);
    }

    public Heap(){
        data = new ArrayList<>();
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
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void add(E e){
        data.addLast(e);
        shitUp(getSize()-1);
    }

    public void remove(E e){
        data.remove(data.find(e));
    }

    private void shitUp(int index){
        while (index>0 && data.get(parent(index)).compareTo(data.get(index))<0){
            data.swap(index,parent(index));
            index = parent(index);
        }
    }


}
