package command.demo3;

/**
 * 在命令模式中，可以通过调用一个命令对象的execute()方法来实现对请求的处理，如果需要撤销(undo)请求，可通过在命令类中增加一个逆向操作来实现。
 *
 * 除了通过一个逆向操作来实现撤销(undo)外，还可以通过保存对象的历史状态来实现撤销，后者可使用备忘录模式(Memento Pattern)来实现。
 *
 * 以控制一个游戏角色向前走为例说明。
 *
 */
public interface Command {
    void execute();
    void undo();
}
