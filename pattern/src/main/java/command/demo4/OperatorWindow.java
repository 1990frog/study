package command.demo4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 请求发送者
 */
public class OperatorWindow {
    // 定义一个集合来存储每一次操作时的命令对象
    private List<Command> commands = new ArrayList<Command>();
    private Command command;

    // 设置具体命令对象
    public void setCommand(Command command) {
        this.command = command;
    }

    // 执行命令，同时将命令对象添加到命令集合中
    public void call(String args) {
        command.execute(args);
        commands.add(command);
    }

    // 记录请求日志，将命令集合写入日志文件
    public void save() {
        FileUtil.writeCommands(commands);
    }

    // 从日志文件中提取命令集合，并调用所有命令的execute()方法来实现命令的重新执行
    public void recover() {
        List<Command> commands = FileUtil.readCommands();

        for (Command command : commands) {
            command.execute();
        }
    }
}

