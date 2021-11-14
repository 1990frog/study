package netty.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统socket
 */
public class SocketDemo {

    public void base(int portNumber) throws IOException {
        // 创建一个新的ServerSocket，用以监听指定端口上的连接请求
        ServerSocket serverSocket = new ServerSocket(portNumber);
        // accept()方法的调用将被阻塞，直到一个连接建立，随后返回一个新的Socket用户客户端和服务的之间的通信。
        // 该ServerSocket将继续监听传入的连接
        Socket clientSocket = serverSocket.accept();
        // BufferedReader和PrintWriter都衍生自Scoket的输入输出流，前者从一个字符输入流中读取文本，后者打印对象的格式化的数据到文本输出流
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        // readLine()将会阻塞，直到读取一个以换行符或回车符结尾的字符串
        while ((request = in.readLine()) != null){
            if("Done".equals(request)){
                break;
            }
            response = processRequest(request);
            out.println(response);
        }

    }

    public String processRequest(String request){
        return "process";
    }

    public static void main(String[] args) throws IOException {
        SocketDemo socketDemo = new SocketDemo();
        socketDemo.base(8888);
    }

}
