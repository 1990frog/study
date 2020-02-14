package base.lambda.im;

public class App2 {

    interface Param1{
        void outInfo(String info);
    }
    interface Param2{
        void outInfo(String info);
    }

    public void lambdaMethod(Param1 param){
        param.outInfo("hello param1");
    }

    public void lambdaMethod(Param2 param){
        param.outInfo("hello param2");
    }

    public static void main(String[] args) {
        App2 app2 = new App2();
        app2.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });
        app2.lambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });
    }
}
