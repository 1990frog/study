package syntax.datatypes;

public class FloatTest {

    /**
     * 0.060000000000000005
     * 0.5800000000000001
     * 401.49999999999994
     * 1.2329999999999999
     * 4.01
     */
    public static void main(String[] args) {
        // 0.060000000000000005
        System.out.println(0.05+0.01);
        // 0.5800000000000001
        System.out.println(1.0-0.42);
        // 401.49999999999994
        System.out.println(4.015*100);
        // 1.2329999999999999
        System.out.println(123.3/100);
        // 4.01 四舍五入保留两位
        System.out.println(Math.round(4.015*100)/100.0);

        double a = 0.05;
        double b = 0.01;
        System.out.println(a+b);

        Double c = 0.05;
        Double d = 0.01;
        System.out.println(c+d);
    }
}
