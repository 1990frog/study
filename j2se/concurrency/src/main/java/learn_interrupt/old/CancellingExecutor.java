package learn_interrupt.old;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;

interface CancellableTask<T> extends Callable<T> {
    void cancel();
    RunnableFuture<T> newTask();
}

public class CancellingExecutor extends ThreadPoolExecutor {

    public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected<T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        }else{
            return super.newTaskFor(callable);
        }
    }
}

/**
 * SocketUsingTask 通过自己的 Future 来取消
 * 关闭底层的 Socket 并中断线程
 *
 * 因此它提高了任务对取消操作的响应性：不仅能够在调用可中断方法的同时确保响应取消操作，而且还能中断IO
 *
 * @param <T>
 */
abstract class SocketUsingTask<T> implements CancellableTask<T> {

    private Socket socket;

    protected synchronized void setSocket(Socket s) {
        socket = s;
    }

    public synchronized void cancel() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {}
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    SocketUsingTask.this.setSocket(socket);
                } finally {
                    return super.cancel(mayInterruptIfRunning);
                }
            }
        };
    }

}