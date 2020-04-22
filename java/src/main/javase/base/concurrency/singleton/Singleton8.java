package javase.base.concurrency.singleton;

/**
 * 描述：
 * 枚举单例
 *
 * 在语言层面最简单的方法
 *
 * Java规范字规定，每个枚举类型及其定义的枚举变量在JVM中都是唯一的，因此在枚举类型的序列化和反序列化上，Java做了特殊的规定。
 */
public enum Singleton8 {

    INSTANCE;

    public void whatever() {

    }
}
