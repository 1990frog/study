package test;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/5/6
 */
public class BST<E extends Comparable> {

    private Node root;
    private int size;

    private class Node {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    public BST() {

    }

    public void add(E e) {
        add(root, e);
    }

    private Node add(Node node, E e) {

        if (node == null){
            size++;
            return new Node(e);
        }

        if (node.e.compareTo(e) < 0)
            node.left = add(node.left, e);
        if (node.e.compareTo(e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    public E mininum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return mininum(root).e;
    }

    private Node mininum(Node node) {
        if (node.left == null)
            return node;
        return mininum(node.left);
    }

    public E maxinum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maxinum(root).e;
    }

    private Node maxinum(Node node) {
        if (node.right == null)
            return node;
        return maxinum(node.right);
    }

    /**
     * 遍历
     * DLR 前序
     * LDR 中序
     * DRL 后序
     */
    public void DLR() {
        DLR(root);
    }

    private void DLR(Node node) {
        if (node != null) {
            System.out.println(node.e);
            DLR(node.left);
            DLR(node.right);
        }
    }

    public E removeMax() {
        E ret = maxinum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E removeMin() {
        E ret = mininum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

//    public void remove(E e) {
//        remove(root, e);
//    }
//
//    private Node remove(Node node, E e) {
//        if (node == null)
//            return null;
//
//        if(node.e.equals(e)<0){
//
//        }
//        if (e.compareTo(node.e) == 0) {
//            if (node.left == null)
//                return node.right;
//            if (node.right == null)
//                return node.left;
//
//            // 子节点都存在，将该节点的后缀节点升级
//            Node successor = mininum(node.right);
//            successor.right = removeMin(node.right);
//            successor.left = node.left;
//            node.left = node.right = null;
//            return successor;
//        }
//
//        node.right = remove(node.right, e);
//
//        return node;
//    }

}
