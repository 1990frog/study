package datastructure.mydatastructure.unionfind;

import java.util.Random;

public class TestUF {

    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000000;
        int m = 10000000;
//        UnionFind1st uf1 = new UnionFind1st(size);
//        System.out.println("UnionFind1: "+ testUF(uf1,m)+ "s");
//
//        UnionFind2nd uf2 = new UnionFind2nd(size);
//        System.out.println("UnionFind2: "+ testUF(uf2,m)+ "s");

        UnionFind3rd uf3 = new UnionFind3rd(size);
        System.out.println("UnionFind3: "+ testUF(uf3,m)+ "s");

        UnionFind4th uf4 = new UnionFind4th(size);
        System.out.println("UnionFind4: "+ testUF(uf4,m)+ "s");

        UnionFind5th uf5 = new UnionFind5th(size);
        System.out.println("UnionFind5: "+ testUF(uf5,m)+ "s");
    }
}
