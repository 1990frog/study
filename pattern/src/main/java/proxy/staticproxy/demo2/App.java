package proxy.staticproxy.demo2;

public class App {

    public static void main(String[] args) {
        KillProxy proxy = new KillProxy(new Killer());
        proxy.kill();
    }
}
