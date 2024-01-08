package method;

import java.util.Objects;

public class CheckArgument {

    public void test(Integer a) {
//        Objects.requireNonNull(a);
        Objects.requireNonNull(a, "a为null");
    }

    public static void main(String[] args) {
        CheckArgument checkArgument = new CheckArgument();
        checkArgument.test(null);
    }
}
