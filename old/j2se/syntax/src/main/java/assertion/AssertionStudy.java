package assertion;

/**
 * 使用断言 assert 需要设置虚拟机参数 -ea (-enableassertions)
 */
public class AssertionStudy {

    private static void test1(long a[], int b, int c) {
        assert a != null;
        assert b >= 0 && b < c;
        System.out.println("OK");
    }

    public static void main(String[] args) {
        long[] a = {1L,2L};
        test1(a,1,2);
        test1(a,2,1);
    }
}
