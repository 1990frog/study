package src.main.java.base.io.socket.interrupt;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        final String DEFAULT_SERVER_HOST = "127.0.0.1";
        final int DEFAULT_SERVER_PORT = 8888;
        String QUIT = "quit";
        BufferedWriter writer = null;
        try {
            Socket socket = new Socket(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                String input = consoleReader.readLine();
                writer.write(input + "\n");
                writer.flush();
                String msg = reader.readLine();
                if (msg != null) {
                    System.out.println(msg);
                }
                if(QUIT.equals(input)){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {//直接关闭write，同时会关闭socket并flush？
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
