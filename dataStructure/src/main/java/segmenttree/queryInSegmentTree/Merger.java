package segmenttree.queryInSegmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}
