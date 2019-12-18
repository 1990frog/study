package builder.demo5;


/**
 * 示例代码只是传入四个参数，如果参数是十四个甚至更多，builder 模式的优势将会更加明显，传递参数更加灵活，代码具有更高的可读性.
 *
 * 一般的套路：优点是比较简单，开发效率高，缺点是如果参数真的很多的话鬼知道每个对应的是什么意思啊。
 * Builder模式：优点是可以将构造器的setter方法名取成类似注释的方式，这样我们可以很清晰的知道刚才究竟设置的什么值，可读性较高，缺点是比较冗长。
 */
public class App {
    public static void main(String[] args) {
        // 非 Builder 模式
        Computer computer = new Computer("cpu","screen","memory","mainboard");
        // Builder 模式
        NewComputer newComputer = new NewComputer.Builder()
                .cpu("cpu")
                .screen("screen")
                .memory("memory")
                .mainboard("mainboard")
                .build();
    }
}
