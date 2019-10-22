[TOC]

# 创建线程的几种方法

1. 实现Runnable接口，重写run()函数，运行start()方法【真】
2. 继承Thread类，重写run()函数，运行start()方法【真】
3. Lumbda表达式
4. 匿名内部类
5. 线程池
6. 定时器（private final TimerThread thread = new TimerThread(queue);）
7. 通过Callable和FutureTask创建线程

## 总结

总结：最精准的描述 通常我们可以分为两类，Oracle也是这么说的  
准确的讲，创建线程只有一种方式那就是构建Thread类，而实现线程的执行单元有两种  

+ 方法一：实现Runnable接口的run方法，并把Runnable实例传给Thread类
+ 方法二：重写Thread的run方法（继承Thread类）

创建线程的方式根本上只有一种：Thread.start()，但是绑定Thread类target（持有Runnable对象）的方式有多种花样

# Runnable接口
Runnable抽象函数接口，其run方法为线程的执行体

```java
@FunctionalInterface
public interface Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see     java.lang.Thread#run()
     */
    public abstract void run();
}
```

## 实现Runnable接口好在哪里？

继承Thread是不推荐的，因为它有以下的一些缺点：

1.  从代码架构角度：具体的任务（run方法）应该和“创建和运行线程的机制（Thread类）”解耦，用runnable对象可以实现解耦。
2.  使用继承Thread的方式的话，那么每次想新建一个任务，只能新建一个独立的线程，而这样做的损耗会比较大（比如重头开始创建一个线程、执行完毕以后再销毁等。如果线程的实际工作内容，也就是run()函数里只是简单的打印一行文字的话，那么可能线程的实际工作内容还不如损耗来的大）。如果使用Runnable和线程池，就可以大大减小这样的损耗。
3.  继承Thread类以后，由于Java语言不支持双继承，这样就无法再继承其他的类，限制了可扩展性。

# Thread类
Thread是线程本身，启动线程调用Thread的start方法，其由native方法底层实现（启动新线程），如果直接调用run方法，等同在主线程中调用方法（非异步）。

```java
class Thread implements Runnable{
    ...
    public synchronized void start() {
        /**
         * This method is not invoked for the main method thread or "system"
         * group threads created/set up by the VM. Any new functionality added
         * to this method in the future may have to also be added to the VM.
         *
         * A zero status value corresponds to state "NEW".
         */
        if (threadStatus != 0)//调用两次start报错原因
            throw new IllegalThreadStateException();

        /* Notify the group that this thread is about to be started
         * so that it can be added to the group's list of threads
         * and the group's unstarted count can be decremented. */
        group.add(this);

        boolean started = false;
        try {
            start0();
            started = true;
        } finally {
            try {
                if (!started) {
                    group.threadStartFailed(this);
                }
            } catch (Throwable ignore) {
                /* do nothing. If start0 threw a Throwable then
                  it will be passed up the call stack */
            }
        }
    }
    ...
}
/**
 *run方法，其持有一个Runnable对象，如果直接继承Thread会重写run方法
 */
@Override
public void run() {
    if (target != null) {
        target.run();
    }
}
```

## start
start执行流程：

1. 检查线程状态，只有NEW状态下的线程才能继续，否则会抛出IllegalThreadStateException
2. 被加入线程组
3. 调用start()方法启动线程

注意点：

1. start方法是被synchronized修饰的方法，可以确保线程安全
2. 由JVM创建的main方法线程和system组线程，并不会通过start来启动

# ThreadPoolExecutor类：线程池

demo：

```java
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Task() {});
        }
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
```

部分源代码：

```java
@NotNull public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                  60L, TimeUnit.SECONDS,
                                  new SynchronousQueue<Runnable>());
}
```

newCachedThreadPool()只是收集参数，具体实现在submit native方法中

---

# 疑问
<font color="red">
需要更加细致了解的：  
Future<?> submit(Runnable task);应该看看源码  
线程池源码中submit  
Timmer源码  
Thread中start
</font>

