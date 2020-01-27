package mydatastructure.bst;

public class BST<E extends Comparable<E>> {

    private final class Node {
        Node left;
        Node right;
        E e;
        public Node(E e){this.e = e;}
    }

    private Node root;
    private int size;

    public BST(){
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        if(root==null){
            root = new Node(e);
            size++;
        }else
            add(root,e);
    }
    private void add(Node node,E e){

        if(e.compareTo(node.e)==0){
            return;
        }else if(node.e.compareTo(e)>0 && node.left == null){
            node.left = new Node(e);
            size++;
            return;
        }else if(node.e.compareTo(e)<0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }

        if(e.compareTo(node.e)>0)
            add(node.right,e);
        else if(e.compareTo(node.e)<0)
            add(node.left,e);
    }

    public boolean contain(E e){
        return contain(root,e);
    }

    private boolean contain(Node node,E e){
        if(node!=null){
            if(node.e.compareTo(e)==0){
                return true;
            }

            if(node.e.compareTo(e)>0){
                return contain(node.left,e);
            }else
                return contain(node.right,e);
        }
        return false;
    }



    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(4);
        System.out.println(bst.contain(3));
    }
}
