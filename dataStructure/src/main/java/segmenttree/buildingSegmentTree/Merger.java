package segmenttree.buildingSegmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}
