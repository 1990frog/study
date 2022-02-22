package mydatastructure.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> implements BSTInterface<E> {

    /**
     * 二分搜索树节点
     */
    private final class Node {
        Node left;
        Node right;
        E e;
        public Node(E e){this.e = e;}
    }

    //根节点
    private Node root;
    //元素个数
    private int size;

    public BST(){
    }

    /**
     * 元素个数
     */
    @Override
    public int size(){
        return size;
    }

    /**
     * 二分搜索树是否为null
     */
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加元素
     */
    @Override
    public void add(E e){
        root = add(root,e);
    }

    /**
     * 递归从根节点添加元素
     */
    public Node add(Node node,E e){

        // 递归终结条件，并返回添加节点关联上级节点
        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)//左子树赋值
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)//右子树赋值
            node.right = add(node.right, e);

        return node;//最终返回root根节点
    }


    /**
     * 验证是否包含元素
     */
    @Override
    public boolean contain(E e){
        return contain(root,e);
    }


    /**
     * 递归判断
     */
    private boolean contain(Node node,E e){

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

    /**
     * 前序遍历
     */
    @Override
    public void preOrder(){
        this.preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    @Override
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

    /**
     * 后序遍历
     */
    @Override
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

    /**
     * 层序遍历
     */
    @Override
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

    /**
     * 寻找二分搜索树的最小元素
     */
    @Override
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     */
    private Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     */
    @Override
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     */
    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     */
    @Override
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     */
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

    /**
     * 从二分搜索树中删除最大值所在节点
     */
    @Override
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

    /**
     * 从二分搜索树中删除元素为e的节点
     */
    @Override
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

}
