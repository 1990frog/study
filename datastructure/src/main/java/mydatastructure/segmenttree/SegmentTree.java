package mydatastructure.segmenttree;

public interface SegmentTree<E> {
    int getSize();
    E get(int index);
    E query(int queryL, int queryR);
}
