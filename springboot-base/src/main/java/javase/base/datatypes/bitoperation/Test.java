package javase.base.datatypes.bitoperation;

public class Test {

    public static void main(String[] args) {
//        int a = 111;
//        int b = 88;
//        int c = 111;
//        int d = 5;
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(b));
//        System.out.println(Integer.toBinaryString(c));
//        System.out.println(Integer.toBinaryString(d));
//        //针对二进制，只要有一个为0，就为0
//        System.out.println("&运算："+Integer.toBinaryString(a&b));
//        //两个位只要有一个为1，那么结果就是1，否则就为0
//        System.out.println("|运算："+Integer.toBinaryString(a|b));
//        //针对二进制，相同的为0，不同的为1
//        System.out.println("^运算："+Integer.toBinaryString(a^c));
//        //针对二进制，0转1,1转0
//        System.out.println("~运算："+Integer.toBinaryString(~d+1));

        int e = 0000_0000;
        int f = 2_147_483_647;
        System.out.println(Integer.toBinaryString(f));
        System.out.println(f == Integer.MAX_VALUE);
    }
}
