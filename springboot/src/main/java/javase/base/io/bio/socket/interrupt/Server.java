package javase.base.io.bio.socket.interrupt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int DEFAULT_PORT = 8888;
    static final String QUIT = "quit";
    private static ServerSocket serverSocket = null;

    public static void create(){
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

    public static void main(String[] args) throws InterruptedException, IOException {
        Thread thread = new Thread(()->create());
        thread.start();
        Thread.sleep(2000);
        System.out.println("执行请求中断");
        thread.interrupt();
        if(thread.isInterrupted()){
            serverSocket.close();
            System.out.println("关闭socket");
        }

    }
}
