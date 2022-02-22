package command.demo1;

/**
 * Command类：是一个抽象类，类中对需要执行的命令进行声明，一般来说要对外公布一个 execute 方法用来执行命令。
 * ConcreteCommand类：Command类的实现类，对抽象类中声明的方法进行实现。
 * Invoker类：调用者，负责调用命令。
 * Receiver类：接收者，负责接收命令并且执行命令。
 *
 * 当我们调用时，
 * 执行的时序首先是调用者类，
 * 然后是命令类，
 * 最后是接收者类。
 * 也就是说一条命令的执行被分成了三步，
 * 它的耦合度要比把所有的操作都封装到一个类中要低的多，
 * 而这也正是命令模式的精髓所在：
 * 把命令的调用者与执行者分开，
 * 使双方不必关心对方是如何操作的。
 */
public class Client {

    public static void main(String[] args) {
        Receiver r = new Receiver();
        Command c = new ConcreteCommand(r);
        // 客户端直接执行具体命令方式（此方式与类图相符）
        c.execute();

        Invoker i = new Invoker();
        i.setCommand(c);
        // 客户端通过调用者来执行命令
        i.call();
    }

}
