package pattern.command.demo3;

/**
 * 结果：
 * 向前走10步！
 * 后退10步！
 *
 * 需要注意的是在本实例中只能实现一步撤销操作，
 * 因为没有保存命令对象的历史状态，
 * 可以通过引入一个命令集合或其他方式来存储每一次操作时命令的状态，
 * 从而实现多次撤销操作。
 * 除了Undo操作外，
 * 还可以采用类似的方式实现恢复(Redo)操作，
 * 即恢复所撤销的操作（或称为二次撤销）。
 */
public class Client {
    public static void main(String[] args) {
        OperatorInterface operator = new OperatorInterface();
        Command command = new ForwardCommand(new Role());
        operator.setCommand(command);
        operator.operate();
        operator.reset();
    }
}
