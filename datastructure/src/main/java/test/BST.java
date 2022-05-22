package test;

import binarysearchtree.Tree;

public class BST<E extends Comparable<E>> implements Tree<E> {

    class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

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
        if (e.compareTo(node.e) == 1)
            return contains(node.right, e);
        else
            return true;

    }

    @Override
    public E minimum() {
        Node ret = minimum(root);
        return ret == null ? null : ret.e;
    }

    private Node minimum(Node node) {
        if (node == null)
            return null;
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    @Override
    public E maximum() {
        Node ret = maximum(root);
        return ret == null ? null : ret.e;
    }

    private Node maximum(Node node) {
        if (node == null)
            return null;
        if (node.right == null)
            return node;
        return minimum(node.right);
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
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node == null)
            return null;
        if (node.left == null) {
            size--;
            return node.right;
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
        if (node == null)
            return null;
        if (node.right == null) {
            size--;
            return node.left;
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

        if (e.compareTo(node.e) == -1) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) == 1) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            } else {
                Node successer = minimum(node.left);
                successer.left = removeMin(node);
                successer.right = node.right;
                size--;
                return successer;
            }
        }

    }
}
