package functioninterface;

public class BasicTypeDoubleToIntTest {

    @FunctionalInterface
    interface BasicTypeDoubleToInt {
        int convert(double a);
    }

    public static void main(String[] args) {
        BasicTypeDoubleToInt basicTypeDoubleToInt = (double a) -> (int) a;
        System.out.println(basicTypeDoubleToInt.convert(22.99));
//        IntPredicate
    }
}
