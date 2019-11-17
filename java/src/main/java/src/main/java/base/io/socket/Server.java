package src.main.java.base.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        final int DEFAULT_PORT = 8888;
        String QUIT = "quit";
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            while (true) {
                Socket socket = serverSocket.accept();//阻塞函数
                System.out.println("客户端端口[" + socket.getPort() + "]已连接");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));

                String msg = null;
                while ((msg = reader.readLine()) != null) {
                    System.out.println("客户端消息[" + msg + "]");
                    writer.write("hello socket\n");
                    writer.flush();
                    if(QUIT.equals(msg)){
                        System.out.println("客户端["+socket.getPort()+"]已经断开链接");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
