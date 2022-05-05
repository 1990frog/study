package binarysearchtree

/**
 * <p>
 * ${description}
 * </p>
 *
 * @author cai
 * @since 2022/5/5
 */
class BST<E extends Comparable> {

    private Node<E> root;
    private int size;

    private class Node<E> {
        E e
        Node left, right
        Node(E e) {
            this.e = e
        }
    }

    void add(E e){

    }
    Node add(Node node,E e){
        return null;
    }


}
