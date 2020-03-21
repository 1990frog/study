package mydatastructure.unionfind;

/**
 * Union Union
 * 每个节点最初都是指向自身-->最终指向自身的一定是根节点
 */
public class UnionFind4th implements UF {

    private int[] parent; // parent[i]表示第一个元素所指向的父节点
    private int[] rank;     // rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind4th(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        } else{ // sz[qRoot] <= sz[pRoot]
            parent[qRoot] = pRoot;
            rank[pRoot]+=1;
        }
    }
}
