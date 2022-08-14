package old.command.demo2;

/**
 * 如果需要修改功能键的功能，
 * 例如某个功能键可以实现“打开音乐播放器”，
 * 只需要对应增加一个新的具体命令类，
 * 在该命令类与“打开音乐播放器请求处理者”(MusicHandler)之间创建一个关联关系，
 * 然后将该具体命令类的对象通过配置文件注入到某个功能键即可，
 * 原有代码无须修改，符合“开闭原则”。
 * 在此过程中，
 * 每一个具体命令类对应一个请求的处理者（接收者），
 * 通过向请求发送者（调用者）注入不同的具体命令对象可以使得相同的发送者对应不同的接收者，
 * 从而实现“将一个请求封装为一个对象，用不同的请求对客户进行参数化”，
 * 客户端只需要将具体命令对象作为参数注入请求发送者，
 * 无须直接操作请求的接收者。
 *
 */
public class Client {
    public static void main(String[] args) {
        // 调用者
        Button button = new Button();
        // 这里可以通过配置文件获取具体命令名字，然后通过反射实例化具体命令，这样更换命令时只需修改配置文件而不需要修改源码
        Command command = new SkinPeelerCommand(new SkinPeelerHandler());
        // 将命令传给invoker
        button.setCommand(command);
        button.call();
    }
}