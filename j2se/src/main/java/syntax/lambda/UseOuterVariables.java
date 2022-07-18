package syntax.lambda;

/**
 * {{使用外部变量}}
 * <p>
 * 为什么要限制我们直接使用外部的局部变量呢？主要原因在于内存模型，我们都知道实例变量在堆上分配的，
 * 而局部变量在栈上进行分配，lambda 表达式运行在一个独立的线程中，了解 JVM 的同学应该都知道栈内存
 * 是线程私有的，所以局部变量也属于线程私有，如果肆意的允许 lambda 表达式引用局部变量，可能会存在
 * 局部变量以及所属的线程被回收，而 lambda 表达式所在的线程却无从知晓，这个时候去访问就会出现错误，
 * 之所以允许引用事实上的 final（没有被声明为 final，但是实际中不存在更改变量值的逻辑），是因为对
 * 于该变量操作的是变量副本，因为变量值不会被更改，所以这份副本始终有效。这一限制可能会让刚刚开始接
 * 触函数式编程的同学不太适应，需要慢慢的转变思维方式。
 * <p>
 * 实际上在 java 8th 之前，我们在方法中使用内部类时就已经遇到了这样的限制，因为生命周期的限制 JVM
 * 采用复制的策略将局部变量复制一份到内部类中，但是这样会带来多个线程中数据不一致的问题，于是衍生了
 * 禁止修改内部类引用的外部局部变量这一简单、粗暴的策略，只不过在 8th 之前必须要求这部分变量采用 final 修饰，
 * 但是 8th 开始放宽了这一限制，只要求所引用变量是 “事实上” 的 final 类型即可。
 * <p>
 * 需要注意的是，可以在 Lambda 表达式中引用的变量必须是声明为 final 或是实际上 final（effectively final）的。
 * 实际上 final 的意思是变量虽然没有声明为 final，但是在初始化之后没有被赋值。因此变量的值没有改变。
 */
public class UseOuterVariables {

    /**
     * The constant salutation.
     */
    final static String salutation = "Hello! ";
//    static String salutation = "Hello! ";

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");
    }

    /**
     * The interface Greeting service.
     */
    interface GreetingService {
        /**
         * Say message.
         *
         * @param message the message
         */
        void sayMessage(String message);
    }
}
