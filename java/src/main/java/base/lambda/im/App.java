package base.lambda.im;

public class App {
    String s1 = "全量变量";

    // 1.匿名内部类型中对于变量的访问
    public void testInnerClass(){
        String s2 = "局部变量";

        new Thread(new Runnable() {
            String s3 = "内部变量";
            @Override
            public void run() {
                // 访问全局变量
                System.out.println(s1);
                //this关键字表示是当前内部类的对象
//                System.out.println(this.s1);
                //局部变量的访问，不能对局部变量进行数据的修改[final]
                System.out.println(s2);
//                s2 = "hello";
                System.out.println(s3);
                System.out.println(this.s3);
            }
        }).start();
    }

    public void testLambda(){
        String s2 = "局部变量Lambda";
        new Thread(()->{
            String s3 = "内部变量Lambda";

            // 访问全局变量
            //this关键字表示是当前内部类的对象
            System.out.println(this.s1);
            // 访问局部变量
            System.out.println(s2);
            //局部变量的访问，不能对局部变量进行数据的修改[final]
//            s2 = "hello";
            s3 = "lamdba 内部变量修改";
            System.out.println(s3);
        }).start();
    }
}
