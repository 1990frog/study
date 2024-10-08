package learn_semaphore;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 将任何一种容器变成有界阻塞容器，信号量的计数值会初始化为容器的最大值。add操作在向底层容器中添加一个元素之前，首先要获取一个许可。
 * 如果add操作没有添加任何元素，那么会立刻释放。同样，remove操作会释放一个许可，使更多的元素能够添加到容器中。
 * 底层的set实现并不知道关于边界的任何信息。
 * @param <T>
 */
public class BoundedHashSet<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T t) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            // set 是同步容器
            wasAdded = set.add(t);
            return wasAdded;
        } finally {
            if (!wasAdded) {
                sem.release();
            }
        }
    }

    public boolean remove(T t) throws InterruptedException {
        boolean wasRemoved = set.remove(t);
        if (wasRemoved) {
            sem.release();
        }
        return set.remove(t);
    }


}
