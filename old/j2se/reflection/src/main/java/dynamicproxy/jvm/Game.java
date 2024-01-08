package dynamicproxy.jvm;
/**
 * jvm动态代理必须基于接口
 */
public interface Game {
    void play();

    static void difficulty(){
        System.out.println("设置难度");
    }

    default void display(){
        System.out.println("设置分辨率");
    }
}
