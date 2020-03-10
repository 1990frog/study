package base.reflection.entity;

public class Children extends Parent  {

    @Override
    public String toString() {
        return "children";
    }

    private void privateMethod(){
        System.out.println("private method");
    }

    public static void staticMehtod1(){}
    private static void staticMehtod2(){}

}
