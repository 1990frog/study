package com.segmenttree;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/7/15
 */
public class Main {

     public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);

        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }
}
