package adapter.classadapter.demo1;

public class App {

    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        mobile.charging(new VoltageAdapter());
    }
}
