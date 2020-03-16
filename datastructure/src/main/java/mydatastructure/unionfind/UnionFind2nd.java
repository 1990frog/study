package mydatastructure.unionfind;

/**
 * Union Union
 * 每个节点最初都是指向自身-->最终指向自身的一定是根节点
 */
public class UnionFind2nd implements UF {

    // 我们的第二版Union-Find, 使用一个数组构建一棵指向父节点的树
    // parent[i]表示第一个元素所指向的父节点
    private int[] parent;

    public UnionFind2nd(int size) {
        parent = new int[size];
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    @Override
    public int find(int p) {

        if (p < 0 || p > getSize())
            throw new IllegalArgumentException();

        while (p != parent[p])
            p = parent[p];

        return p;
    }

    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
//        if(find(p)==find(q))
//            return true;
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }
}
