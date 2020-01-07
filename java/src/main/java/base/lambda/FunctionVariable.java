package base.lambda;

/**
 * {{传递函数变量}}
 * <p>
 * Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。
 * <p>
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 * <p>
 * 使用 Lambda 表达式可以使代码变的更加简洁紧凑。
 * <p>
 * 使用 Lambda 表达式需要注意以下两点：
 * <p>
 * Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。在上面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。
 * Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 */
public class FunctionVariable {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        FunctionVariable tester = new FunctionVariable();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    /**
     * The interface Math operation.
     */
    @FunctionalInterface
    interface MathOperation {
        /**
         * Operation int.
         *
         * @param a the a
         * @param b the b
         * @return the int
         */
        int operation(int a, int b);
    }

    /**
     * The interface Greeting service.
     */
    @FunctionalInterface
    interface GreetingService {
        /**
         * Say message.
         *
         * @param message the message
         */
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){//将Lambda表达式作为参数传递
        return mathOperation.operation(a, b);
    }
}
