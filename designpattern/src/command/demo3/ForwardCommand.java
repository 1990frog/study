package command.demo3;

public class ForwardCommand implements Command {

    private Role role;

    public ForwardCommand(Role role) {
        this.role = role;
    }

    @Override
    public void execute() {
        role.forward();
    }

    @Override
    public void undo() {
        role.back();
    }
}

