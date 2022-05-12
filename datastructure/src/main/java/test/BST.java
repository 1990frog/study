package test;

import binarysearchtree.Tree;

public class BST<E extends Comparable<E>> implements Tree<E> {

    private Node root;
    private int size;

    class Node {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }

    @Override
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null)
            return new Node(e);

        if (e.compareTo(node.e) == -1)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) == 1)
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

        if (e.compareTo(node.e) == -1)
            return contains(node.left, e);
        else if (e.compareTo(node.e) == 1)
            return contains(node.right, e);
        else
            return true;
    }

    @Override
    public E minimum() {
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    @Override
    public E maximum() {
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
        dlr(node.left);
        System.out.println(node.e);
        dlr(node.right);
    }

    @Override
    public void lrd() {
        lrd(root);
    }

    private void lrd(Node node) {
        if (node == null)
            return;
        dlr(node.left);
        dlr(node.right);
        System.out.println(node.e);
    }

    @Override
    public E removeMin() {
        Node ret = minimum(root);
        return ret.e;
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
        return removeMax(root).e;
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

    @Override
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) == -1) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) == 1) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.right = null;
                return leftNode;
            }
            Node successor = minimum(node.left);
            successor.left = removeMin(node.left);
            successor.right = node.right;
            node.left = node.right = null;
            return successor;
        }
    }
}
