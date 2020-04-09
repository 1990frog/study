package javase.base.concurrency.mydemo.core.volatiles;

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
