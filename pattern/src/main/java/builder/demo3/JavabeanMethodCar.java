package builder.demo3;

import lombok.Getter;
import lombok.Setter;

/**
 * 提供无参的构造函数，暴露一些公共的方法让用户自己去设置对象属性，这种方法较之第一种似乎增强了灵活度，用户可以根据自己的需要随意去设置属性。
 *
 * 但是这种方法自身存在严重的缺点：
 * 因为构造过程被分到了几个调用中，在构造中 JavaBean 可能处于不一致的状态。
 * 类无法仅仅通过判断构造器参数的有效性来保证一致性。还有一个严重的弊端是，
 * JavaBeans 模式阻止了把类做成不可变的可能。这就需要我们付出额外的操作来保证它的线程安全。
 *
 */
@Setter
@Getter
public class JavabeanMethodCar {
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

}
