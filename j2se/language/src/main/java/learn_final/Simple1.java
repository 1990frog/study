package learn_final;

public class Simple1 {

    private final String v1;

    private final static String v2;

    static {
        v2 = "abc";
    }

    public Simple1() {
        v1 = v2;
    }
}
