package datastructure.mydatastructure.avltree;

import java.util.ArrayList;
import java.util.Optional;

public class AVLTree<K extends Comparable<K>, V> {

    /**
     * 存储节点（key,value,左孩子,右孩子,高度）
     */
    private final class Node {
        K k;
        V v;
        Node left;
        Node right;
        int height;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    // 根节点
    private Node root;
    // 节点数
    private int size;

    // 初始化节点
    public AVLTree() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 获取节点高度
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // 获取节点node的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // 判断该二叉树是否是一棵二分搜索树
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0)
                return false;
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null)
            return;
        inOrder(node.left, keys);
        keys.add(node.k);
        inOrder(node.right, keys);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    public boolean isBalanced(Node node) {
        if (node == null)
            return true;

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private Node add(Node node, K k, V v) {

        if (node == null) {
            size++;
            return new Node(k, v);
        }

        if (k.compareTo(node.k) < 0) {
            node.left = add(node.left, k, v);
        } else if (k.compareTo(node.k) > 0) {
            node.right = add(node.right, k, v);
        } else {
            node.v = v;
        }

        // 更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            System.out.println("unbalanced" + balanceFactor);
        return node;
    }

    public boolean contains(K k) {
        return contains(root, k);
    }

    private boolean contains(Node node, K k) {
        if (k.compareTo(node.k) == 0) {
            return true;
        } else if (k.compareTo(node.k) < 0) {
            return contains(node.left, k);
        } else {
            return contains(node.right, k);
        }
    }

    public V get(K k) {
        return get(root, k);
    }

    private V get(Node node, K k) {
        if (k.compareTo(node.k) == 0) {
            return node.v;
        } else if (k.compareTo(node.k) < 0) {
            return get(node.left, k);
        } else {
            return get(node.right, k);
        }
    }

    public void remove(K k) {
        root = remove(root, k);
    }

    private Node remove(Node node, K k) {
        if (k.compareTo(node.k) < 0) {
            return remove(node.left, k);
        } else if (k.compareTo(node.k) > 0) {
            return remove(node.right, k);
        } else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            Node max = maxRight(node);
            max.left = node.left;
            max.right = node.right;
            return max;
        }
    }

    private Node maxRight(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return maxRight(node.right);
        }
    }

}
