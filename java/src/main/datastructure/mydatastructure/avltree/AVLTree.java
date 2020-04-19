package datastructure.mydatastructure.avltree;

import java.util.ArrayList;

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
            // 平衡因子
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

    // 获取节点node的平衡因子：left-right
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // 判断该二叉树是否是一棵二分搜索树，中序遍历从低到高
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for(int i = 1 ; i < keys.size() ; i ++) {
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

    /**
     * 判断是否平衡
     * left与right最大差为1
     */
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
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);

        // LL
        if(balanceFactor > 0 && getBalanceFactor(node.left) >= 0 ){
            return rightRotate(node);
        }
        // RR
        if(balanceFactor < 0 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        return node;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        // 向右旋转过程
        x.right = y;
        y.left = T3;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // 向右旋转过程
        x.left = y;
        y.right = T2;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
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

        if(node==null)
            return null;

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
