package mydatastructure.bst;

import bobo.playdatastructure.linkedlist.implementQueue.LinkedListQueue;
import bobo.playdatastructure.linkedlist.implementStack.LinkedListStack;
import bobo.playdatastructure.linkedlist.implementStack.Stack;

import java.util.LinkedList;
import java.util.Queue;

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

//    public void add(E e){
//        if(root==null){
//            root = new Node(e);
//            size++;
//        }else
//            add(root,e);
//    }
//    private void add(Node node,E e){
//
//        if(e.compareTo(node.e)==0){
//            return;
//        }else if(node.e.compareTo(e)>0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if(node.e.compareTo(e)<0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if(e.compareTo(node.e)>0)
//            add(node.right,e);
//        else if(e.compareTo(node.e)<0)
//            add(node.left,e);
//    }
    public void add(E e){
        root = add(root,e);
    }

    public Node add(Node node,E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);//子树赋值
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;//这是root，根赋值
    }

    public boolean contain(E e){
        return contain(root,e);
    }

    private boolean contain(Node node,E e){
//        if(node!=null){
//            if(node.e.compareTo(e)==0){
//                return true;
//            }
//
//            if(node.e.compareTo(e)>0){
//                return contain(node.left,e);
//            }else
//                return contain(node.right,e);
//        }
//        return false;

        if(node==null)
            return false;

        if(e.compareTo(node.e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contain(node.left,e);
        }else{
            return contain(node.right,e);
        }
    }

    public void preOrder(){
        this.preOrder(root);
    }

    /**
     * 前序遍历
     */
    private void preOrder(Node node){
//        System.out.println(node.e);
//        if(node.left!=null)
//            preOrder(node.left);
//        if(node.right!=null)
//            preOrder(node.right);

        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        this.inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        this.postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.right);
        System.out.println(node.e);
        postOrder(node.left);
    }

    // 二分搜索树的层序遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }
        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node,E e){

        if(node==null)
            return null;

        if(e.compareTo(node.e)<0){
//            return remove(node.left,e);
            node.left = remove(node.left,e);
            return node;
        }
        else if(e.compareTo(node.e)>0){
//            return remove(node.right,e);
            node.right =  remove(node.right,e);
            return node;
        }else{
//            if(node.left==null){
//                node = node.right;
//                size--;
//                return node;
//            }
//            if(node.right==null){
//                node = node.left;
//                size--;
//                return node;
//            }
//            Node leftNode = node.left;
//            Node rightNode = node.right;
//            node = removeMin(node);
//            node.left = leftNode;
//            node.right = rightNode;

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点（左子树最大节点也可）
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);//后继
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }

    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(4);
//        System.out.println(bst.contain(3));
//        bst.preTraverse();
//        bst.midTraverse();
//        bst.levelOrder();
//        System.out.println(bst.minimum());
//        System.out.println(bst.maximum());
//        bst.removeMax();
//        bst.inOrder();
        bst.levelOrder();
        System.out.println("---");
        bst.remove(3);
        bst.levelOrder();
    }
}
