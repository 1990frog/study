package bobo.playdatastructure.segmenttree.updateSingleElementInSegmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}
