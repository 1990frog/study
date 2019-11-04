package src.main.java.base.concurrency.moocwukong.tasktimeout;

/**
 *
 * 先解释另一个常识，即当前线程（后面称为目标线程，因为它是我们想使其超时结束的目标任务）的创建及start的调用，
 * 一定是在另一个线程中进行的（最起码是main线程，也可以是不同于main线程的其他线程）这里我们假设为main线程，
 * 并且称之为依赖线程，因为目标线程的创建是在他里面执行的。
 *
 * 介绍完这些常识就可以进一步解释了，join的字面意思是，使目标线程加入到依赖线程中去，
 * 也可以理解为在依赖线程中等待目标线程一直执行直至结束（如果没有设置超时参数的话）。
 * 设置了超时参数（假设为5秒）就会这样执行，在依赖线程中调用了join之后，相当于告诉依赖线程，
 * 现在我要插入到你的线程中来，即两个线程合二为一，相当于一个线程（如果不执行插入的话，那目标线程和依赖线程就是并行执行），
 * 而且目标线程是插在主线程前面，所以目标线程先执行，但你主线程只需要等我5秒，5秒之后，不管我有没有执行完毕，我们两都分开，
 * 这时又会变成两个并行执行的线程，而不是目标线程直接结束执行，这点很重要。
 *
 * 其实这个方法比较牵强，因为它主要作用是用来多个线程之间进行同步的。
 * 但因为它提供了这个带参数的方法（所以这也给了我们一个更广泛的思路，
 * 就是一般带有超时参数的方法我们都可以尝试着用它来实现超时结束任务），
 * 所以我们可以用它来实现。注意这里的参数的单位是固定的毫秒，不同于接下来的带单位的函数。
 *
 * 在主线程中等待t1执行2秒之后，要interrupt掉它（而不是直接调用stop，这个方法已经被弃用），
 * 然后在t1里面会产出一个中断异常，在异常里面处理完该处理的事，就要return，一定要return，如果不return的话，
 * t1还会继续执行，只不过是与主线程并行执行。
 */
public class JoinTest implements Runnable {

    public String name;
    private int time;

    public JoinTest(String s, int t) {
        name = s;
        time = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < time; ++i) {
            System.out.println("task " + name + " " + (i + 1) + " round");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name + "is interrupted when calculating, will stop...");
                return; // e.printStackTrace(); 你好骚啊！
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest task1 = new JoinTest("one", 4);
        JoinTest task2 = new JoinTest("two", 2);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t1.join(2000); // 在主线程中等待t1执行2秒
        t1.interrupt(); // 这里很重要，一定要打断t1,因为它已经执行了2秒。

        t2.start();
        t2.join(1000);
        t2.interrupt();

    }
}

