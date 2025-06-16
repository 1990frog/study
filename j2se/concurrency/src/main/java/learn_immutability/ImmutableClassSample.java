package learn_immutability;

/**
 * <p>
 * 当满足以下条件时，对象才是不可变的：
 * 1、对象创建以后其状态就不能修改
 * 2、对象的所有域都是 final 类型
 * 3、对象是正确创建的（在对象的创建期间，this 引用没有逸出）
 *
 *
 * tips：
 * JSR-133 增强了 final
 * 在旧的Java内存模型中，一个最严重的缺陷就是线程可以看到final域的值会改变。比如，一个线程当前看到一个整型final域的值为0(还未初始化之前的默认值)，过一段时间之后这个线程再去读这个final域的值时，却发现值变为1(被某个线程初始化之后的值)。最常见的例子就是在旧的Java内存模型中，String的值可能会改变
 * 为了修补这个漏洞，JSR-133专家组增强了final的语义。通过为final域增加写和读重排序规则，可以为Java程序员提供初始化安全保证：只要对象时正确构造的(被构造对象的引用在构造函数中没有"逸出")，那么不需要使用同步(指lock和volatile的使用)就可以保证任意线程都能看到这个final域在构造函数中被初始化之后的值
 * 要看到域，前提是必须获取该对象的引用。而获取到引用的时候，这个final域必定已经正确初始化，因此是安全的
 * </p>
 *
 * @since 2024/10/25
 */
public class ImmutableClassSample {

    private final int age;
    private final String name; //String 本身就是不可变类型
    public ImmutableClassSample(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
