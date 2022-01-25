package command.demo1;

/**
 * 具体命令类实现了命令类接口，
 * 它与请求接收者相关联，
 * 实现了在抽象命令类中声明的execute()方法，
 * 并在实现时调用接收者的请求响应方法action()
 */
public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
