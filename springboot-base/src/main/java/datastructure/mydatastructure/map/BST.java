package datastructure.mydatastructure.map;

public class BST<K extends Comparable<K>, V> {

    private final class Node {
        K k;
        V v;
        Node left;
        Node right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    private Node root;
    private int size;

    public BST() {
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private Node add(Node node, K k, V v) {

        if (node == null)
            return new Node(k, v);

        if (k.compareTo(node.k) < 0) {
            node.left = add(node.left, k, v);
        } else if (k.compareTo(node.k) > 0) {
            node.right = add(node.right, k, v);
        } else {
            node.v = v;
        }
        return node;
    }

    public boolean contains(K k){
        return contains(root,k);
    }

    private boolean contains(Node node,K k){
        if(k.compareTo(node.k)==0){
            return true;
        }else if(k.compareTo(node.k)<0){
            return contains(node.left,k);
        }else {
            return contains(node.right,k);
        }
    }

    public V get(K k){
        return get(root,k);
    }

    private V get(Node node,K k){
        if(k.compareTo(node.k)==0){
            return node.v;
        }else if(k.compareTo(node.k)<0){
            return get(node.left,k);
        }else {
            return get(node.right,k);
        }
    }

    public void remove(K k){
        root = remove(root,k);
    }

    private Node remove(Node node,K k){
        if(k.compareTo(node.k)<0){
            return remove(node.left,k);
        }else if(k.compareTo(node.k)>0){
            return remove(node.right,k);
        }else{
            if(node.left==null)
                return node.right;
            if(node.right==null)
                return node.left;

            Node max = maxRight(node);
            max.left = node.left;
            max.right = node.right;
            return max;
        }
    }

    private Node maxRight(Node node){
        if(node.right==null){
            return node;
        }else {
            return maxRight(node.right);
        }
    }

}
