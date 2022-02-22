package playdatastructure.unionfind.optimizedBySize;

import datastructure.mydatastructure.unionfind.UnionFind1st;
import datastructure.mydatastructure.unionfind.UnionFind2nd;
import datastructure.mydatastructure.unionfind.UnionFind3rd;

import java.util.Random;

public class Pk {

    private static double testUF(UF uf, int m){

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for(int i = 0 ; i < m ; i ++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;

        UnionFind1st uf1 = new UnionFind1st(size);
        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");

        UnionFind2nd uf2 = new UnionFind2nd(size);
        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");

        UnionFind3rd uf3 = new UnionFind3rd(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");
    }
}
