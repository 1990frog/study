package springboot.component.except;

import java.net.ServerSocket;

public class MySocket {

    /**
     * 占用8080接口，让springboot无法占用，让其触发启动异常报告器
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        serverSocket.accept();
    }

}
