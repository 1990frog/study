package pattern.command.demo3;

public class OperatorInterface {
    private Command command;

    public void operate() {
        command.execute();
    }

    public void reset() {
        command.undo();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
