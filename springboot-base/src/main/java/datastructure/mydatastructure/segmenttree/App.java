package datastructure.mydatastructure.segmenttree;

public class App {

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        ArraySegmentTree<Integer> ast = new ArraySegmentTree<>(nums,(a,b)->a+b);
        System.out.println(ast);
    }
}
