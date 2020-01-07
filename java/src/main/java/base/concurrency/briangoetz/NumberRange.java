package base.concurrency.briangoetz;


/**
 * The variable does not participate in invariants with other variables.
 *
 * 两个变化的变量存在不等式关系
 *
 */
public class NumberRange implements Runnable{

    private int lower, upper;

    public int getLower() { return lower; }
    public int getUpper() { return upper; }

    public void setLower(int value) {
        if (value > upper)
            throw new IllegalArgumentException();
        lower = value;
    }

    public void setUpper(int value) {
        if (value < lower)
            throw new IllegalArgumentException();
        upper = value;
    }

    /**
     * static 修饰 volatile
     * final 修饰 volatile
     * Runnable类中调用内部变量（非静态）
     */
    @Override
    public void run() {
        while (true){
            setLower(upper);
            setUpper(++upper);
        }
    }

    public static void main(String[] args) {
        Runnable run = new NumberRange();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

}