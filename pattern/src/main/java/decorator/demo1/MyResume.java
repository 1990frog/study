package decorator.demo1;

public class MyResume implements Resume {
    @Override
    public void selfIntroduce() {
        System.out.println("姓名: 何甜甜");
        System.out.println("求职方向：服务端开发");
    }
}
