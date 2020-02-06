package mydatastructure.bst;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(4);
//        System.out.println(bst.contain(3));
//        bst.preTraverse();
//        bst.midTraverse();
//        bst.levelOrder();
//        System.out.println(bst.minimum());
//        System.out.println(bst.maximum());
//        bst.removeMax();
//        bst.inOrder();
        bst.levelOrder();
        System.out.println("---");
        bst.remove(3);
        bst.levelOrder();
    }
}
