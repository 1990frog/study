package pattern.command.demo1;

/**
 * 请求接收者Receiver类具体实现对请求的业务处理，
 * 它提供了action()方法，
 * 用于执行与请求相关的操作
 */
public class Receiver {
    public void action() {
        System.out.println("--------let us go to play computer game--------");
    }
}
