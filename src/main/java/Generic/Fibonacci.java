package Generic;

/**
 * 这里注意到，虽然在Fibonacci里面使用的都是int类型，但是其参数类型确是Integer。
 * 这是因为Java泛型的局限性：基本类型无法作为类型参数。
 * 但是Java SE5提供了自动包装和拆包的功能，可以很方便地在基本类型和其相应的包装器类型之间进行转换。
 */
public class Fibonacci implements Generator<Integer> {

    private int count = 0;

    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(gen.next() + " ");
        }
    }
}

