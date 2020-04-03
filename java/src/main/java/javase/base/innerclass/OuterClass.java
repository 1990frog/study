package javase.base.innerclass;

public class OuterClass {

    private int age = 20;

    /**
     * 通用型
     */
    class Inner1{
        public void show(){
            System.out.println(age);
        }
    }

    /**
     * 自闭
     */
    private class Inner2{
        public void show(){
            System.out.println(age);
        }
    }

    static class Inner3{
        public void show(){
            System.out.println("static args");
        }
    }

    public static void main(String[] args) {
        OuterClass.Inner1 inner1 = new OuterClass().new Inner1();
        OuterClass.Inner2 inner2 = new OuterClass().new Inner2();
        OuterClass.Inner3 inner3 = new OuterClass.Inner3();
    }
}
