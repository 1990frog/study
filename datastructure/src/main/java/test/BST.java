package test;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/5/5
 */
public class BST<E extends Comparable> {

    private Node<E> root;
    private int size;

    private class Node<E> {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }

//    public void add(E e) {
//    }
//
//
//
//    public boolean contains(E e) {
//    }
//
//
//    public E mixinum() {
//    }
//
//    public E muxinum(){
//    }
//
//    public void LDR(){
//        LDR(root);
//    }
//    private void LDR(Node node){
//        if(node==null)
//            return;
//        LDR(node.left);
//        System.out.println(node.e);
//        LDR(node.right);
//    }


}
