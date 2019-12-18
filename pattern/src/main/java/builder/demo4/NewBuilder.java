package builder.demo4;

/**
 * 上面示例是 Builder模式的常规用法，导演类 Director 在 Builder模式中具有很重要的作用，它用于指导具体构建者如何构建产品，
 * 控制调用先后次序，并向调用者返回完整的产品类，但是有些情况下需要简化系统结构，可以把Director和抽象建造者进行结合
 *
 * 改造后的抽象建造者：
 *
 * 这样做确实简化了系统结构，但同时也加重了抽象建造者类的职责，也不是太符合单一职责原则，如果construct() 过于复杂，
 * 建议还是封装到 Director 中。除了上面的用途外，还有另外一个常用的使用方式，就是当一个类构造器需要传入很多参数时，
 * 如果创建这个类的实例，代码可读性会非常差，而且很容易引入错误，此时就可以利用 builder模式进行重构
 */
public abstract class NewBuilder {

    abstract void buildFrame();
    abstract void buildSeat();
    abstract void buildTire();
    abstract Bike createBike();
    /**
     * 把导演类中的construct()方法合并到抽象建造者类中
     *
     * @return 具体产品对象
     */
    public Bike construct() {
        this.buildFrame();
        this.buildSeat();
        this.buildTire();
        return this.createBike();
    }
}
