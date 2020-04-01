package datastructure.mydatastructure.unionfind;

public interface UF {
    int getSize();
    int find(int p);
    // 将两个元素相连
    boolean isConnected(int p,int q);
    // 将两个元素合并到一起
    void unionElements(int p,int q);
}
