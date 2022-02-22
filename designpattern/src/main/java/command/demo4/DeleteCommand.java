package command.demo4;

/**
 * 具体删除命令类
 *
 */
public class DeleteCommand extends Command {

    private static final long serialVersionUID = -4259959904986587353L;

    public DeleteCommand(String name) {
        super(name);
    }

    public void execute(String args) {
        this.args = args;
        operator.delete(args);
    }
}
