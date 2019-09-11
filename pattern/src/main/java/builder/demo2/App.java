package builder.demo2;

public class App {

    public static void main(String[] args) {
        //具体创建者
        MyRobustBuilder myRobustBuilder = new MyRobustBuilder();
        //指导者
        RobustDirector robustDirector = new RobustDirector(myRobustBuilder);
        Robust robust = robustDirector.buildRobust("玩具头", "玩具体");
        System.out.println(robust);
    }
}
