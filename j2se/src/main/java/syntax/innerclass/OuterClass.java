package syntax.innerclass;

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
        Inner1 inner1 = new OuterClass().new Inner1();
        Inner2 inner2 = new OuterClass().new Inner2();
        Inner3 inner3 = new Inner3();
    }
}
