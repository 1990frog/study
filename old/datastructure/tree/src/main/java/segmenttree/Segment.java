package segmenttree;

public interface Segment<E> {

    int getSize();

    E get(int index);

    E query(int queryL, int queryR);

    void set(int index, E e);

}
