package pattern.command.demo4;

/**
 * 具体插入命令类
 *
 */
public class InsertCommand extends Command {
    private static final long serialVersionUID = -6239610676788773397L;

    public InsertCommand(String name) {
        super(name);
    }

    public void execute(String args) {
        this.args = args;
        operator.insert(args);
    }
}
