package pattern.command.demo2;

public class CloseCommand implements Command {

    private CloseHandler handler;

    private CloseCommand(CloseHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.close();
    }
}