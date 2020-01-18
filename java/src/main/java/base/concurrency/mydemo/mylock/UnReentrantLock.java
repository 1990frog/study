package base.concurrency.mydemo.mylock;

public class UnReentrantLock {

    public class Lock{
        private boolean isLocked = false;
        public synchronized void lock() throws InterruptedException{
            while(isLocked){
                wait();
            }
            isLocked = true;
        }
        public synchronized void unlock(){
            isLocked = false;
            notify();
        }
    }

    private Lock lock = new Lock();

    public void test(int var) throws InterruptedException {
        if(var<3){
            lock.lock();
            System.out.println(var++);
            test(var++);
            lock.unlock();
            System.out.println(var);
        }
    }

    public static void main(String[] args) {
        UnReentrantLock unReentrantLock = new UnReentrantLock();
        try {
            unReentrantLock.test(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
