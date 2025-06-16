package learn_interrupt.old;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class IOInterruptDemo extends Thread {
    private final Socket socket;
    private final InputStream in;

    public IOInterruptDemo(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt(){
        try {
            socket.close();
        } catch (IOException ignored) {}
        finally {
            super.interrupt();
        }
    }

    public void run(){
        try {
            byte[] buffer = new byte[1024];
            while (true){
                int count = in.read(buffer);
                if(count < 0){
                    break;
                } else if (count > 0) {
                    // processBuffer(buf, count)
                }
            }
        } catch (IOException e) {
            // 允许线程退出
        }
    }
}
