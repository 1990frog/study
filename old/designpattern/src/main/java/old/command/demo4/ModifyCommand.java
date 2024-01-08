package old.command.demo4;

/**
 * 具体修改命令类
 */
public class ModifyCommand extends Command {
    private static final long serialVersionUID = -4259959904986587353L;

    public ModifyCommand(String name) {
        super(name);
    }

    public void execute(String args) {
        this.args = args;
        operator.modify(args);
    }
}
