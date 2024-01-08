package com.unionfind;

public interface UF {

    int getSize();

    /**
     * 判断两个元素是否是相连的
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p,int q);

    /**
     * 关联两个元素
     * @param p
     * @param q
     */
    void unionElements(int p, int q);
}
