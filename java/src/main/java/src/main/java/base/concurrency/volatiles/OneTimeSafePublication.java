package src.main.java.base.concurrency.volatiles;

/**
 *  一次性安全发布（one-time safe publication）
 */
public class OneTimeSafePublication {

    private OneTimeSafePublication instance;

    public OneTimeSafePublication getInstance(){
        if(instance==null){
            instance = new OneTimeSafePublication();
        }
        return instance;
    }

}
