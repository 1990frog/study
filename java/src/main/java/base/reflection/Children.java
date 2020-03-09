package base.reflection;

public class Children extends Parent  {

    @Override
    public String toString() {
        return "children";
    }

    private String privateMethod(){
        return "private";
    }

    public static void staticMehtod1(){}
    private static void staticMehtod2(){}

}
