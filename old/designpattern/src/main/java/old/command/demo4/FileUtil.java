package old.command.demo4;

import java.io.*;
import java.util.List;

/**
 * 文件操作类
 */
public class FileUtil {

    public static void writeCommands(List<Command> commands) {
        try {
            FileOutputStream fos = new FileOutputStream("operator.log");
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));
            oos.writeObject(commands);
            oos.close();
        } catch (Exception e) {
            System.out.println("writeCommands error!");;
        }
    }

    public static List<Command> readCommands() {
        try {
            FileInputStream fis = new FileInputStream("operator.log");
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));
            @SuppressWarnings("unchecked")
            List<Command> commands = (List<Command>) ois.readObject();
            ois.close();
            return commands;
        } catch (Exception e) {
            System.out.println("readCommands error!");
            return null;
        }
    }
}
