package base.lambda;


/**
 * 目标类型
 * Lambda 表达式没有类型信息。一个 Lambda 表达式的类型由编译器根据其上下文环境在编译时刻推断得来。举例来说，Lambda 表达式 () -> System.out.println("Hello World!") 可以出现在任何要求一个函数式接口实例的上下文中，只要该函数式接口的唯一方法不接受任何参数，并且返回值是 void。这可能是 Runnable 接口，也可能是来自第三方库或应用代码的其他函数式接口。由上下文环境所确定的类型称为目标类型。Lambda 表达式在不同的上下文环境中可以有不同的类型。类似 Lambda 表达式这样，类型由目标类型确定的表达式称为多态表达式（poly expression）。
 * <p>
 * Lambda 表达式的语法很灵活。它们的声明方式类似 Java 中的方法，有形式参数列表和主体。参数的类型是可选的。在不指定类型时，由编译器通过上下文环境来推断。Lambda 表达式的主体可以返回值或 void。返回值的类型必须与目标类型相匹配。当 Lambda 表达式的主体抛出异常时，异常的类型必须与目标类型的 throws 声明相匹配。
 * <p>
 * 由于 Lambda 表达式的类型由目标类型确定，在可能出现歧义的情况下，可能有多个类型满足要求，编译器无法独自完成类型推断。这个时候需要对代码进行改写，以帮助编译器完成类型推断。一个常见的做法是显式地把 Lambda 表达式赋值给一个类型确定的变量。另外一种做法是显示的指定类型。
 * <p>
 * 在清单 3 中，函数式接口 A 和 B 分别有方法 a 和 b。两个方法 a 和 b 的类型是相同的。类 UseAB 的 use 方法有两个重载形式，分别接受类 A 和 B 的对象作为参数。在方法 targetType 中，如果直接使用 () -> System.out.println("Use") 来调用 use 方法，会出现编译错误。这是因为编译器无法推断该 Lambda 表达式的类型，类型可能是 A 或 B。这里通过显式的赋值操作为 Lambda 表达式指定了类型 A，从而可以编译通过。
 */
public class LambdaTargetType {

    /**
     * The interface A.
     */
    @FunctionalInterface
    interface A{
        /**
         * A.
         */
        void a();
    }

    /**
     * The interface B.
     */
    @FunctionalInterface
    interface B{
        /**
         * B.
         */
        void b();
    }

    /**
     * The type Use ab.
     */
    class UseAB{

        /**
         * Use.
         *
         * @param a the a
         */
        void use(A a){
            System.out.println("User A");
        }

        /**
         * Use.
         *
         * @param a the a
         */
        void use(B a){
            System.out.println("User B");
        }
    }

    /**
     * Target type.
     */
    void targetType(){
        UseAB useAB = new UseAB();
        A a = ()->System.out.println("use");
        useAB.use(a);
    }

}
