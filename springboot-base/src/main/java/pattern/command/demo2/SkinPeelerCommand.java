package pattern.command.demo2;

public class SkinPeelerCommand implements Command {
    private SkinPeelerHandler handler;

    public SkinPeelerCommand(SkinPeelerHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute() {
        handler.skinPeeler();
    }
}
