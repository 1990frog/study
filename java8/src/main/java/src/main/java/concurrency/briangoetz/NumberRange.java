package src.main.java.concurrency.briangoetz;

import com.amazonaws.annotation.NotThreadSafe;

import java.util.Random;

/**
 * The variable does not participate in invariants with other variables.
 */
@NotThreadSafe
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
            System.out.println("lower:"+getLower()+",upper:"+getUpper());

//            synchronized (this){
//                setLower(upper);
//                setUpper(++upper);
//                System.out.println("lower:"+getLower()+",upper:"+getUpper());
//            }

        }
    }

    public static void main(String[] args) {
        Runnable run = new NumberRange();
        new Thread(run).start();
        new Thread(run).start();
    }

}