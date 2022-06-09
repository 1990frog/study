package test;

import binarysearchtree.Tree;

public class BST<E extends Comparable> implements Tree<E> {

    class Node {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    @Override
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    @Override
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else if (e.compareTo(node.e) > 0)
            return contains(node.right, e);
        else
            return true;
    }

    @Override
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    @Override
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    @Override
    public void dlr() {
        dlr(root);
    }

    private void dlr(Node node) {
        if (node == null)
            return;
        System.out.println(node.e);
        dlr(node.left);
        dlr(node.right);
    }

    @Override
    public void ldr() {
        ldr(root);
    }

    private void ldr(Node node) {
        if (node == null)
            return;
        ldr(node.left);
        System.out.println(node.e);
        ldr(node.right);
    }

    @Override
    public void lrd() {
        lrd(root);
    }

    private void lrd(Node node) {
        if (node == null)
            return;
        lrd(node.left);
        lrd(node.right);
        System.out.println(node.e);
    }

    @Override
    public E removeMin() {
        E ret = minimum();
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

    @Override
    public E removeMax() {
        E ret = maximum();
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
        node.right = removeMin(node.right);
        return node;
    }

    @Override
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0)
            node.left = remove(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = remove(node.right, e);
        else {
            if(node.left == null){
                size--;
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            } else if (node.right == null){
                size--;
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            } else {
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
        return node;
    }
}
