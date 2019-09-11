package builder.demo3;

/**
 * 通过构造器构建
 *
 * 假设一个场景：我们用一个class来表示车，车有一些必需的属性，比如：车身，轮胎，发动机，方向盘等。
 * 也有一些可选属性，假设超过10个，比如：车上的一些装饰，安全气囊等等非常多的属性。
 *
 * 如果我们用构造器来构造对象，我们的做法是 提供第一个包含4个必需属性的构造器，接下来再按可选属性依次重载不同的构造器，这样是可行的，但是会有以下一些问题：
 *
 * 一旦属性非常多，需要重载n多个构造器，而且各种构造器的组成都是在特定需求的情况下制定的，代码量多了不说，灵活性大大下降
 * 客户端调用构造器的时候，需要传的属性非常多，可能导致调用困难，我们需要去熟悉每个特定构造器所提供的属性是什么样的，而参数属性多的情况下，我们可能因为疏忽而传错顺序。
 */
public class ConstructorMethodCar {

    /**
     * 必须属性
     */
    private String carBody;//车身
    private String tyre;//轮胎
    private String engine;//发动机
    private String aimingCircle;//方向盘
    /**
     * 可选属性
     */
    private String decoration;//车内装饰品

    /**
     * 必需属性构造器
     * @param carBody
     * @param tyre
     * @param engine
     */
    public ConstructorMethodCar(String carBody, String tyre, String engine){
        this.carBody = carBody;
        this.tyre = tyre;
        this.engine = engine;
    }

    /**
     * 假如我们需要再添加车内装饰品，即在原来构造器基础上再重载一个构造器
     * @param carBody
     * @param tyre
     * @param engine
     * @param aimingCircle
     * @param decoration
     */
    public ConstructorMethodCar(String carBody, String tyre, String engine, String aimingCircle, String decoration) {
        this.carBody = carBody;
        this.tyre = tyre;
        this.engine = engine;
        this.aimingCircle = aimingCircle;
        this.decoration = decoration;
    }
}
