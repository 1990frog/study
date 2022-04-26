package array;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/4/26
 */
public class ArrayListStack<E> implements Stack<E> {

    private ArrayList<E> data;

    public ArrayListStack() {
        data = new ArrayList<>();
    }

    public ArrayListStack(int capacity) {
        data = new ArrayList<>(capacity);
    }

    @Override
    public void push(E o) {
        data.add(o);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.get(data.getSize() - 1);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public String toString() {
        return "ArrayListStack{" +
                "data=" + data +
                '}';
    }
}
