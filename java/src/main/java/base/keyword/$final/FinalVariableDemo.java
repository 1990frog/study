package base.keyword.$final;

public class FinalVariableDemo {

    private final int a;//方法一直接赋值

    public FinalVariableDemo(int a){//方法二构造器赋值
        this.a = a;
    }

//    public FinalVariableDemo{
//
//    }

//    {
//        a=7;//方法三静态域赋值
//    }

    public void dosomething(){
        final Integer b;
        b = null;
        System.out.println(b);
    }

    public static void main(String[] args) {
        FinalVariableDemo demo = new FinalVariableDemo(1);
        demo.dosomething();
    }

}
