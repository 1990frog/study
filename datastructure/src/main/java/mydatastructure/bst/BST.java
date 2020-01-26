package mydatastructure.bst;

public class BST<E extends Comparable<E>> {

    private final class Node {
        Node left;
        Node right;
        E e;
        public Node(E t){this.e = e;}
    }

    private Node root;
    private int size;

    public BST(){
    }

    public void add(E e){
        if(root==null)
            root = new Node(e);
        else
            add(root,e);
    }
    private void add(Node node,E e){
        if(node==null){
            root = new Node(e);
            size++;
        }
        if(e.compareTo(node.e)>0)
            add(node.right,e);
        else
            add(node.left,e);
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(1);
        bst.add(2);
        bst.add(3);
        System.out.println(bst);
    }
}
