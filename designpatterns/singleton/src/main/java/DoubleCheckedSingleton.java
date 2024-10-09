/**
 * 双重检测
 *
 * 饿汉式不支持延迟加载，懒汉式有性能问题，不支持高并发。那我们再来看一种既支持延迟加载、又支持高并发的单例实现方式，也就是双重检测实现方式。在这种实现方式中，只要 instance 被创建之后，即便再调用 getInstance() 函数也不会再进入到加锁逻辑中了。所以，这种实现方式解决了懒汉式并发度低的问题。
 */
public class DoubleCheckedSingleton {

    // jdk9之后的版本，new操作和初始化设计为原子操作，自然能禁止重排序
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
    }

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    /**
                     * instance = new DoubleCheckedSingleton(); 实际上分为三个步骤：
                     * 1、申请一块内存空间，用来装 new 出来的对象；
                     * 2、初始化对象信息；
                     * 3、返回对象地址，建立连接。
                     * 这些指令可能发生重排序（低版本JDK），先执行了第3步，而第2步由于耗时过多还在执行，此时另一个线程执行，虽然判断出了 instance 不为空，可是直接返回的对象是 instance，这块地址的内容是不对的，可能是空指针，可能是错误的数据。
                     、
                     * 解决这个问题的方式是，使用volatile关键字，让修改值立即更新到主存
                     *
                     */
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
