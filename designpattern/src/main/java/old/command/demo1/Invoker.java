package old.command.demo1;

import lombok.Setter;

/**
 * 对于请求发送者即调用者而言，
 * 将针对抽象命令类进行编程，
 * 可以通过构造注入或者设值注入的方式在运行时传入具体命令类对象，
 * 并在业务方法中调用命令对象的execute()方法
 */
@Setter
public class Invoker {
    private Command command;

    public Invoker() {
    }

    public void call() {
        command.execute();
    }
}
