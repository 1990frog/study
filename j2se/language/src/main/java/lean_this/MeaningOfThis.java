package lean_this;

public class MeaningOfThis {
    public final int value = 4;
    public void doIt(){
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(value);
            }
        };
        r.run();
    }

    // this 指的是包含它的Runnable，而不是外面的类MeaningOfThis
    public static void main(String[] args) {
        MeaningOfThis meaningOfThis = new MeaningOfThis();
        meaningOfThis.doIt();
    }
}
