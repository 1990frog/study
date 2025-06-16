package juc.cas;

/**
 * 描述：
 * 模拟CAS操作，等价代码
 */
public class SimulatedCAS {
    private volatile int value = 1;

    public synchronized int get(){
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }
}
