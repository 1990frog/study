package base.concurrency.moocwukong.juc.cas;

public class CasCounter {

    private SimulatedCAS value;

    public CasCounter(){
        value = new SimulatedCAS();
    }

    public int getValue(){
        return value.get();
    }

    public int increment(){
        int v;
        do {
            v = value.get();
        }while (v != value.compareAndSwap(v,v+1));
        return v+1;
    }

    public static void main(String[] args) {
        CasCounter cc = new CasCounter();
        System.out.println(cc.increment());
    }
}
